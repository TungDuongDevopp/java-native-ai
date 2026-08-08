
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
        const maxId = accounts.reduce((max, a) => Math.max(max, a.id), 0);
        account.id = maxId + 1;
        accounts.push(account);
        this.saveAll(accounts);
    }

    saveAll(accounts) {
        localStorage.setItem("accounts", JSON.stringify(accounts));
    }

    update(account){
        const accounts = this.getAll();
        const index = accounts.findIndex(a=> Number(a.id) === Number(account.id));
        if(index !== -1){
            accounts[index] = account;
            this.saveAll(accounts);
        }
    }

    findByUsername(username){
        return this.getAll().find(a=>a.username === username)
    }

    existsByUsername(username){
        const accounts = this.getAll();
        return accounts.some(a => a.username === username);
    }

}