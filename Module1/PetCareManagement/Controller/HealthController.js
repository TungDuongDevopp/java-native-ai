import HealthRepository from "../Repository/HealthRepository.js";
import HealthService from "../Service/HealthService.js";
import Render from "../View/Render.js";
import Navbar from "../View/Navbar.js";
import PetService from "../Service/PetService.js";
import PetRepository from "../Repository/PetRepository.js";



// Khởi tạo Navbar cho trang Hồ sơ sức khỏe
Navbar.render("record");

const repository = new HealthRepository();
const service = new HealthService(repository);
const render = new Render();
const petRepository = new PetRepository();
const petService = new PetService(petRepository);

// Các phần tử Dom của các ô button
const btnAdd = document.getElementById("btnAdd");
const btnCancel = document.getElementById("btnCancel");
const btnSearch = document.getElementById("btnSearch");

// Các phần tử Dom của các ô input
const petId = document.getElementById("petId");
const date = document.getElementById("date");
const weight = document.getElementById("weight");
const heartRate = document.getElementById("heartRate");
const temperature = document.getElementById("temperature");
const note = document.getElementById("note");
const searchInput = document.getElementById("searchInput");

// Các phần tử Dom của table và form
const formTitle = document.getElementById("formTitle");
const formContainer = document.getElementById("formContainer");
const recordForm = document.getElementById("recordForm");

function handleSearch() {
    const keyword = searchInput.value;
    const searchResults = service.searchRecords(keyword);
    render.renderRecord(searchResults, editRecord, deleteRecord);
}

function loadPetOptions(){
    const pets = petService.getAllPets();
    if(pets.length === 0){
        petId.innerHTML = `<option value="">-- Chưa có thú cưng --</option>`;
    } else {
        petId.innerHTML = pets.map(pet => `<option value="${pet.id}">${pet.id} - ${pet.name}</option>`).join("");
    }
}

let currentId = null;

//================================== HÀM THAO TÁC VS FORM (Do chung 1 form)====================================
function showForm(id){
    loadPetOptions();
    if(id == null){
        formTitle.innerText = "Thêm hồ sơ";
        petId.disabled = false;
    }
    else{
        formTitle.innerText = "Sửa hồ sơ";
        petId.disabled = true;
    }
    formContainer.style.display="block";
}

function hideForm(){
    formContainer.style.display="none";
    recordForm.reset();
    petId.disabled = false;
    currentId = null;
}

function fillForm(record){
    petId.value = record.petId;
    date.value = record.date;
    weight.value = record.weight;
    heartRate.value = record.heartRate;
    temperature.value = record.temperature;
    note.value = record.note;
}

//=======================================HÀM XỬ LÝ SỰ KIỆN===========================================================
btnCancel.addEventListener("click", () => { hideForm(); });

btnAdd.addEventListener("click", () => {
    currentId = null;
    recordForm.reset();
    showForm(currentId);
});

recordForm.addEventListener("submit", (ev) => {
    ev.preventDefault();
    if(currentId == null){
        const newRecord = {
            petId : Number(petId.value),
            date : date.value,
            weight: Number(weight.value),
            heartRate: Number(heartRate.value),
            temperature: Number(temperature.value),
            note: note.value.trim()
        }
        try{
            service.createRecord(newRecord);
            alert("Thêm hồ sơ sức khỏe thành công");
            hideForm();
            showRecords();
        }
        catch (e){
            alert(e.message);
        }
    }
    else {
        const updateRecord = {
            id: Number(currentId),
            petId : Number(petId.value),
            date : date.value,
            weight: Number(weight.value),
            heartRate: Number(heartRate.value),
            temperature: Number(temperature.value),
            note: note.value.trim()
        }
        try{
            service.updateRecord(updateRecord);
            alert("Cập nhật hồ sơ sức khỏe thành công");
            hideForm();
            showRecords();
        }
        catch (e){
            alert(e.message);
        }
    }
});

// Bắt sự kiện click nút tìm kiếm
btnSearch.addEventListener("click", handleSearch);
//Bắt sự kiện người dùng nhập vào ô input
searchInput.addEventListener("input", handleSearch);

//================================== CÁC HÀM THAO TÁC DỮ LIỆU VS HỆ THỐNG ============================================
function showRecords(){
    const records = service.getAllRecords();
    render.renderRecord(records, editRecord, deleteRecord);
}

function editRecord(id){
    const updateRecord = service.getRecordById(id);
    if(!updateRecord) return;
    currentId = id;
    showForm(currentId);
    fillForm(updateRecord);
}

function deleteRecord(id){
    const record = service.getRecordById(id);
    if (!record) return;
    const confirmed = confirm("Bạn có muốn xóa bản ghi?");
    if(!confirmed) return;
    service.deleteRecordById(id);
    alert("Xóa thành công");
    showRecords();
}

//=======================================Khởi chạy hàm ban đầu=================================================
showRecords();
