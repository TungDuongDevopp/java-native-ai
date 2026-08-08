
export default class AccountService{
    #repository
    constructor(repository) {
        this.#repository = repository;
    }
    #validationBase(username,password){
        if(!username || !username.trim()){
            throw new Error("Username không được trống");
        }
        if(!password || !password.trim()){
            throw new Error("Password không được trống");
        }
    }

    #validationSignUp(account){
        this.#validationBase(account.username,account.password);
        if(account.username.length<4) {
            throw new Error("Username quá ngắn, vui lòng đặt lại");
        }
        if(account.password.length<6){
            throw new Error("Password quá ngắn, vui lòng đặt lại");
        }
        if(this.#repository.existsByUsername(account.username)){
            throw new Error("Username đã tồn tại, vui lòng đặt lại");
        }
    }

    saveAccount(account){
        this.#validationSignUp(account);
        return this.#repository.save(account);
    }

    login(username, password){
        this.#validationBase(username,password)
        const account = this.#repository.findByUsername(username);
        if(!account || password !== account.password) return null;
        localStorage.setItem("loggedInUser", JSON.stringify(account));
        return account;

    }

    changePassword(username,password,confirmPassword){
        const account = this.#repository.findByUsername(username);
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
        if(password!== confirmPassword){
            throw new Error("Mật khẩu xác nhận không trùng");
        }

        account.password = password;
        this.#repository.update(account);
        const loggedInUser = JSON.parse(localStorage.getItem("loggedInUser"));
        if (loggedInUser.username === username) {
            localStorage.removeItem("loggedInUser");
        }

        }

}