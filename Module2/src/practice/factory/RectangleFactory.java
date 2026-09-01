package practice.factory;

import practice.interfaces.IShape;
import practice.model.Rectangle;

public class RectangleFactory extends ShapeFactory {
    private final double width;
    private final double height;

    public RectangleFactory(double width, double height) {
        this.width = width;
        this.height = height;
    }

    @Override
    public IShape createShape() {
        return new Rectangle(width, height);
    }
}
