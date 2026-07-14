package General_Java;

public class Baii5 {
    public static void main(String[] args) {
        int a,b;
        a = (int) Validation.getNumber("Mời bạn nhập số nguyên a: ",true);
        b = (int) Validation.getNumber("Mời bạn nhập số nguyên b: ",true);
        int choice;

        boolean isRunning = true;
       while (isRunning){

           System.out.println("\n>> MÁY TÍNH SIÊU CẤP VIP PRO<< ");
           System.out.println("++++++++++++++++++++++++++++++");
           System.out.println("|1. Phép cộng                |");
           System.out.println("|2. Phép trừ                 |");
           System.out.println("|3. Phép nhân                |");
           System.out.println("|4. Phép chia                |");
           System.out.println("|0. Thoát                    |");
           System.out.println("++++++++++++++++++++++++++++++");
           choice = (int)Validation.getNumber("Mời bạn nhập lựa chọn: ",0,4,true);
           switch (choice){
               case 1:
                   System.out.format("\nKết quả phép tính %d + %d = %d",a,b,a+b);
                   break;
               case 2:
                   System.out.format("\nKết quả phép tính %d - %d = %d",a,b,a-b);
                   break;
               case 3:
                   System.out.format("\nKết quả phép nhân %d * %d = %d",a,b,a*b);
                   break;
               case 4:
                   try {
                       double result =  (double) a/b;
                       System.out.format("\nKết quả phép chia %d / %d = %.2f",a,b,result);


                   }catch (Exception e){
                       System.out.println("Số bị chia phải khác 0, phép chia không hợp lệ");
                   }
                   break;
               case 0:
                   System.out.println("Bạn đã thoát chương trình!");
                    isRunning = false;
           }
       }

        System.out.println("\nCảm ơn đã dùng chương trình!");

    }
}
