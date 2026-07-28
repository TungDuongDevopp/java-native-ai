package oop.inheritance.bai2;

import utils.Validation;

public class Employee {
    protected String name;
    protected double baseSalary;

    public Employee(String name, double baseSalary) {
        setName(name);
        setSalary(baseSalary);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        if(!Validation.isValidString(name)){
            throw new IllegalArgumentException("Name không được để trống!");
        }
        this.name = name;
    }

    public double calculateSalary(){
        return baseSalary;
    }

    public void setSalary(double baseSalary) {
        if(!Validation.isValidDouble(baseSalary,0,Double.MAX_VALUE,false)){
            throw new IllegalArgumentException("Salary phải là số dương");
        }
        this.baseSalary = baseSalary;
    }

    @Override
    public String toString() {
        return String.format("Name: %s \t baseSalary: %.1f",name,baseSalary);
    }
}
