package general;
import utils.Validation;
public class Bai4 {
    public static void main(String[] args) {
        int day;
        day = Validation.getValidInt("Mời bạn nhập thứ trong ngày: ",0,7);
        switch (day){
            case 1:
                System.out.println("Thứ Hai");
                break;
            case 2:
                System.out.println("Thứ Ba");
                break;
            case 3:
                System.out.println("Thứ Tư");
                break;
            case 4:
                System.out.println("Thứ Năm");
                break;
            case 5:
                System.out.println("Thứ Sáu");
                break;
            case 6:
                System.out.println("Thứ Bảy");
                break;
            case 7:
                System.out.println("Chủ Nhật");
                break;
            default:
                System.out.println("Không Hợp Lệ");
        }
    }
}
