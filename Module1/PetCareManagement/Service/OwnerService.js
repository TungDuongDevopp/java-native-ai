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

        const duplicateOwner = owners.find(x =>
            (x.phone === owner.phone || (owner.email && x.email === owner.email))
        );

        if (duplicateOwner) {
            if (duplicateOwner.phone === owner.phone) {
                throw new Error("Số điện thoại đã tồn tại");
            }

            throw new Error("Email đã tồn tại");
        }
    }

    #validateUpdate(owner) {
        const owners = this.#repository.findAll();
        const currentId = Number(owner.id);
        const duplicateOwner = owners.find(x =>
            Number(x.id) !== currentId &&
            (x.phone === owner.phone || (owner.email && x.email === owner.email))
        );

        if (duplicateOwner) {
            if (duplicateOwner.phone === owner.phone) {
                throw new Error("Số điện thoại đã tồn tại");
            }

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

        return this.getAllOwners().filter(owner =>
            owner.name.toLowerCase().includes(cleanKey) ||
            owner.phone.includes(cleanKey) ||
            owner.email.toLowerCase().includes(cleanKey)
        );
    }

}