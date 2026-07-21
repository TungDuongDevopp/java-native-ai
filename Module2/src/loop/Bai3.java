package loop;

import utils.Validation;

public class Bai3 {
    public static void main(String[] args) {
        int n;
        int f0 = 0;
        int f1 = 1;

        n = Validation.getValidInt("Mời nhập số nguyên n: ", 0);

        System.out.format("Dãy Fibonacci từ 0 đến %d là: \n", n);

        // Vòng lặp kiểm tra và in chuẩn xác
        while (f0 <= n) {
            System.out.print(f0 + " ");
            int fn = f0 + f1;
            f0 = f1;
            f1 = fn;
        }
        System.out.println(); // Xuống dòng khi kết thúc
    }
}






