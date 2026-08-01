package oop.abstraction;

public class Rectangle extends Shape{

    private double width;
    private double height;
    @Override
    double calculateArea() {
        return width*height;
    }
    public Rectangle(String name,double width,double height){
        super(name);
        this.height = height;
        this.width = width;

    }
    public Rectangle(){}


}
