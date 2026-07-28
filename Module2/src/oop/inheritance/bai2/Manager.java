package oop.inheritance.bai2;

import utils.Validation;

public class Manager extends Employee{

    private double bonus;

    public Manager(String name, double baseSalary,double bonus) {
        super(name, baseSalary);
        this.bonus = bonus;
    }
    @Override
    public double calculateSalary(){
       return bonus + super.calculateSalary();
    }

    public double getBonus() {
        return bonus;
    }

    public void setBonus(double bonus) {
        if(!Validation.isValidDouble(bonus,0,Double.MAX_VALUE,false)){
            throw new IllegalArgumentException("Bonus phải là số dương");
        }
        this.bonus = bonus;
    }

    @Override
    public String toString() {
        return super.toString() + String.format("      Bonus: %.1f \t Salary: %.1f", bonus,calculateSalary());
    }
}
