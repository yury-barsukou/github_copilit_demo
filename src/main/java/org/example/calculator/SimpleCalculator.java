package org.example.calculator;

public class SimpleCalculator {
    
    /**
     * Adds two numbers together.
     *
     * @param num1 The first number.
     * @param num2 The second number.
     * @return The sum of num1 and num2.
     */
    public double add(double num1, double num2) {
        return num1 + num2;
    }

    /**
     * Subtracts the second number from the first number.
     *
     * @param num1 The first number.
     * @param num2 The second number.
     * @return The result of num1 minus num2.
     */
    public double subtract(double num1, double num2) {
        return num1 - num2;
    }

    /**
     * Multiplies two numbers together.
     *
     * @param num1 The first number.
     * @param num2 The second number.
     * @return The product of num1 and num2.
     */
    public double multiply(double num1, double num2) {
        return num1 * num2;
    }

    /**
     * Divides the first number by the second number.
     *
     * @param num1 The first number.
     * @param num2 The second number.
     * @throws IllegalArgumentException if num2 is zero.
     * @return The result of num1 divided by num2.
     */
    public double divide(double num1, double num2) {
        if (num2 != 0) {
            return num1 / num2;
        } else {
            throw new IllegalArgumentException("Division by zero is not allowed.");
        }
    }

    /**
     * Raises the first number to the power of the second number.
     *
     * @param num1 The base number.
     * @param num2 The exponent.
     * @return The result of num1 raised to the power of num2.
     */
    public double power(double num1, double num2) {
        return Math.pow(num1, num2);
    }
}