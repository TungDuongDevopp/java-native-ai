package practice.factory;

import practice.interfaces.IShape;
import practice.model.Square;

public class SquareFactory extends ShapeFactory {
    private final double edge;

    public SquareFactory(double edge) {
        this.edge = edge;
    }

    @Override
    public IShape createShape() {
        return new Square(edge);
    }
}
