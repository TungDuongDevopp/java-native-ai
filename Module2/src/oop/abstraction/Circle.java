package oop.abstraction;

public class Circle extends Shape{
    private double radius;
    @Override
    double calculateArea() {
        return Math.PI * Math.pow(radius,2);
    }
    public Circle(String name,double radius){
        super(name);
        this.radius = radius;
    }
    public Circle(){}


}
