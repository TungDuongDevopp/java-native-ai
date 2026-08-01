package oop.abstraction;

import java.math.BigDecimal;

public class Invoice  implements IPayable{
    private double amount;
    @Override
    public double calculatePayment() {
        return amount;
    }
    public Invoice(){}

    public Invoice(double amount) {
        this.amount = amount;
    }
}
