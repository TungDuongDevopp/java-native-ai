
export default class AccountService{
    #repository
    constructor(repository) {
        this.#repository = repository;
    }

    getAllAccount(){
        return this.#repository.getAll();
    }

    getAccountById(id){
        return this.#repository.findById(id);
    }

    saveAccount(account){
        return this.#repository.save(account);
    }

    deleteAccountById(id){
        return this.#repository.deleteById(id);
    }

    // Tìm account theo username + password, trả về account nếu đúng, null nếu sai
    login(username, password){
        const accounts = this.#repository.getAll();
        return accounts.find(a => a.username === username && a.password === password) || null;
    }

    // Kiểm tra username đã tồn tại chưa
    isUsernameExist(username){
        const accounts = this.#repository.getAll();
        return accounts.some(a => a.username === username);
    }
}