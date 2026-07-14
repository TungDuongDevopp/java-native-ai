package General_Java;

import java.util.Scanner;

public class Validation {
    private static final Scanner sc = new Scanner(System.in);

    public static double getNumber(String message, double min, double max, boolean isInteger) {
        double result = -1;
        boolean isValid = false;

        do {
            System.out.print(message);
            String input = sc.nextLine().trim(); // Đọc cả dòng, xóa khoảng trắng thừa

            try {
                // 1. Nếu bắt buộc là số nguyên, kiểm tra xem chuỗi có chứa dấu chấm thập phân không
                if (isInteger && input.contains(".")) {
                    System.out.println("Lỗi: Vui lòng nhập một số nguyên chính xác (không có phần thập phân)!");
                    continue;
                }

                // 2. Chuyển chuỗi thành số thực (Nếu nhập chữ sẽ nhảy vào khối catch ngay lập tức)
                result = Double.parseDouble(input);

                // 3. Kiểm tra khoảng giá trị
                if (result < min || result > max || Double.isNaN(result)) {
                    System.out.printf("Lỗi: Giá trị phải nằm trong khoảng từ %.1f đến %.1f!\n", min, max);
                } else {
                    isValid = true; // Hợp lệ hoàn toàn
                }
            } catch (Exception e) {
                System.out.println("Lỗi: Định dạng không hợp lệ! Vui lòng chỉ nhập ký tự số");
            }
        } while (!isValid);

        return result;
    }

    // 2. HÀM NẠP CHỒNG: Chỉ yêu cầu giá trị tối thiểu (Min), tự động lấy Max vô hạn
    public static double getNumber(String message, double min, boolean isInteger) {
        return getNumber(message, min, Double.MAX_VALUE, isInteger); // Gọi lại hàm gốc
    }

    // 3. HÀM NẠP CHỒNG: Không giới hạn cả Min lẫn Max (Nhập số nào cũng được)
    public static double getNumber(String message, boolean isInteger) {
        return getNumber(message, -Double.MAX_VALUE, Double.MAX_VALUE, isInteger); // Gọi lại hàm gốc
    }
}

