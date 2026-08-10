
export default class HealthService{
    #repository;
    constructor(repository) {
        this.#repository = repository;
    }

    #validation(record){
        const weight = Number(record.weight);
        const heartRate = Number(record.heartRate);
        const temperature = Number(record.temperature);
        const petId = Number(record.petId);


        if(!petId || petId <= 0 || !Number.isInteger(petId)){
            throw new Error("PetId hợp lệ");
        }
        if(!record.date){
            throw new Error("Ngày khám không được trống");
        }
        if(!weight || weight<=0 || weight>=150){
            throw new Error("Cân nặng không hợp lệ");
        }
        if(!heartRate || heartRate<=0 || heartRate>=200){
            throw new Error("Nhịp tim không hợp lệ");
        }
        if(!temperature || temperature<=0 || temperature>=100){
            throw new Error("Nhiệt độ không hợp lệ");
        }
        if (typeof record.note === 'string' && record.note.trim()) {
            record.note = record.note.trim();
        } else {
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

    deleteAllRecordByPetId(petId){
        return this.#repository.deteteAllByPetId(petId);
    }

    searchRecords(keyword) {
        if (!keyword || !keyword.trim()) {
            return this.getAllRecords();
        }
        const cleanKey = keyword.trim().toLowerCase();

        if (!cleanKey.includes('-')) {
            const petId = Number(cleanKey);
            if (!isNaN(petId) && Number.isInteger(petId)) {
                return this.#repository.getAllByPetId(petId);
            }
        }

        return this.getAllRecords().filter(record =>
            record.note.toLowerCase().includes(cleanKey) ||
            record.date.toLowerCase().includes(cleanKey)
        );
    }

}