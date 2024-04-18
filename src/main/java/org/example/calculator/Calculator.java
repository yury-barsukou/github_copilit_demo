package org.example.calculator;

/**
 * This class provides basic arithmetic operations such as addition, subtraction, multiplication, and division.
 */
public class Calculator {
    
    /**
     * Adds two numbers.
     *
     * @param a The first number.
     * @param b The second number.
     * @return The sum of a and b.
     */
    public double add(double a, double b) {
        return a + b;
    }

/**
     * Subtracts two numbers.
     *
     * @param a The first number.
     * @param b The second number.
     * @return The difference between a and b.
     */
    public double subtract(double a, double b) {
        return a - b;
    }

    /**
     * Multiplies two numbers.
     *
     * @param a The first number.
     * @param b The second number.
     * @return The product of a and b.
     */
    public double multiply(double a, double b) {
        return a * b;
    }

    // Add a method for division operation
    /**
     * Divides two numbers.
     *
     * @param a The first number.
     * @param b The second number.
     * @return The result of a divided by b.
     */
    public double divide(double a, double b) {
        if (b == 0) {
            throw new IllegalArgumentException("Cannot divide by zero!");
        }
        return a / b;
    }




}