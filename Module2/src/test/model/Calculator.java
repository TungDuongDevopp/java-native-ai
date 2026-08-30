package test.model;

public class Calculator {
    public int add(int a, int b) {
        if(a == Integer.MAX_VALUE  && b >0 || b == Integer.MAX_VALUE && a > 0) {
            throw new IllegalArgumentException("Cannot add max int number");
        }
        return a + b;
    }
    public int subtract(int a, int b) {
        if(a == Integer.MIN_VALUE  && b >0 || b == Integer.MIN_VALUE && a > 0) {
            throw new IllegalArgumentException("Cannot subtract min int number");
        }
        return a - b;
    }
}
