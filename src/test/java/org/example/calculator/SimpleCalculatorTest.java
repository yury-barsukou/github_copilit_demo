package org.example.calculator;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.stream.Stream;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

public class SimpleCalculatorTest {

    SimpleCalculator calculator = new SimpleCalculator();

    @ParameterizedTest
    @MethodSource("provideNumbersForAddition")
    public void testAdd(double input1, double input2, double expected) {
        assertEquals(expected, calculator.add(input1, input2));
    }

    @ParameterizedTest
    @MethodSource("provideNumbersForSubtraction")
    public void testSubtract(double input1, double input2, double expected) {
        assertEquals(expected, calculator.subtract(input1, input2));
    }

    @ParameterizedTest
    @MethodSource("provideNumbersForMultiplication")
    public void testMultiply(double input1, double input2, double expected) {
        assertEquals(expected, calculator.multiply(input1, input2));
    }

    @ParameterizedTest
    @MethodSource("provideNumbersForDivision")
    public void testDivide(double input1, double input2, double expected) {
        assertEquals(expected, calculator.divide(input1, input2));
    }

    @ParameterizedTest
    @MethodSource("provideNumbersForPower")
    public void testPower(double input1, double input2, double expected) {
        assertEquals(expected, calculator.power(input1, input2));
    }

    static Stream<Arguments> provideNumbersForPower() {
        return Stream.of(
            Arguments.of(2, 3, 8),
            Arguments.of(-2, 3, -8),
            Arguments.of(2, 0, 1),
            Arguments.of(2, -2, 0.25)
        );
    }

    static Stream<Arguments> provideNumbersForAddition() {
        return Stream.of(
            Arguments.of(2, 3, 5),
            Arguments.of(-2, 1, -1),
            Arguments.of(2, -2, 0)
        );
    }

    static Stream<Arguments> provideNumbersForSubtraction() {
        return Stream.of(
            Arguments.of(2, 3, -1),
            Arguments.of(-2, 1, -3),
            Arguments.of(2, -2, 4)
        );
    }

    static Stream<Arguments> provideNumbersForMultiplication() {
        return Stream.of(
            Arguments.of(2, 3, 6),
            Arguments.of(-2, 1, -2),
            Arguments.of(2, -2, -4),
            Arguments.of(2, 0, 0)
        );
    }

    static Stream<Arguments> provideNumbersForDivision() {
        return Stream.of(
            Arguments.of(6, 3, 2),
            Arguments.of(-4, 2, -2),
            Arguments.of(2, -2, -1)
        );
    }
}