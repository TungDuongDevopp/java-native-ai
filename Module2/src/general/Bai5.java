package general;
import utils.Validation;
public class Bai5 {
    public static void main(String[] args) {
        int a,b;
        a = Validation.getValidInt("Mời bạn nhập số nguyên a: ");
        b = Validation.getValidInt("Mời bạn nhập số nguyên b: ");
        String choice;

        boolean isRunning = true;
       while (isRunning){

           System.out.println("\n>> MÁY TÍNH SIÊU CẤP VIP PRO<< ");
           System.out.println("++++++++++++++++++++++++++++++");
           System.out.println("|+. Phép cộng                |");
           System.out.println("|-. Phép trừ                 |");
           System.out.println("|*. Phép nhân                |");
           System.out.println("|/. Phép chia                |");
           System.out.println("|q. Thoát                    |");
           System.out.println("++++++++++++++++++++++++++++++");
           choice = Validation.getValidString("Mời nhập lựa chọn");
           switch (choice){
               case "+":
                   System.out.format("\nKết quả phép tính %d + %d = %d",a,b,a+b);
                   break;
               case "-":
                   System.out.format("\nKết quả phép tính %d - %d = %d",a,b,a-b);
                   break;
               case "*":
                   System.out.format("\nKết quả phép nhân %d * %d = %d",a,b,a*b);
                   break;
               case "/":
                   try {
                       double result =  (double) a/b;
                       System.out.format("\nKết quả phép chia %d / %d = %.2f",a,b,result);


                   }catch (Exception e){
                       System.out.println("Số bị chia phải khác 0, phép chia không hợp lệ");
                   }
                   break;
               case "q":
                   System.out.println("Bạn đã thoát chương trình!");
                    isRunning = false;
           }
       }

        System.out.println("\nCảm ơn đã dùng chương trình!");

    }
}
