import Navbar from "../View/Navbar.js";

// Khởi tạo Navbar với activeTab được set từ mỗi trang HTML
Navbar.render(window.ACTIVE_TAB || '');


// ========== Xử lý sự kiện từ Navbar ==========

document.addEventListener("logout", () => {
    localStorage.removeItem("loggedInUser");
    alert("Đăng xuất thành công!");
    window.location.href = "../login.html";
});

document.addEventListener("changePassword", () => {
    const currentUser = localStorage.getItem("loggedInUser");
    if (!currentUser) {
        window.location.href = "../login.html";
        return;
    }
    window.location.href = "../change-password.html";
});
