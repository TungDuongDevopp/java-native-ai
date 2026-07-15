let nums = [1, 7, 5, 9, 2, 6];

// YC1: Thực hiện in phần tử của mảng
for(let i = 0;i<nums.length;i++){
    console.log(`Phần tử thứ ${i+1} = ${nums[i]}`);
}

// YC2: Thực hiện in phần tử chẵn + YC4: In tổng phần tử chẵn + YC7: In phần tử chẵn lớn nhất
let sumEven = 0;
let maxEven = Number.MIN_SAFE_INTEGER;
console.log("Phần tử chẵn là: ")
for(let i of nums){
    if(isDevisibleEqualMod(i,2,0)) {
        console.log(i);
        sumEven+=i;
        maxEven = Math.max(maxEven,i);
    }
}
console.log("Tổng phần tử chẵn là: ",sumEven)
console.log("Phần tử chẵn lớn nhất là: ",maxEven);
// YC3: Thực hiện in phần tử có index chẵn
for(let i = 0;i<nums.length;i+=2){
    console.log(`Phần tử thứ ${i} = ${nums[i]}`);
}
// YC5 : Thuc hiện in tổng phần tử > 10
let sumGreaterThan10 = 0;
for(let i of nums){
    if(i>10) sumGreaterThan10+=i;
}
    console.log("Tổng phần tử lớn hơn 10 là ",sumGreaterThan10);

// YC6: Tính tổng phần tử chia 7 dư 2
let sum7 = 0;
for(let i of nums){
    if(isDevisibleEqualMod(i,7,2)) sum7+=i;
}
console.log("Tổng phần tử chia 7 dư 2 là ",sum7);

//YC8: In gía trị lớn nhất của mảng
let max = nums[0];
for(let i =1; i<nums.length;i++){
    max = Math.max(nums[i],max);
}
console.log("Phần tử lớn nhất của mảng là: ",max)
//YC9: Đếm số phần tử chia hết cho 5 + YC10: Trung bình cộng các số chia hết cho 5
let count =0;
let sum5 = 0;
for(let i of nums){
    if(isDevisibleEqualMod(i,5,0)) {
      count++;
      sum5+=i;
    }
}
console.log("Số phần tử chia hết cho 5 là: ",count);
if (count > 0) {
    console.log("Trung bình cộng:", sum5 / count);
} else {
    console.log("Không có phần tử nào chia hết cho 5");
}
//YC11 Chỉ dùng 1 vòng lặp tìm phần tử lớn thứ 2 của mảng
let maxValue = Number.MIN_SAFE_INTEGER;
let secondMax = Number.MIN_SAFE_INTEGER;
for (let num of nums) {
    if (num > maxValue) {
        secondMax = maxValue;
        maxValue = num;
    }
    else if (num > secondMax && num < maxValue) { secondMax = num; }
}
console.log("Phần tử lớn thứ 2 là:", secondMax);

// Tạo hàm hiển thị phần tử thỏa mãn số chia một số ra dư
function isDevisibleEqualMod (devident ,devisor,mod){
    if(devident % devisor == mod) return true;
    return false;
}
