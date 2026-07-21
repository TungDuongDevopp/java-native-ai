package general;
import utils.Validation;
public class Bai1 {
    public static void main(String[] args) {
        double width,height,area,perimeter;
        width =  Validation.getValidDouble("Mời bạn nhập chiều rộng: ",0);
        height =  Validation.getValidDouble("Mời bạn nhập chiều cao: ",0);
        area = width*height;
        perimeter = (width+height)*2;
        System.out.format("\n Chu vi hình chữ nhật là: %.2f",perimeter);
        System.out.format("\n Diện tích hình chữ nhật là: %.2f",area);
    }
}
