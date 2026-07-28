
export default class ProductService {
    #repository
    constructor(repository) {
        this.#repository = repository;
    }

    getAllProduct() {
        return this.#repository.getAll();
    }

    getProductById(id) {
        return this.#repository.findById(id);
    }

    saveProduct(product) {
        // Gọi save() để tự sinh id và thêm vào danh sách
        return this.#repository.save(product);
    }

    deleteProduct(id) {
        return this.#repository.deleteById(id);
    }

    updateProduct(product) {
        return this.#repository.update(product);
    }
}