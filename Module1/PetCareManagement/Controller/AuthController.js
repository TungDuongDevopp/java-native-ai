import AccountRepository from "../Repository/AccountRepository.js";
import AccountService from "../Service/AccountService.js";

const repository = new AccountRepository();
const service = new AccountService(repository);

// ========== Helper: xác định đang ở trang nào ==========
const isLoginPage = !!document.getElementById("loginForm");
const isRegisterPage = !!document.getElementById("registerForm");
const isForgotPasswordPage = !!document.getElementById("forgotPasswordForm");
const loggedInUser = localStorage.getItem("loggedInUser");

//============================Phần tử DOM ===============================================

//Phần tử dom của form
const loginForm = document.getElementById("loginForm");
const registerForm = document.getElementById("registerForm");
const forgotPasswordForm = document.getElementById("forgotPasswordForm");

//Phần tử dom ô input form đăng nhập
const loginUsername = document.getElementById("username");
const loginPassword = document.getElementById("password");

//Phần tử dom ô input form đăng ký
const signupUsername = document.getElementById("register-username");
const signupPassword = document.getElementById("register-password");

// ========== Xử lý ĐĂNG NHẬP ==========
if (isLoginPage) {
    // Nếu đã đăng nhập rồi thì redirect sang trang quản lý
    if (loggedInUser) {
        window.location.href = "Owner/index.html";
    }

    if (loginForm) {
        loginForm.addEventListener("submit", (e) => {
            e.preventDefault();

            try {
                let account = service.login(loginUsername.value.trim(), loginPassword.value.trim());
                if (account) {
                    alert(`Đăng nhập thành công! Xin chào ${account.username}`);
                    window.location.href = "Owner/index.html";
                } else {
                    alert("Tên đăng nhập hoặc mật khẩu không đúng!");
                }
            }
            catch (e) {
                alert(e.message)
            }
        });
    }
}

// ========== Xử lý ĐĂNG KÝ ==========
if (isRegisterPage) {

    //Chuyển hướng trang chủ nếu đã đăng nhập
    if (loggedInUser) {
        window.location.href = "Owner/index.html";
    }
    registerForm.addEventListener("submit", (e) => {
        e.preventDefault();

        const registerAccount = {
            username: signupUsername.value.trim(),
            password: signupPassword.value.trim()
        }
        try {
            service.saveAccount(registerAccount);
            alert("Đăng ký thành công! Vui lòng đăng nhập.");
            window.location.href = "login.html";
        }
        catch (e) {
            alert(e.message)
        }
    });

}

// ========== Xử lý ĐỔI MẬT KHẨU ==========

if (isForgotPasswordPage) {
    // Lấy username: ưu tiên URL param ?username=xxx, sau đó từ loggedInUser
    const urlParams = new URLSearchParams(window.location.search);
    let bindUsername = urlParams.get("username") || "";

    if (!bindUsername && loggedInUser) {
        try {
            const parsed = JSON.parse(loggedInUser);
            bindUsername = parsed.username || "";
        } catch (_) { }
    }

    // Bind username vào display và hidden input
    const usernameDisplay = document.getElementById("fp-username-display");
    const usernameHidden = document.getElementById("fp-username");

    if (usernameDisplay) usernameDisplay.textContent = bindUsername || "(chưa có thông tin)";
    if (usernameHidden) usernameHidden.value = bindUsername;

    // Xử lý submit form
    if (forgotPasswordForm) {
        forgotPasswordForm.addEventListener("submit", (e) => {
            e.preventDefault();

            const username = document.getElementById("fp-username").value.trim();
            const newPassword = document.getElementById("fp-new-password").value.trim();
            const confirmPassword = document.getElementById("fp-confirm-password").value.trim();

            if (!username) {
                alert("Không xác định được tài khoản. Vui lòng quay lại trang đăng nhập.");
                return;
            }

            if (newPassword !== confirmPassword) {
                alert("Mật khẩu xác nhận không khớp!");
                return;
            }

            try {
                service.changePassword(username, newPassword);
                alert("Đổi mật khẩu thành công! Vui lòng đăng nhập lại.");
                window.location.href = "login.html";
            } catch (e) {
                alert(e.message);
            }
        });
    }
}

// ========== Xử lý sự kiện từ Navbar ==========


document.addEventListener("navbar:logout", () => {
    localStorage.removeItem("loggedInUser");
    alert("Đăng xuất thành công!");
    window.location.href = "../login.html";
});

document.addEventListener("navbar:changePassword", () => {
    const currentUser = localStorage.getItem("loggedInUser");
    if (!currentUser) {
        window.location.href = "../login.html";
        return;
    }
    try {
        const parsed = JSON.parse(currentUser);
        const username = parsed.username || "";
        // Redirect sang trang đổi mật khẩu, bind username qua URL param
        window.location.href = `../forgot-password.html?username=${encodeURIComponent(username)}`;
    } catch (_) {
        window.location.href = "../forgot-password.html";
    }
});