import Navbar from "../View/Navbar.js";

// Khởi tạo Navbar với activeTab được set từ mỗi trang HTML
Navbar.render(window.ACTIVE_TAB || '');

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
        window.location.href = `../forgot-password.html?username=${encodeURIComponent(username)}`;
    } catch (_) {
        window.location.href = "../forgot-password.html";
    }
});
