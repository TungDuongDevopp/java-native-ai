
export default class AccountService{
    #repository
    constructor(repository) {
        this.#repository = repository;
    }

       #validationSignUp(account){
        if(!account.username || !account.username.trim()){
            throw new Error("Username không được trống");
        }
        if(!account.password || !account.password.trim()){
            throw new Error("Password không được trống");
        }
        if(account.username.length<4) {
            throw new Error("Username quá ngắn, vui lòng đặt lại");
        }
        if(account.password.length<6){
            throw new Error("Password quá ngắn, vui lòng đặt lại")
        }
        if(this.isUsernameExist(account.username)){
            throw new Error("Username đã tồn tại, vui lòng đặt lại")
        }
    }
    #validationLogin(username,password){
        if(!username || !username.trim()){
            throw new Error("Username không được trống");
        }
        if(!password || !password.trim()){
            throw new Error("Password không được trống");
        }
    }
    isUsernameExist(username){
        const accounts = this.#repository.getAll();
        return accounts.some(a => a.username === username);
    }

    getAllAccount(){
        return this.#repository.getAll();
    }

    getAccountById(id){
        return this.#repository.findById(id);
    }

    saveAccount(account){
        this.#validationSignUp(account);
        return this.#repository.save(account);
    }

    deleteAccountById(id){
        return this.#repository.deleteById(id);
    }


    login(username, password){
        this.#validationLogin(username,password)
        const account = this.#repository.findByUserName(username);
        if(!account|| password !== account.password) return null;
        localStorage.setItem("loggedInUser", JSON.stringify(account));
        return account;

    }



}