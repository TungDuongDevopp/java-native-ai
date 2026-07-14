package General_Java;

import java.util.Scanner;

public class Bai2 {
    public static void main(String[] args) {
        int a;
        a = (int) Validation.getNumber("Mời bạn nhập một số nguyên: ",0,true);
        if(a % 2 == 0){
            System.out.format("\nSố %d là số chẵn!",a);
        }
        else {
            System.out.format("\nSố %d là số lẻ!",a);
        }
    }
}
