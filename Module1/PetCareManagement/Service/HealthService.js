
export default class HealthService{
    #repository;
    constructor(repository) {
        this.#repository = repository;
    }

    #validation(record){
        if(!record.petId){
            throw new Error("PetId không được trống");
        }
        if(!record.date){
            throw new Error("Ngày khám không được trống");
        }
        if(!record.weight||record.weight <=0){
            throw new Error("Cân nặng không hợp lệ");
        }
        if(!record.heartRate||record.heartRate <=0 || record.heartRate>300){
            throw new Error("Nhịp tim không hợp lệ");
        }
        if(!record.temperature||record.temperature <=0 || record.temperature>=100){
            throw new Error("Nhiệt độ không hợp lệ");
        }
        if(!record.note || !record.note.trim()){
            record.note = "Chưa có ghi chú!";
        }
    }
    getAllRecords(){
        return this.#repository.findAll();
    }

    getRecordById(id){
        return this.#repository.findById(id);
    }
    createRecord(record){
        this.#validation(record);
        return this.#repository.save(record);
    }

    updateRecord(record){
        this.#validation(record);
        return this.#repository.update(record);
    }
    deleteRecordById(id){
        return this.#repository.deleteById(id);
    }

}