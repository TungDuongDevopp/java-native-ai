package test;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class CalculatorTests {
    private final Calculator calculator = new Calculator();

    @Test
    @DisplayName("Testing add x - y")
    void shouldReturnResultWhenAddSuccessfully() {
        assertEquals(2, calculator.add(1, 1));
    }

    @Test
    @DisplayName("Testing add MAX_VALUE - MAX_VALUE")
    void shouldThrowExceptionWhenAddMaxValue() {
        Exception e = assertThrows(IllegalArgumentException.class, () -> calculator.add(Integer.MAX_VALUE, 1));
        assertEquals("Cannot add max int number", e.getMessage());
    }
    @Test
    @DisplayName("Testing add x - y")
    void shouldReturnResultWhenSubtractSuccessfully() {
        assertEquals(4, calculator.subtract(5, 1));
    }

    @Test
    @DisplayName("Testing subtract MIN_VALUE - MIN_VALUE")
    void shouldThrowExceptionWhenSubtractMinValue() {
        Exception e = assertThrows(IllegalArgumentException.class, () -> calculator.subtract(Integer.MIN_VALUE, 1));
        assertEquals("Cannot subtract min int number", e.getMessage());
    }
}
