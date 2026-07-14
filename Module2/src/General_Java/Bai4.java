package General_Java;

public class Bai4 {
    public static void main(String[] args) {
        int day;
        day = (int) Validation.getNumber("Mời bạn nhập thứ trong ngày: ",0,7,true);
        switch (day){
            case 1:
                System.out.println("Thứ hai");
                break;
            case 2:
                System.out.println("Thứ ba");
                break;
            case 3:
                System.out.println("Thứ tư");
                break;
            case 4:
                System.out.println("Thứ năm");
                break;
            case 5:
                System.out.println("Thứ sáu");
                break;
            case 6:
                System.out.println("Thứ bảy");
                break;
            case 7:
                System.out.println("Chủ nhật");
                break;
            default:
                System.out.println("Thứ không hợp lệ, vui lòng nhập lại");
        }
    }
}
