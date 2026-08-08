
// Tạo dữ liệu mẫu trong trường hợp chưa có data
if (!localStorage.getItem("owners")) {
    const defaultOwners = [
        {
            id: 1,
            name: "Nguyễn Văn An",
            phone: "0912345678",
            email: "an.nguyen@gmail.com",
            address: "Cầu Giấy, Hà Nội"
        },
        {
            id: 2,
            name: "Trần Thị Bình",
            phone: "0987654321",
            email: "binh.tran@gmail.com",
            address: "Hai Bà Trưng, Hà Nội"
        },
        {
            id: 3,
            name: "Lê Minh Cường",
            phone: "0905123456",
            email: "cuong.le@gmail.com",
            address: "Thanh Khê, Đà Nẵng"
        },
        {
            id: 4,
            name: "Phạm Thu Dung",
            phone: "0934567890",
            email: "dung.pham@gmail.com",
            address: "Ninh Kiều, Cần Thơ"
        },
        {
            id: 5,
            name: "Hoàng Quốc Huy",
            phone: "0978123456",
            email: "huy.hoang@gmail.com",
            address: "Quận 1, TP. Hồ Chí Minh"
        }
    ];

    localStorage.setItem("owners", JSON.stringify(defaultOwners));
}

 export default class OwnerRepository{

    findAll(){
        return JSON.parse(localStorage.getItem("owners"))||[];
    }

    findById(id){
        return this.findAll().find(o => Number(o.id) === Number(id));
    }

    save(owner){
        const owners = this.findAll();
        const maxId = owners.reduce((max,o)=>Math.max(Number(o.id),max),0);
        owner.id = maxId + 1;
        owners.push(owner);
        this.saveAll(owners);

    }

    saveAll(owners){
        localStorage.setItem("owners",JSON.stringify(owners));
    }

    deleteById(id){
        const owners = this.findAll();
        const newOwners = owners.filter(o => Number(o.id) !== Number(id));

        if (owners.length === newOwners.length) {
            return false;
        }
        this.saveAll(newOwners);
        return true;
    }

    update(owner){
        const owners = this.findAll();
        const index = owners.findIndex(o => Number(o.id) === Number(owner.id));
        if(index !== -1){
            owners[index] = owner;
            this.saveAll(owners)
        }
    }

}