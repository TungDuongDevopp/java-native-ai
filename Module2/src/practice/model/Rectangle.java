package practice.model;

import practice.interfaces.IShape;

public class Rectangle implements IShape {
    private  final double width;
    private final double height;

    public Rectangle(double width, double height) {
        this.width = width;
        this.height = height;
    }

    @Override
    public String getName() {
        return "Hình chữ nhật";
    }

    @Override
    public void draw() {
        System.out.println("Cách vẽ: lấy thước kẻ mà vẽ:))");
    }

    @Override
    public double getArea() {
        return width * height;
    }

    @Override
    public double getPerimeter() {
        return (width + height) * 2;
    }
}
