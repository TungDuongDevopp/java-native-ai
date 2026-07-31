if (!localStorage.getItem("accounts")) {
    const defaultAccounts = [
        {
            id: 1,
            username: "admin",
            password: "123456"

        },
        {
            id: 2,
            username: "user1",
            password: "123456"
        },
        {
            id: 3,
            username: "user2",
            password: "123456"
        }
    ];
    localStorage.setItem("accounts", JSON.stringify(defaultAccounts));
}

export default class AccountRepository{
    getAll() {
        return JSON.parse(localStorage.getItem("accounts")) || [];
    }

    save(account) {
        const accounts = this.getAll();
        // Tự sinh id tăng dần
        const maxId = accounts.reduce((max, p) => Math.max(max, p.id), 0);
        account.id = maxId + 1;
        accounts.push(account);
        this.saveAll(accounts);
    }

    saveAll(accounts) {
        localStorage.setItem("accounts", JSON.stringify(accounts));
    }

    findById(id) {
        return this.getAll().find(p => p.id == id);
    }

    deleteById(id) {
        const accounts = this.getAll().filter(p => p.id != id);
        this.saveAll(accounts);
    }


}