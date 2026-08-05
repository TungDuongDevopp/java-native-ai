// Tạo dữ liệu mẫu trong trường hợp chưa có data
if (!localStorage.getItem("healthRecords")) {
    const defaultHealthRecords = [
        {
            id: 1,
            petId: 1,
            date: "2026-07-01",
            weight: 12.3,
            heartRate: 96,
            temperature: 38.4,
            note: "Khỏe mạnh"
        },
        {
            id: 2,
            petId: 2,
            date: "2026-07-03",
            weight: 4.8,
            heartRate: 148,
            temperature: 38.2,
            note: "Khỏe mạnh"
        },
        {
            id: 3,
            petId: 3,
            date: "2026-07-05",
            weight: 28.7,
            heartRate: 88,
            temperature: 38.6,
            note: "Cần theo dõi"
        },
        {
            id: 4,
            petId: 1,
            date: "2026-07-10",
            weight: 12.6,
            heartRate: 94,
            temperature: 38.3,
            note: "Đã tiêm phòng"
        },
        {
            id: 5,
            petId: 4,
            date: "2026-07-12",
            weight: 5.5,
            heartRate: 142,
            temperature: 38.5,
            note: "Khỏe mạnh"
        },
        {
            id: 6,
            petId: 5,
            date: "2026-07-15",
            weight: 24.9,
            heartRate: 91,
            temperature: 38.7,
            note: "Viêm nhẹ, đã uống thuốc"
        },
        {
            id: 7,
            petId: 2,
            date: "2026-07-18",
            weight: 4.9,
            heartRate: 146,
            temperature: 38.1,
            note: "Sức khỏe ổn định"
        },
        {
            id: 8,
            petId: 3,
            date: "2026-07-22",
            weight: 29.1,
            heartRate: 90,
            temperature: 38.4,
            note: "Khỏe mạnh"
        },
        {
            id: 9,
            petId: 5,
            date: "2026-07-26",
            weight: 25.2,
            heartRate: 89,
            temperature: 38.5,
            note: "Đã hồi phục"
        },
        {
            id: 10,
            petId: 1,
            date: "2026-07-30",
            weight: 12.8,
            heartRate: 93,
            temperature: 38.2,
            note: "Khỏe mạnh"
        }
    ];

    localStorage.setItem("healthRecords", JSON.stringify(defaultHealthRecords));
}

export default class HealthRepository{

    findAll(){
        return JSON.parse(localStorage.getItem("healthRecords"))||[];
    }

    findById(id){
        return this.findAll().find(x => Number(x.id) === Number(id));
    }

    save(record){
        const records= this.findAll();
        const maxId = records.reduce((max,x)=>Math.max(Number(x.id),max),0);
        record.id = maxId +1;
        records.push(record);
        this.saveAll(records);

    }
    saveAll(records){
        localStorage.setItem("healthRecords",JSON.stringify(records));
    }

    update(record){
        const records = this.findAll();
        const index = records.findIndex(x=>Number(x.id)===Number(record.id));
            if(index!==-1){
                records[index] = record;
                this.saveAll(records);
            }
        }
    deleteById(id){
        const records = this.findAll();
        const newRecords = records.filter(x=>Number(x.id)!==Number(id));
        if(records.length === newRecords.length){
            return false;
        }
        this.saveAll(newRecords);
        return true;
    }
    deteteAllByPetId(petId){
        const records = this.findAll();
        const newRecords = records.filter(
            x => Number(x.petId) !== Number(petId)
        );
        if(records.length === newRecords.length){
            return false;
        }
        this.saveAll(newRecords);
        return true;
    }

}

