import OwnerRepository from "../Repository/OwnerRepository.js";
import OwnerService from "../Service/OwnerService.js";
import Render from "../View/Render.js";
import PetService from "../Service/PetService.js";
import PetRepository from "../Repository/PetRepository.js";
import Navbar from "../View/Navbar.js";

// Khởi tạo Navbar cho trang Chủ thú cưng
Navbar.render("owner");

// ========== KHỞI TẠO ĐỐI TƯỢNG VÀ INJECT  ==========

const repository = new OwnerRepository();
const petRepository = new PetRepository();
const petService = new PetService(petRepository);
const service = new OwnerService(repository,petService);
const render = new Render();


//========== KHỞI TẠO CÁC PHẦN TỬ DOM (Khởi tạo bằng hằng số tránh khởi tạo nhiều ==========

    // Các phần tử Dom của table và form
    const formTitle = document.getElementById("formTitle");
    const formContainer = document.getElementById("formContainer");
    const ownerForm = document.getElementById("ownerForm");

    // Các phần tử Dom của các ô input
    const name= document.getElementById("name");
    const phone = document.getElementById("phone");
    const email = document.getElementById("email");
    const address = document.getElementById("address");

    // Các phần tử Dom của các ô button
    const btnAdd = document.getElementById("btnAdd");
    const btnCancel = document.getElementById("btnCancel");

//================================== HÀM THAO TÁC VS FORM (Do chung 1 form)====================================

let currentId = null; // Khởi tạo biến id hiện tại, nếu null là thêm mới và khác null là sửa

function showForm(id){
    if(id == null){
        formTitle.innerText = "Thêm thông tin";
    }
    else{
        formTitle.innerText = "Sửa thông tin";

    }
    formContainer.style.display="block";

}

function hideForm(){
    formContainer.style.display= "none";
    ownerForm.reset();
    currentId = null;
}

function fillForm(owner){
    name.value =  owner.name;
    phone.value = owner.phone;
    email.value = owner.email;
    address.value = owner.address;
}

//=======================================HÀM XỬ LÝ SỰ KIỆN===========================================================

// ========== Xử lý THÊM sản phẩm ==========
btnAdd.addEventListener("click", () => {
    currentId = null;
    ownerForm.reset();
    showForm(currentId);

});

// ========== Xử lý HỦY ==========
btnCancel.addEventListener("click", () => {
    hideForm();
});

//=============Xử lý khi người dùng submit form
ownerForm.addEventListener("submit",(event)=>{
    event.preventDefault();

    if(currentId == null){
        const newOwner = {
            name: name.value.trim(),
            phone: phone.value.trim(),
            email: email.value.trim(),
            address: address.value.trim()
        };
        try {
            service.createOwner(newOwner);
            alert("Thêm thành công");
            hideForm();
            showOwners();
        }
        catch (err){
            alert(err.message);
        }
    }
    else{
        const updateOwner = {
            id: Number(currentId),
            name: name.value.trim(),
            phone: phone.value.trim(),
            email: email.value.trim(),
            address: address.value.trim()
        };
        try {
            service.updateOwner(updateOwner);
            alert("Cập nhật thông tin thành công");
            hideForm();
            showOwners();
        }
        catch (err){
            alert(err.message);
        }
    }
})

//================================== CÁC HÀM THAO TÁC DỮ LIỆU VS HỆ THỐNG ============================================

//Hàm hiện thông tin
function showOwners(){
    const owners = service.getAllOwners();
    render.renderOwner(owners,editOwner,deleteOwner);
}

//Hàm sửa thông tin
function editOwner(id){
    const owner =  service.getOwnerById(id);
    if(!owner) return;
    currentId = id;
    showForm(currentId);
    fillForm(owner);

}

//Hàm xóa thông tin
function deleteOwner(id){
    const owner =  service.getOwnerById(id);
    if(!owner) return;
    const confirmed = confirm("Bạn có muốn xóa không?");
    if(!confirmed) return;
    try{
        service.deleteOwner(id);
        alert("Xóa thành công");
        showOwners();
    }
    catch (err){
        alert(err.message);
    }


}

//=======================================Khởi chạy hàm ban đầu=================================================
showOwners();