// Tạo dữ liệu mẫu trong trường hợp chưa có data
if (!localStorage.getItem("pets")) {
    const defaultPets = [
        {
            id: 1,
            ownerId: 1,
            name: "Lucky",
            species: "Dog",
            breed: "Corgi",
            gender: "Male",
        },
        {
            id: 2,
            ownerId: 2,
            name: "Mimi",
            species: "Cat",
            breed: "British Shorthair",
            gender: "Female",
        },
        {
            id: 3,
            ownerId: 3,
            name: "Rocky",
            species: "Dog",
            breed: "Golden Retriever",
            gender: "Male",
        },
        {
            id: 4,
            ownerId: 4,
            name: "Luna",
            species: "Cat",
            breed: "Persian",
            gender: "Female",
        },
        {
            id: 5,
            ownerId: 5,
            name: "Max",
            species: "Dog",
            breed: "Husky",
            gender: "Male",
        }
    ];

    localStorage.setItem("pets", JSON.stringify(defaultPets));
}
export default class PetRepository{

    findAll(){
        return JSON.parse(localStorage.getItem("pets"))||[];
    }

    findById(id){
        return this.findAll().find(p => Number(p.id) === Number(id));
    }

    findByOwnerId(ownerId){
        return this.findAll().find(p => Number(p.ownerId) === Number(ownerId));
    }

    findAllByOwnerId(ownerId){
        return this.findAll().filter(p => Number(p.ownerId) === Number(ownerId));
    }

    save(pet){
        const pets = this.findAll();
        const maxId = pets.reduce((max,p)=>Math.max(Number(p.id),max),0);
        pet.id = maxId + 1;
        pets.push(pet);
        this.saveAll(pets);

    }

    saveAll(pets){
        localStorage.setItem("pets",JSON.stringify(pets));
    }

    deleteById(id){
        const pets = this.findAll();
        const newPets = pets.filter(p => Number(p.id) !== Number(id));

        if (pets.length === newPets.length) {
            return false;
        }
        this.saveAll(newPets);
        return true;
    }

    update(pet){
        const pets = this.findAll();
        const index = pets.findIndex(p => Number(p.id) === Number(pet.id));
        if(index !== -1){
            pets[index] = pet;
            this.saveAll(pets)
        }
    }

}