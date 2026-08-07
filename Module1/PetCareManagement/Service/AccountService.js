
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

    deleteAccountById(id){
        return this.#repository.deleteById(id);
    }

    saveAccount(account){
        this.#validationSignUp(account);
        return this.#repository.save(account);
    }


    updateAccount(account){
        return this.#repository.update(account);
    }

    login(username, password){
        this.#validationLogin(username,password)
        const account = this.#repository.findByUserName(username);
        if(!account|| password !== account.password) return null;
        localStorage.setItem("loggedInUser", JSON.stringify(account));
        return account;

    }
    changePassword(username,password){
        const account = this.#repository.findByUserName(username);
        if(!account){
            throw new Error("Tài khoản không tồn tại");
        }

        if(!password || !password.trim()){
            throw new Error("Mật khẩu không hợp lệ");
        }
        if(password.length<6){
            throw new Error("Mật khẩu quá ngắn");
        }

        if(password===account.password){
            throw new Error("Mật khẩu không được trùng vs mật khẩu cũ");
        }

        account.password = password;
        this.updateAccount(account);

        // Xoá session đăng nhập nếu đang đăng nhập bằng account này
        const loggedInUser = localStorage.getItem("loggedInUser");
        if (loggedInUser) {
            try {
                const parsed = JSON.parse(loggedInUser);
                if (parsed.username === username) {
                    localStorage.removeItem("loggedInUser");
                }
            } catch (_) {}
        }
    }




}