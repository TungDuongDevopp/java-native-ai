package exception;

import utils.Validation;

import java.math.BigInteger;

public class ATM {
    private String name;
    private BigInteger balance;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        if(!Validation.isValidString(name)){
            throw new IllegalArgumentException("Invalid name");
        }
        this.name = name;
    }

    public BigInteger getBalance() {

        return balance;
    }

    public void setBalance(BigInteger balance) {
        if(balance.compareTo(BigInteger.ZERO)<0){
            throw new IllegalArgumentException("Invalid balance");
        }
        this.balance = balance;
    }

    public ATM(String name, BigInteger balance) {
        this.name = name;
        this.balance = balance;
    }

    public void withdraw(BigInteger amount) throws IllegalArgumentException {
        if(amount.compareTo(BigInteger.ZERO)<0){
            throw new IllegalArgumentException("Invalid amount");
        }
        if(balance.subtract(amount).compareTo(BigInteger.ZERO)<0){
            throw new IllegalArgumentException("Invalid amount");
        }
        balance = balance.subtract(amount);
        System.out.println("Withdraw Successful: " + amount);
        System.out.println("Balance: " + balance);
    }

    public static void main(String[] args) {
        ATM atm = new ATM("Bob", new BigInteger("10000000"));
        try{
            atm.withdraw(new BigInteger("5000000"));
        }
        catch(IllegalArgumentException e){
            System.out.println(e.getMessage());
        }

    }
}
