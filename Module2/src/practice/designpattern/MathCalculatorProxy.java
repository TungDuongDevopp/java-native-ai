package practice.designpattern;

import practice.interfaces.ICalculator;
import practice.model.MathCalculator;

public class MathCalculatorProxy  implements ICalculator {
    private final MathCalculator mathCalculator;

    public MathCalculatorProxy(){
        this.mathCalculator = new MathCalculator();
    }

    @Override
    public double add(double first, double second) {
        if(first / 2 + second / 2 >= Double.MAX_VALUE / 2){
            throw new IllegalArgumentException("Out of range");
        }
        if(first / 2 + second / 2 <= Double.MIN_VALUE / 2){
            throw new IllegalArgumentException("Out of range");
        }
        return mathCalculator.add(first, second);
    }

    @Override
    public double sub(double first, double second) {
        if(first / 2 - second / 2 >= Double.MAX_VALUE / 2){
            throw new IllegalArgumentException("Out of range");
        }
        if(first / 2 - second / 2 <= Double.MIN_VALUE / 2){
            throw new IllegalArgumentException("Out of range");
        }
        return mathCalculator.sub(first, second);
    }

    @Override
    public double mul(double first, double second) {
        double result = mathCalculator.mul(first, second);
        if(first != 0 && result / first != second){
            throw new IllegalArgumentException("Out of range");
        }
        return result;
    }

    @Override
    public double div(double first, double second) {
        if(second == 0){
            throw new ArithmeticException("Cannot divide by zero");
        }
        return mathCalculator.div(first, second);
    }
}
