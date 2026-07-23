package oop.encapsulation;

import utils.Validation;

public class BankAccount {
    private String owner;
    private double balance;

    public BankAccount(String owner,double balance) {
        setBalance(balance);
        setOwner(owner);
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        if(!Validation.isValidDouble(balance,0,Double.MAX_VALUE,false)){
            this.balance = 0;
        }
        else {
            this.balance = balance;
        }

    }

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        if(!Validation.isValidString(owner)){
            throw new IllegalArgumentException("Tên không hợp lệ");
        }
        this.owner = owner;
    }

    public synchronized boolean withdraw(double amount){
        if(amount<=0||amount>balance) return false;
        balance -=amount;
        return true;
    }

    public synchronized boolean deposit(double amount){
        if(amount<0) return false;
        balance+=amount;
        return true;
    }

    @Override
    public String toString() {
        return String.format("Chủ tài khoản: %s\t Số dư: %.1f",owner,balance);
    }

    public static void main(String[] args) {
        BankAccount account = new BankAccount("Dương", 10000000);
        System.out.println("Thông tin tài khoản: ");
        System.out.println(account);
        // Thực hiện cập nhật số dư không hợp lệ
        account.setBalance(-15000000);
        System.out.println("Thông tin tài khoản: ");
        System.out.println(account);

        double amount = 1500000;
        // Thực hiện nạp tiền
        if(account.deposit(amount)){
            System.out.format("Đã nạp thành công %.1f, số dư hiện tại: %.1f",amount,account.getBalance());
        }
        else {
            System.out.println("Số tiền nạp vào không hợp lệ, vui lòng thử lại");
        }

        double amount2 = 200000;
        //Thực hiện rút tiền
        if(account.withdraw(amount2)){
            System.out.format("\nĐã rút thành công %.1f, số dư hiện tại: %.1f",amount2,account.getBalance());
        }
        else {
            System.out.println("\nSố tiền rút ra không hợp lệ, vui lòng thử lại");

        }
    }
}
