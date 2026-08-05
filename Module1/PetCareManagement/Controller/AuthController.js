import AccountRepository from "../Repository/AccountRepository.js";
import AccountService from "../Service/AccountService.js";

const repository = new AccountRepository();
const service = new AccountService(repository);

// ========== Helper: xác định đang ở trang nào ==========
const isLoginPage = !!document.getElementById("loginForm");
const isRegisterPage = !!document.getElementById("registerForm");
const loggedInUser = localStorage.getItem("loggedInUser");

//============================Phần tử DOM ===============================================

//Phần tử dom của form
const loginForm = document.getElementById("loginForm");
const registerForm = document.getElementById("registerForm");

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

            try{
               let account = service.login(loginUsername.value.trim(), loginPassword.value.trim());
                if (account) {
                    alert(`Đăng nhập thành công! Xin chào ${account.username}`);
                    window.location.href = "Owner/index.html";
                } else {
                    alert("Tên đăng nhập hoặc mật khẩu không đúng!");
                }
            }
            catch (e){
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
            try{
                service.saveAccount(registerAccount);
                alert("Đăng ký thành công! Vui lòng đăng nhập.");
                window.location.href = "login.html";
            }
            catch (e){
                alert(e.message)
            }
        });

}