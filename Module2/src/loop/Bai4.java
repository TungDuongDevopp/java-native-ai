package loop;

import utils.Validation;

public class Bai4 {
    public static void main(String[] args) {
        int n;
        n = Validation.getValidInt("Mời nhập số nguyên n: ", 0);
        long sum =0;
        for(int i = 1; i<=n;i++){
            sum+= i * (i+1);
        }
        System.out.format("\nGiá trị biểu thức là: %d ",sum);
    }
}
