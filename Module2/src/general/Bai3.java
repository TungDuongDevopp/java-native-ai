package general;
import utils.Validation;
import java.util.Scanner;

public class Bai3 {
    public static void main(String[] args) {
        double GPA;
        Scanner sc = new Scanner(System.in);

        GPA = Validation.getValidDouble("Vui lòng nhập GPA(0-10): ",0,10);

        if(GPA >=8.5){
            System.out.println("Bạn xếp loại Giỏi");
        }
        else if (GPA>=7 && GPA <8.5) {
            System.out.println("Bạn xếp loại Khá");
        }
        else if (GPA>=5 && GPA <7) {
            System.out.println("Bạn xếp loại Trung Bình");
        }
        else {
            System.out.println("Bạn xếp loại Yếu");
        }
    }
}
