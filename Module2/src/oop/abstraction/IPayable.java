package oop.abstraction;

public interface IPayable {
    double calculatePayment();
    default void printReceipt(){
        System.out.println("Đã thanh toán: " + calculatePayment());
    }
}
