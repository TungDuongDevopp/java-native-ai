package practice.model;

import practice.interfaces.IShape;

public class Square implements IShape {
    private final double edge;

    public Square(double edge) {
        this.edge = edge;
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
        return edge*edge;
    }

    @Override
    public double getPerimeter() {
        return 4*edge;
    }
}
