package test;


import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import test.model.NextDayCalculator;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class NextDayCalculatorTest {
    private final NextDayCalculator nextDayCalculator = new NextDayCalculator();
   @Test
   @DisplayName("Day < Max Day")
    void shouldReturnNextDayWhenNotMaxDay() {
        String result = nextDayCalculator.nextDay(2018,1,1);
        assertEquals("2018-01-02", result);
    }
    @Test
    @DisplayName("Day = Max Day")
    void shouldReturnNextDayWhenMaxDay() {
        String result = nextDayCalculator.nextDay(2018,1,31);
        assertEquals("2018-02-01", result);
    }
    @Test
    @DisplayName("Feb 28 in leap year should return Feb 29")
    void shouldReturnNextDayWhenMaxDayAnhMonth2AndLeapYear() {
        String result = nextDayCalculator.nextDay(2020,2,28);
        assertEquals("2020-02-29", result);
    }
    @Test
    @DisplayName("Day = Max Day ,Month = 2 , Year = Not Leaf Year")
    void shouldReturnNextDayWhenMaxDayAnhMonth2() {
        String result = nextDayCalculator.nextDay(2021,2,28);
        assertEquals("2021-03-01", result);
    }
    @Test
    @DisplayName("Day = Max Day && Month = MaxMonth")
    void shouldReturnNextDayWhenMaxDayAndMaxMonth() {
        String result = nextDayCalculator.nextDay(2018,12,31);
        assertEquals("2019-01-01", result);
    }

    @Test
    @DisplayName("Invalid Day when max day April = 30")
    void shouldThrowExceptionWhenInvalidMaxDay() {
      Exception ex =  assertThrows(IllegalArgumentException.class, () -> nextDayCalculator.nextDay(2018,4,31));
        assertEquals("Invalid day",ex.getMessage());
    }

    @Test
    @DisplayName("Invalid Day ")
    void shouldThrowExceptionWhenInvalidDay() {
        Exception ex = assertThrows(IllegalArgumentException.class, () -> nextDayCalculator.nextDay(2018,1,32));
        assertEquals("Invalid day",ex.getMessage());
    }


    @Test
    @DisplayName("Invalid Month")
    void shouldThrowExceptionWhenInvalidMonth() {
        Exception ex = assertThrows(IllegalArgumentException.class, () -> nextDayCalculator.nextDay(2018,-5,1));
        assertEquals("Invalid month",ex.getMessage());
    }

    @Test
    @DisplayName("Invalid Year")
    void shouldThrowExceptionWhenInvalidYear() {
        Exception ex = assertThrows(IllegalArgumentException.class, () -> nextDayCalculator.nextDay(-2026,5,1));
        assertEquals("Invalid year",ex.getMessage());
    }
}
