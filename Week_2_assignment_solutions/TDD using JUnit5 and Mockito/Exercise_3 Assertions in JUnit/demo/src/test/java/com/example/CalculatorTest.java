package com.example;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class CalculatorTest {

    Calculator calculator = new Calculator();

    @Test
    void testAddition() {
        assertEquals(5, calculator.add(2, 3), "2 + 3 should be 5");
        assertNotEquals(6, calculator.add(2, 3));
    }

    @Test
    void testIsPositive() {
        assertTrue(calculator.isPositive(10));
        assertFalse(calculator.isPositive(-5));
    }

    @Test
    void testMessage() {
        String msg = calculator.getMessage();
        assertNotNull(msg);
        assertEquals("Hello, JUnit!", msg);
        assertTrue(msg.startsWith("Hello"));
    }
}
