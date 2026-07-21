package utils;
import java.util.Scanner;
public class Validation {
    private static final Scanner sc = new Scanner(System.in);

    private static double getNumber(String prompt, double min,double max,boolean isInteger){
        while (true) {
            System.out.print(prompt);
            String input = sc.nextLine().trim();
            try {
                double value = Double.parseDouble(input);

                // Gọi hàm logic để kiểm tra
                if (isValidDouble(value, min, max, isInteger)) {
                    return value;
                }
                System.out.println("Lỗi: Giá trị không thỏa mãn điều kiện (sai khoảng hoặc không phải số nguyên)!");
            } catch (NumberFormatException e) {
                System.out.println("Lỗi: Định dạng không hợp lệ! Vui lòng nhập số.");
            }
        }
    }

    public static boolean isValidDouble(double value, double min, double max, boolean isInteger) {
        if (Double.isNaN(value) || Double.isInfinite(value)) return false;
        if (isInteger && value % 1 != 0) return false;
        if (value < min || value > max) return false;
        return true;
    }

    public static boolean isValidString(String value) {
        return value != null && !value.isBlank();
    }

    public static double getValidDouble(String prompt, double min, double max) {
        return getNumber(prompt,min,max,false);
    }


    public static double getValidDouble(String prompt,double min){
        return getValidDouble(prompt,min,Double.MAX_VALUE);
    }

    public static double getValidDouble(String prompt){
        return getValidDouble(prompt,-Double.MAX_VALUE,Double.MAX_VALUE);
    }

    public static int getValidInt(String prompt,int min,int max){
        return (int)getNumber(prompt,min,max,true);
    }

    public static int getValidInt(String prompt,int min){
        return getValidInt(prompt,min,Integer.MAX_VALUE);
    }
    public static int getValidInt(String prompt){
        return getValidInt(prompt,-Integer.MAX_VALUE,Integer.MAX_VALUE);
    }

    public static String getValidString(String prompt){
        String input;
        do {
            System.out.print(prompt);
            input = sc.nextLine().trim();

        }while (!isValidString(input));
        return input;
    }



}

