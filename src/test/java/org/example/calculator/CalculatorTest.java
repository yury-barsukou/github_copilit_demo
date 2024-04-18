package org.example.calculator;

import org.junit.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import static org.junit.jupiter.api.Assertions.*;

import java.util.stream.Stream;
import org.junit.jupiter.params.provider.Arguments;

/**
 * Test class for Calculator.
 */
public class CalculatorTest {
    Calculator calculator = new Calculator();

    private static Stream<Arguments> provideNumbersForAddition() {
        return Stream.of(
            Arguments.of(5, 3, 8.0),
            Arguments.of(-4, 3, -1.0),
            Arguments.of(5, -5, 0.0)
        );
    }

    @ParameterizedTest
    @MethodSource("provideNumbersForAddition")
    public void testAdd(double a, double b, double expected) {
        assertEquals(expected, calculator.add(a, b));
    }

    private static Stream<Arguments> provideNumbersForSubtraction() {
        return Stream.of(
            Arguments.of(5, 3, 2.0),
            Arguments.of(-4, 3, -7.0),
            Arguments.of(5, -5, 10.0)
        );
    }

    @ParameterizedTest
    @MethodSource("provideNumbersForSubtraction")
    public void testSubtract(double a, double b, double expected) {
        assertEquals(expected, calculator.subtract(a, b));
    }

    private static Stream<Arguments> provideNumbersForMultiplication() {
        return Stream.of(
            Arguments.of(5, 3, 15.0),
            Arguments.of(-4, 3, -12.0),
            Arguments.of(5, -5, -25.0)
        );
    }

    @ParameterizedTest
    @MethodSource("provideNumbersForMultiplication")
    public void testMultiply(double a, double b, double expected) {
        assertEquals(expected, calculator.multiply(a, b));
    }

    private static Stream<Arguments> provideNumbersForDivision() {
        return Stream.of(
            Arguments.of(5, 3, 1.6666666666666667),
            Arguments.of(-4, 3, -1.3333333333333333),
            Arguments.of(5, -5, -1.0)
        );
    }

    @ParameterizedTest
    @MethodSource("provideNumbersForDivision")
    public void testDivide(double a, double b, double expected) {
        assertEquals(expected, calculator.divide(a, b), 0.0001);
    }

    @Test
    public void testDivideByZero() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            calculator.divide(5, 0);
        });

        String expectedMessage = "Division by zero is not allowed";
        String actualMessage = exception.getMessage();

        assertTrue(actualMessage.contains(expectedMessage));
    }
}