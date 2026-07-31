import AccountRepository from "../Repository/AccountRepository.js";
import AccountService from "../Service/AccountService.js";

const repository = new AccountRepository();
const service = new AccountService(repository);

// ========== Helper: xác định đang ở trang nào ==========
const isLoginPage = !!document.getElementById("loginForm");
const isRegisterPage = !!document.getElementById("registerForm");

// ========== Bảo vệ index.html: nếu chưa login thì redirect ==========
const btnLogout = document.getElementById("btnLogout");
if (btnLogout) {
    const loggedIn = localStorage.getItem("loggedInUser");
    if (!loggedIn) {
        alert("Bạn chưa đăng nhập! Vui lòng đăng nhập.");
        window.location.href = "login.html";
    }

    // Hiện tên user đang đăng nhập
    const userDisplay = document.getElementById("userDisplay");
    if (userDisplay) {
        const user = JSON.parse(loggedIn);
        userDisplay.innerText = `Xin chào, ${user.username}!`;
    }

    // Xử lý Logout
    btnLogout.addEventListener("click", () => {
        localStorage.removeItem("loggedInUser");
        alert("Đăng xuất thành công!");
        window.location.href = "login.html";
    });
}

// ========== Xử lý ĐĂNG NHẬP ==========
if (isLoginPage) {
    // Nếu đã đăng nhập rồi thì redirect luôn sang index
    if (localStorage.getItem("loggedInUser")) {
        window.location.href = "index.html";
    }

    const loginForm = document.getElementById("loginForm");
    const inputUsername = document.getElementById("username");
    const inputPassword = document.getElementById("password");

    loginForm.addEventListener("submit", (e) => {
        e.preventDefault();

        const username = inputUsername.value.trim();
        const password = inputPassword.value.trim();

        if (!username || !password) {
            alert("Vui lòng nhập đầy đủ username và password!");
            return;
        }

        const account = service.login(username, password);

        if (account) {
            localStorage.setItem("loggedInUser", JSON.stringify(account));
            alert(`Đăng nhập thành công! Xin chào ${account.username}`);
            window.location.href = "index.html";
        } else {
            alert("Tên đăng nhập hoặc mật khẩu không đúng!");
        }
    });
}

// ========== Xử lý ĐĂNG KÝ ==========
if (isRegisterPage) {
    // Nếu đã đăng nhập rồi thì redirect luôn sang index
    if (localStorage.getItem("loggedInUser")) {
        window.location.href = "index.html";
    }

    const registerForm = document.getElementById("registerForm");
    const inputUsernameRegister = document.getElementById("register-username");
    const inputPasswordRegister = document.getElementById("register-password");

    registerForm.addEventListener("submit", (e) => {
        e.preventDefault();

        const username = inputUsernameRegister.value.trim();
        const password = inputPasswordRegister.value.trim();

        if (!username || !password) {
            alert("Vui lòng nhập đầy đủ username và password!");
            return;
        }

        if (username.length < 3) {
            alert("Username phải có ít nhất 3 ký tự!");
            return;
        }

        if (password.length < 6) {
            alert("Password phải có ít nhất 6 ký tự!");
            return;
        }

        if (service.isUsernameExist(username)) {
            alert("Username này đã tồn tại! Vui lòng chọn username khác.");
            return;
        }

        service.saveAccount({ username, password });
        alert("Đăng ký thành công! Vui lòng đăng nhập.");
        window.location.href = "login.html";
    });
}