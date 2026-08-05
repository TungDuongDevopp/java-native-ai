import PetRepository from "../Repository/PetRepository.js";
import PetService from "../Service/PetService.js";
import Render from "../View/Render.js";
import OwnerRepository from "../Repository/OwnerRepository.js";
import OwnerService from "../Service/OwnerService.js";
import Navbar from "../View/Navbar.js";
import HealthRepository from "../Repository/HealthRepository.js";
import HealthService from "../Service/HealthService.js";

// Khởi tạo Navbar cho trang Thú cưng
Navbar.render("pet");
const healthRepository = new HealthRepository();
const healthService = new HealthService(healthRepository);
const repository = new PetRepository();
const service = new PetService(repository,healthService);
const ownerRepository = new OwnerRepository();
const ownerService = new OwnerService(ownerRepository);
const render = new Render();


// Các phần tử Dom của các ô input
const ownerId = document.getElementById("ownerId");
const name = document.getElementById("name");
const species = document.getElementById("species");
const breed = document.getElementById("breed");

// Các phần tử Dom của các ô button
const btnAdd = document.getElementById("btnAdd");
const btnCancel = document.getElementById("btnCancel");

// Các phần tử Dom của table và form
const formTitle = document.getElementById("formTitle");
const formContainer = document.getElementById("formContainer");
const petForm = document.getElementById("petForm");

let currentId = null;

// Hàm nạp danh sách Owner ID vào dropdown select
function loadOwnerOptions(){
    const owners = ownerService.getAllOwners();
    if(owners.length === 0){
        ownerId.innerHTML = `<option value="">-- Chưa có chủ thú cưng --</option>`;
    } else {
        ownerId.innerHTML = owners.map(owner => `<option value="${owner.id}">${owner.id} - ${owner.name}</option>`).join("");
    }
}

// Lấy giá trị của radio button giới tính được chọn
function getSelectedGender(){
    const selected = document.querySelector('input[name="gender"]:checked');
    return selected ? selected.value : "";
}

//================================== HÀM THAO TÁC VS FORM (Do chung 1 form)====================================
function showForm(id){
    loadOwnerOptions();
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
    petForm.reset();
    currentId = null;
}

function fillForm(pet){
    ownerId.value = pet.ownerId;
    name.value =  pet.name;
    species.value = pet.species;
    breed.value = pet.breed;
    const genderRadio = document.querySelector(`input[name="gender"][value="${pet.gender}"]`);
    if(genderRadio){
        genderRadio.checked = true;
    }
}


//================================== CÁC HÀM THAO TÁC DỮ LIỆU VS HỆ THỐNG ============================================

function showPets(){
    const pets = service.getAllPets();
    render.renderPet(pets,editPet,deletePet);
}

function editPet(id){
    const currentPet = service.getPetById(id);
    if(!currentPet) return;
    currentId = id;
    showForm(currentId);
    fillForm(currentPet);

}

function deletePet(id){
    const currentPet = service.getPetById(id);
    if(!currentPet) return;
    const confirmed = confirm("Nếu xóa sẽ mất hết bản ghi sức khỏe pet đó, vẫn tiếp tục?");
    if(!confirmed) return;
    service.deletePet(id);
    alert("Xóa pet thành công");
    showPets();

}
//=======================================HÀM XỬ LÝ SỰ KIỆN===========================================================
//Xử lý khi nhấn khi thêm sản phẩm
btnAdd.addEventListener("click", () => {
    currentId = null;
    petForm.reset();
    showForm(currentId);

});
// Xử lý khi nhấn hủy
btnCancel.addEventListener("click", () => {
    hideForm();
});

// Xử lý khi người dùng submit form(Sửa, thêm)
petForm.addEventListener("submit",ev => {
    ev.preventDefault();
    const genderValue = getSelectedGender();

    if(currentId==null){
        const newPet = {
            ownerId : Number(ownerId.value),
            name: name.value.trim(),
            species: species.value.trim(),
            breed: breed.value.trim(),
            gender: genderValue
        }
        try{
            service.createPet(newPet);
            alert("Thêm thành công");
            hideForm();
            showPets();
        }
        catch (e) {
            alert(e.message);
        }
    }
    else{
        const updatePet = {
            id : Number(currentId),
            ownerId : Number(ownerId.value),
            name: name.value.trim(),
            species: species.value.trim(),
            breed: breed.value.trim(),
            gender: genderValue
        }
        try{
            service.updatePet(updatePet);
            alert("Cập nhật thông tin thành công");
            hideForm();
            showPets();
        }
        catch (e){
            alert(e.message);
        }
    }
});


//=======================================Khởi chạy hàm ban đầu=================================================
showPets();



