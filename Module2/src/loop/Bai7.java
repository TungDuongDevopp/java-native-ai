package loop;

import utils.Validation;

import java.util.ArrayList;
import java.util.List;

public class Bai7 {
    public static void main(String[] args) {
        int n;
        n = Validation.getValidInt("Mời nhập số nguyên dương n: ", 0);
        List<Integer> nums = new ArrayList<>();
        for(int i = 0;i<n;i++){
            System.out.format("\nMời nhập số thứ %d: ",i+1);
            int num = Validation.getValidInt("");
            nums.add(num);
        }
        int min = nums.get(0);
        int max = nums.get(0);
        for (int i = 0;i<nums.size();i++){
            if(nums.get(i) > max) {
                max = nums.get(i);
            }
            if(nums.get(i) <min){
                min = nums.get(i);
            }
        }
        System.out.format("Số nhỏ nhất trong list %s là: %d",nums.toString(),min);
        System.out.format("\nSố lớn nhất trong list %s là: %d ",nums.toString(),max);

    }
}
