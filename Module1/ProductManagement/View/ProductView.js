export default class ProductView {

    /**
     * Render danh sách sản phẩm ra table
     * @param {Array} products - mảng sản phẩm
     * @param {Function} onEdit - callback khi bấm Sửa(id)
     * @param {Function} onDelete - callback khi bấm Xóa(id)
     */
    render(products, onEdit, onDelete) {
        let html = "";

        products.forEach(product => {
            html += `
                <tr>
                    <td>${product.id}</td>
                    <td>${product.name}</td>
                    <td>${product.price.toLocaleString("vi-VN")} đ</td>
                    <td>${product.quantity}</td>
                    <td>${product.description}</td>
                    <td>
                        <div class="btn">
                            <button class="edit" onclick="handleEdit(${product.id})">Sửa</button>
                            <button class="delete" onclick="handleDelete(${product.id})">Xóa</button>
                        </div>
                    </td>
                </tr>
            `;
        });

        document.querySelector("#productTable").innerHTML = html;

        // Gán các hàm xử lý vào window để onclick trong HTML gọi được
        window.handleEdit = onEdit;
        window.handleDelete = onDelete;
    }
}