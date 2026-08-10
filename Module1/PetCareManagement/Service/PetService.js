export default class PetService {
    #repository
    #heathService

    constructor(repository, service) {
        this.#repository = repository;
        this.#heathService = service;
    }

    #validate(pet) {
        const ownerId = Number(pet.ownerId);

        if (!pet.name || !pet.name.trim()) {
            throw new Error("Tên không được để trống");
        }

        if (!pet.species) {
            throw new Error("Giống không được để trống");
        }

        if (typeof pet.breed === "string" && pet.breed.trim()) {
            pet.breed = pet.breed.trim();
        }
        else {
            pet.breed = "Loài không rõ!";
        }
        if (!pet.gender) {
            throw new Error("Giới tính không được để trống");
        }
        if (!ownerId || ownerId<=0 || !Number.isInteger(ownerId)) {
            throw new Error("Mã owner không hợp lệ");
        }
    }

    getAllPets() {
        return this.#repository.findAll();
    }

    getPetById(id) {
        return this.#repository.findById(id);
    }

    getOwnerByOwnerId(ownerId) {
        return this.#repository.findByOwnerId(ownerId);
    }

    getOwnersByOwnerId(ownerId){
        return this.#repository.findAllByOwnerId(ownerId);
    }

    createPet(pet) {
        this.#validate(pet);
        this.#repository.save(pet);
    }

    updatePet(pet) {
        this.#validate(pet)
        return this.#repository.update(pet);
    }

    deletePet(id) {
        this.#heathService.deleteAllRecordByPetId(id);
        return this.#repository.deleteById(id);
    }

    searchPets(keyword) {
        if (!keyword || !keyword.trim()) {
            return this.getAllPets();
        }
        const cleanKey = keyword.trim().toLowerCase();
        const ownerId = Number(cleanKey);
        if (!isNaN(ownerId) && Number.isInteger(ownerId)) {
            return this.getOwnersByOwnerId(ownerId);
        }

        return this.getAllPets().filter(pet =>
            pet.name.toLowerCase().includes(cleanKey) ||
            pet.breed.toLowerCase().includes(cleanKey) ||
            pet.species.toLowerCase().includes(cleanKey)
        );
    }
}