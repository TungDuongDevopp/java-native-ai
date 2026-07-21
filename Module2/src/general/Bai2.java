package general;

import utils.Validation;
public class Bai2 {
    public static void main(String[] args) {
        int a;
        a = Validation.getValidInt("Mời bạn nhập một số nguyên: ",0);
        if(a % 2 == 0){
            System.out.format("\nSố %d là số chẵn!",a);
        }
        else {
            System.out.format("\nSố %d là số lẻ!",a);
        }
    }
}
