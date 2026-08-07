export default class Navbar {

    static render(activeTab = '') {

        // Kiểm tra xem đã đăng nhập chưa
        const loggedInUser = localStorage.getItem("loggedInUser");

        if (!loggedInUser) {
            alert("Bạn chưa đăng nhập! Vui lòng đăng nhập để sử dụng hệ thống PetCare.");
            window.location.href = "../login.html";
            return;
        }

        let user = JSON.parse(loggedInUser);
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
                            <a class="dropdown-item" style="cursor: pointer" id="btnChangePassword">🔑 Đổi mật khẩu</a>
                            <hr class="dropdown-divider">
                            <a  class="dropdown-item logout" style="cursor: pointer" id="btnLogout">🚪 Đăng xuất</a>
                        </div>
                    </div>
                </div>
            </nav>
        `;

        // Chèn navbar vào vị trí đầu tiên của <body>
        document.body.insertAdjacentHTML('afterbegin', navHtml);

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
                document.dispatchEvent(new CustomEvent("navbar:logout"));
            });
        }

        const btnChangePass = document.getElementById("btnChangePassword");
        if (btnChangePass) {
            btnChangePass.addEventListener("click", (e) => {
                e.preventDefault();
                document.dispatchEvent(new CustomEvent("navbar:changePassword"));
            });
        }
    }
}
