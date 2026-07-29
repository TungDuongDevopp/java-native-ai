// Dữ liệu mẫu - chỉ khởi tạo nếu localStorage chưa có
if (!localStorage.getItem("products")) {
    const defaultProducts = [
        {
            id: 1,
            name: "iPhone 15",
            price: 22000000,
            quantity: 10,
            description: "Điện thoại iphone"
        },
        {
            id: 2,
            name: "Samsung S25",
            price: 19000000,
            quantity: 5,
            description: "Điện thoại samsung"
        },
        {
            id: 3,
            name: "Xiaomi 15",
            price: 15000000,
            quantity: 20,
            description: "Điện thoại xiaomi"
        }
    ];
    localStorage.setItem("products", JSON.stringify(defaultProducts));
}

export default class ProductRepository {

    getAll() {
        return JSON.parse(localStorage.getItem("products")) || [];
    }

    save(product) {
        const products = this.getAll();
        // Tự sinh id tăng dần
        const maxId = products.reduce((max, p) => Math.max(max, p.id), 0);
        product.id = maxId + 1;
        products.push(product);
        this.saveAll(products);
    }

    saveAll(products) {
        localStorage.setItem("products", JSON.stringify(products));
    }

    findById(id) {
        return this.getAll().find(p => p.id == id);
    }

    deleteById(id) {
        const products = this.getAll().filter(p => p.id != id);
        this.saveAll(products);
    }

    update(product) {
        const products = this.getAll();
        const index = products.findIndex(p => p.id === product.id);

        if (index !== -1) {
            products[index] = product;
            this.saveAll(products);
        }
    }
}