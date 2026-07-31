export default class Render {


    renderOwner(owners, onEdit, onDelete) {
        let content = "";

        owners.forEach(owner => {
            content += `
                <tr>
                    <td>${owner.id}</td>
                    <td>${owner.name}</td>
                    <td>${owner.phone}</td>
                    <td>${owner.email}</td>
                    <td>${owner.address}</td>
                    <td>
                        <div class="btn">
                            <button class="edit" onclick="editOwner(${owner.id})">Sửa</button>
                            <button class="delete" onclick="deleteOwner(${owner.id})">Xóa</button>
                        </div>
                    </td>
                </tr>
            `;
        });

        document.getElementById("ownerTable").innerHTML = content;

        // Gán các hàm xử lý vào window để onclick trong HTML gọi được
        window.editOwner = onEdit;
        window.deleteOwner = onDelete;
    }
}