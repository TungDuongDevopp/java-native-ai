export default class Navbar {
    /**
     * Tự động tạo và chèn Navbar vào trang web.
     * @param {string} activeTab - Tên tab đang kích hoạt ('owner' | 'pet')
     */
    static render(activeTab = '') {
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
                            <img src="https://ui-avatars.com/api/?name=Admin+User&background=2e7d32&color=fff" alt="Avatar" class="avatar-img">
                            <div class="user-info">
                                <span class="user-name">Admin</span>
                                <span class="user-role">Quản trị viên</span>
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
        const btnChangePass = document.getElementById("btnChangePassword");

        if (btnLogout) {
            btnLogout.addEventListener("click", (e) => {
                e.preventDefault();
                alert("Đã đăng xuất! (Chức năng demo)");
            });
        }
        if (btnChangePass) {
            btnChangePass.addEventListener("click", (e) => {
                e.preventDefault();
                alert("Chức năng đổi mật khẩu (Demo)");
            });
        }
    }
}
