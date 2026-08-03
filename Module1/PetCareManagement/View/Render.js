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

        window.editOwner = onEdit;
        window.deleteOwner = onDelete;
    }

    renderPet(pets, onEdit, onDelete) {
        let content = "";

        pets.forEach(pet => {
            content += `
                <tr>
                    <td>${pet.id}</td>
                    <td>${pet.ownerId}</td>
                    <td>${pet.name}</td>
                    <td>${pet.species}</td>
                    <td>${pet.breed}</td>
                    <td>${pet.gender}</td>
                    <td>
                        <div class="btn">
                            <button class="edit" onclick="editPet(${pet.id})">Sửa</button>
                            <button class="delete" onclick="deletePet(${pet.id})">Xóa</button>
                        </div>
                    </td>
                </tr>
            `;
        });

        document.getElementById("petTable").innerHTML = content;

        window.editPet = onEdit;
        window.deletePet = onDelete;
    }

    renderRecord(records, onEdit, onDelete) {
        let content = "";

        records.forEach(record => {
            content += `
                <tr>
                    <td>${record.id}</td>
                    <td>${record.petId}</td>
                    <td>${record.date}</td>
                    <td>${record.weight}</td>
                    <td>${record.heartRate}</td>
                    <td>${record.temperature}</td>
                    <td>${record.note}</td>
                    <td>
                        <div class="btn">
                            <button class="edit" onclick="editRecord(${record.id})">Sửa</button>
                            <button class="delete" onclick="deleteRecord(${record.id})">Xóa</button>
                        </div>
                    </td>
                </tr>
            `;
        });

        document.getElementById("recordTable").innerHTML = content;

        window.editRecord = onEdit;
        window.deleteRecord = onDelete;
    }
}