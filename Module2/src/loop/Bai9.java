package loop;

import utils.Validation;

public class Bai9 {
    public static void main(String[] args) {
        long n;
        n = Validation.getValidInt("Mời nhập số nguyên dương n: ", 0);
        long gt = 1;
        int i = 1;
        if(n<=1) {
            gt = 1;
        }
        while(i<n){
            gt *= i+1;
            i++;
        }
        System.out.format("%d! = %d",n,gt);
    }
}
