package practice.main;

import practice.factory.CircleFactory;
import practice.factory.RectangleFactory;
import practice.factory.ShapeFactory;
import practice.factory.SquareFactory;
import practice.interfaces.IShape;

public class Main {
    public static void main(String[] args) {
        ShapeFactory factory = new CircleFactory(5);
        IShape circle = factory.createShape();
        System.out.println("Name: "+ circle.getName());
        circle.draw();
        System.out.println("Chu vi hình tròn: " + circle.getPerimeter());
        System.out.println("Diện tích hình tròn: " + circle.getArea());
        System.out.println("=========================================");
        factory = new RectangleFactory(5,4);
        IShape rec = factory.createShape();
        System.out.println("Name: "+ rec.getName());
        rec.draw();
        System.out.println("Chu vi hình chữ nhật: " + rec.getPerimeter());
        System.out.println("Diện tích hình chữ nhat: " + rec.getArea());
        System.out.println("=========================================");
        factory = new SquareFactory(5);
        IShape sq = factory.createShape();
        System.out.println("Name: "+ sq.getName());
        sq.draw();
        System.out.println("Chu vi hình vuông: " + sq.getPerimeter());
        System.out.println("Diện tích hình vuông: " + sq.getArea());
    }
}
