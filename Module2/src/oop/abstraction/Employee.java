package oop.abstraction;

public class Employee implements IPayable{

    private int hourWorker;
    private double hourlyRate;
    @Override
    public double calculatePayment() {
        return hourlyRate*hourWorker;
    }

    public Employee(){}

    public Employee(int hourWorker,double hourlyRate) {
        this.hourlyRate = hourlyRate;
        this.hourWorker = hourWorker;
    }
}
