import ProductRepository from "../Repository/ProductRepository.js";
import ProductService from "../Service/ProductService.js";
import ProductView from "../View/ProductView.js";

const repository = new ProductRepository();
const productService = new ProductService(repository);
const productView = new ProductView();

// ========== Các phần tử DOM ==========
const btnAdd        = document.getElementById("btnAdd");
const btnCancel     = document.getElementById("btnCancel");
const formContainer = document.getElementById("formContainer");
const formTitle     = document.getElementById("formTitle");
const productForm   = document.getElementById("productForm");
const inputName     = document.getElementById("name");
const inputPrice    = document.getElementById("price");
const inputQuantity = document.getElementById("quantity");
const inputDescription = document.getElementById("description");

// id của sản phẩm đang được sửa, null = đang thêm mới
let editingId = null;

// ========== Hàm hiển thị danh sách ==========
function showProducts() {
    const products = productService.getAllProduct();
    productView.render(products, editProduct, deleteProduct);
}

// ========== Hiện / Ẩn form ==========
function showForm(title = "Thêm sản phẩm") {
    formTitle.innerText = title;
    formContainer.style.display = "block";
}

function hideForm() {
    formContainer.style.display = "none";
    productForm.reset();
    editingId = null;
}

// ========== Điền dữ liệu vào form khi sửa ==========
function fillForm(product) {
    inputName.value     = product.name;
    inputPrice.value    = product.price;
    inputQuantity.value = product.quantity;
    inputDescription.value = product.description;
}

// ========== Xử lý THÊM sản phẩm ==========
btnAdd.addEventListener("click", () => {
    editingId = null;
    productForm.reset();
    showForm("Thêm sản phẩm");
});

// ========== Xử lý HỦY ==========
btnCancel.addEventListener("click", () => {
    hideForm();
});

// ========== Xử lý SUBMIT form (Thêm hoặc Sửa) ==========
productForm.addEventListener("submit", (e) => {
    e.preventDefault();

    const name     = inputName.value.trim();
    const price    = parseFloat(inputPrice.value);
    const quantity = parseInt(inputQuantity.value);
    const description = inputDescription.value.trim();

    // Validate đơn giản
    if (!name) {
        alert("Vui lòng nhập tên sản phẩm!");
        return;
    }
    if (isNaN(price) || price < 0) {
        alert("Vui lòng nhập giá hợp lệ!");
        return;
    }
    if (isNaN(quantity) || quantity < 0) {
        alert("Vui lòng nhập số lượng hợp lệ!");
        return;
    }
    if (!description){
        alert("Vui lòng nhập mô tả sản phẩm!");
        return;
    }

    if (editingId === null) {
        // --- THÊM MỚI ---
        const newProduct = { name, price, quantity, description };
        productService.saveProduct(newProduct);
        alert("Thêm sản phẩm thành công!");
    } else {
        // --- CẬP NHẬT ---
        const existing = productService.getProductById(editingId);
        const updatedProduct = {
            id: editingId,
            name,
            price,
            quantity,
            description: existing ? existing.description : ""
        };
        productService.updateProduct(updatedProduct);
        alert("Cập nhật sản phẩm thành công!");
    }

    hideForm();
    showProducts();
});

// ========== Xử lý SỬA sản phẩm ==========
function editProduct(id) {
    const product = productService.getProductById(id);
    if (!product) return;

    fillForm(product);
    editingId = id;
    showForm("Cập nhật sản phẩm");
}

// ========== Xử lý XÓA sản phẩm ==========
function deleteProduct(id) {
    const confirmed = confirm("Bạn có chắc muốn xóa sản phẩm này không?");
    if (!confirmed) return;

    productService.deleteProduct(id);
    showProducts();
}

// ========== Khởi chạy ==========
showProducts();