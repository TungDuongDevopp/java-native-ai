export default class Navbar {
    /**
     * Tự động tạo và chèn Navbar vào trang web & kiểm tra Authentication (Auth Guard).
     * @param {string} activeTab - Tên tab đang kích hoạt ('owner' | 'pet' | 'record')
     */
    static render(activeTab = '') {
        // ========== Auth Guard: Kiểm tra đăng nhập ==========
        const loggedInUserRaw = localStorage.getItem("loggedInUser");
        if (!loggedInUserRaw) {
            alert("Bạn chưa đăng nhập! Vui lòng đăng nhập để sử dụng hệ thống PetCare.");
            window.location.href = "../login.html";
            return;
        }

        let user = { username: "User" };
        try {
            user = JSON.parse(loggedInUserRaw);
        } catch (e) {
            console.error("Lỗi đọc thông tin đăng nhập:", e);
        }

        const avatarUrl = `https://ui-avatars.com/api/?name=${encodeURIComponent(user.username)}&background=2e7d32&color=fff&bold=true`;

        const navHtml = `
            <nav class="navbar">
                <div class="nav-container">
                    <a class="nav-brand" href="../Owner/index.html">🐾 PetCare</a>
                    <ul class="nav-links">
                        <li><a href="../Owner/index.html" class="nav-link ${activeTab === 'owner' ? 'active' : ''}">Chủ thú cưng</a></li>
                        <li><a href="../Pet/index.html" class="nav-link ${activeTab === 'pet' ? 'active' : ''}">Thú cưng</a></li>
                        <li><a href="../Health/index.html" class="nav-link ${activeTab === 'record' ? 'active' : ''}">Hồ sơ sức khỏe</a></li>
                    </ul>
                    <div class="user-profile">
                        <div class="avatar-container" id="userMenuBtn">
                            <img src="${avatarUrl}" alt="Avatar" class="avatar-img">
                            <div class="user-info">
                                <span class="user-name">${user.username}</span>
                                <span class="user-role">Thành viên</span>
                            </div>
                            <span class="dropdown-icon">▼</span>
                        </div>
                        <div class="dropdown-menu" id="userDropdown">
                            <a href="#" class="dropdown-item" id="btnChangePassword">🔑 Đổi mật khẩu</a>
                            <hr class="dropdown-divider">
                            <a href="#" class="dropdown-item logout" id="btnLogout">🚪 Đăng xuất</a>
                        </div>
                    </div>
                </div>
            </nav>
        `;

        // Chèn navbar vào vị trí đầu tiên của <body>
        document.body.insertAdjacentHTML('afterbegin', navHtml);

        // Đăng ký các sự kiện tương tác cho Dropdown User Profile
        this.#initEvents();
    }

    static #initEvents() {
        const userMenuBtn = document.getElementById("userMenuBtn");
        const userDropdown = document.getElementById("userDropdown");

        if (userMenuBtn && userDropdown) {
            userMenuBtn.addEventListener("click", (e) => {
                e.stopPropagation();
                userDropdown.classList.toggle("show");
            });

            document.addEventListener("click", (e) => {
                if (!userDropdown.contains(e.target) && !userMenuBtn.contains(e.target)) {
                    userDropdown.classList.remove("show");
                }
            });
        }

        const btnLogout = document.getElementById("btnLogout");
        if (btnLogout) {
            btnLogout.addEventListener("click", (e) => {
                e.preventDefault();
                localStorage.removeItem("loggedInUser");
                alert("Đăng xuất thành công!");
                window.location.href = "../login.html";
            });
        }

        const btnChangePass = document.getElementById("btnChangePassword");
        if (btnChangePass) {
            btnChangePass.addEventListener("click", (e) => {
                e.preventDefault();
                alert("Chức năng đổi mật khẩu đang được phát triển!");
            });
        }
    }
}
