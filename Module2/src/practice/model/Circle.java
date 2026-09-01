package practice.model;


import practice.interfaces.IShape;

public class Circle  implements IShape {
    private static final double PI = 3.14;
    private final double radius;

    public Circle(double radius) {
        this.radius = radius;
    }

    @Override
    public String getName() {
        return "Hình tròn";
    }

    @Override
    public void draw() {
        System.out.println("Cách vẽ: Dùng compa mà vẽ:))");
    }

    @Override
    public double getArea() {
        return PI * radius * radius;
    }

    @Override
    public double getPerimeter() {
        return  2 * PI * radius;
    }
}
