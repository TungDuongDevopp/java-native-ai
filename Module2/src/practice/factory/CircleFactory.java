package practice.factory;

import practice.interfaces.IShape;
import practice.model.Circle;

public class CircleFactory extends ShapeFactory {
    private final double radius;

    public CircleFactory(double radius) {
        this.radius = radius;
    }

    @Override
    public IShape createShape() {
        return new Circle(radius);
    }
}
