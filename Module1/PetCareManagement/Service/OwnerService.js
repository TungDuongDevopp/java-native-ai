export default class OwnerService {
    #repository;
    #petService;

    constructor(repository, petService) {
        this.#repository = repository;
        this.#petService = petService;
    }

    #validateBasic(owner) {
        if (!owner.name || !owner.name.trim()) {
            throw new Error("Tên không được để trống");
        }

        if (!owner.phone || !owner.phone.trim()) {
            throw new Error("Số điện thoại không được để trống");
        }

        if (!owner.address || !owner.address.trim()) {
            owner.address = "Địa chỉ không rõ!";
        }
    }

    #validateCreate(owner) {
        const owners = this.#repository.findAll();

        if (owners.some(x => x.phone === owner.phone)) {
            throw new Error("Số điện thoại đã tồn tại");
        }

        if (owner.email && owners.some(x => x.email === owner.email)) {
            throw new Error("Email đã tồn tại");
        }
    }

    #validateUpdate(owner) {
        const owners = this.#repository.findAll();

        if (
            owners.some(x =>
                x.phone === owner.phone &&
                Number(x.id) !== Number(owner.id)
            )
        ) {
            throw new Error("Số điện thoại đã tồn tại");
        }

        if (
            owner.email &&
            owners.some(x =>
                x.email === owner.email &&
                Number(x.id) !== Number(owner.id)
            )
        ) {
            throw new Error("Email đã tồn tại");
        }
    }

    getAllOwners() {
        return this.#repository.findAll();
    }

    getOwnerById(id) {
        return this.#repository.findById(id);
    }

    createOwner(owner) {
        this.#validateBasic(owner);
        this.#validateCreate(owner);
        this.#repository.save(owner);
    }

    updateOwner(owner) {
        this.#validateBasic(owner);
        this.#validateUpdate(owner);
        return this.#repository.update(owner);
    }

    deleteOwner(id) {
        if (this.#petService.getOwnerByOwnerId(id)) {
            throw new Error("Không thể xóa do vẫn còn thú cưng");
        }
        return this.#repository.deleteById(id);
    }

    searchOwners(keyword) {
        if (!keyword) {
            return this.getAllOwners();
        }
        const cleanKey = keyword.trim().toLowerCase();

        return this.#repository.findAll().filter(owner =>
            owner.name.toLowerCase().includes(cleanKey) ||
            owner.phone.includes(cleanKey) ||
            owner.email.toLowerCase().includes(cleanKey)
        );
    }

}