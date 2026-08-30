package test;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import test.model.TriangleClassifier;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class TriangleClassifierTest {
    private final TriangleClassifier triangleClassifier  = new TriangleClassifier();

    @Test
    public void shouldReturnInvalidTriangle() {
      String result =  triangleClassifier.classifyTriangle(8,2,3);
      assertEquals("Not a triangle",result);
    }

    @Test
    @DisplayName("a = b")
    public void shouldReturnIsoscelesTriangle() {
        String result =  triangleClassifier.classifyTriangle(6,6,8);
        assertEquals("Isosceles",result);
    }

    @Test
    @DisplayName("a = b = c")
    public void shouldReturnEquilateralTriangle() {
        String result =  triangleClassifier.classifyTriangle(8,8,8);
        assertEquals("Equilateral",result);
    }

    @Test
    @DisplayName("a <=0 ")
    public void shouldThrowExceptionWhenEdgeInvalid() {
        Exception  ex = assertThrows(IllegalArgumentException.class,()->triangleClassifier.classifyTriangle(-1,8,8)) ;
        assertEquals("Edge must be greater than 0",ex.getMessage());
    }
}
