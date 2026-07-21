package loop;
import utils.Validation;
public class Bai2 {
    public static void main(String[] args) {
        int a,b;
        int count  = 0;
        do{
            a = Validation.getValidInt("Mời nhập số a: ",0);
            b = Validation.getValidInt("Mời nhập số b: ",0);
        } while(a>=b);
        for(int i = a; i<=b;i++){
            if(isPrime(i)){
                System.out.print(i + "\t");
                count++;
            }
        }
        System.out.format("\n Có %d số nguyên tố trong đoạn [%d,%d]!",count,a,b);

    }
    private static boolean isPrime(int n){
        if(n<2) return false;
        if(n==2) return true;
        if(n%2==0) return false;
        for(int i = 3 ; i*i<=n;i+=2){
            if(n % i == 0) return false;
        }
        return true;
    }


}
