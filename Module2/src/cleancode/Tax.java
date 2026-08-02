package cleancode;

import java.math.BigDecimal;

public class Tax {

    private BigDecimal money;

    public Tax(BigDecimal money){
        this.money = money;
    }
    public BigDecimal calculateInterate(){
        return  BigDecimal.valueOf(money.compareTo(new BigDecimal(10000000)) > 0 ? 0.1 : 0);
    }
    public BigDecimal calculateTax (){
        return calculateInterate().multiply(money);
    }
    public void printTax(){
        System.out.println(calculateTax());
    }

    public BigDecimal getMoney() {
        return money;
    }

    public static void main(String[] args) {
            Tax tax = new Tax(new BigDecimal(12000000));
            tax.printTax();
    }
}
