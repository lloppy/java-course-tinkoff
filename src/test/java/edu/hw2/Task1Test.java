package edu.hw2;

import edu.hw2.task1.Task1.Expr.Constant;
import edu.hw2.task1.Task1.Expr.Negate;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static edu.hw2.task1.Task1.Expr.Addition;
import static edu.hw2.task1.Task1.Expr.Exponent;
import static edu.hw2.task1.Task1.Expr.Multiplication;
import static org.junit.jupiter.api.Assertions.assertEquals;

class Task1Test {
    private static final double DELTA = 1e-10;

    @Test
    @DisplayName("Тест на Constant")
    void testThatConstantReturnedValue() {
        var two = new Constant(2);
        assertEquals(2.0, two.evaluate(), 1e-10);
    }

    @Test
    @DisplayName("Тест на Negate")
    void testThatNegateReturnedValue() {
        var negativeOne = new Negate(new Constant(1));
        assertEquals(-1.0, negativeOne.evaluate(), 1e-10);
    }

    @Test
    @DisplayName("Тест на Addition")
    void testThatAdditionReturnedValue() {
        var two = new Constant(2);
        var four = new Constant(4);
        var sumTwoFour = new Addition(two, four);
        assertEquals(6.0, sumTwoFour.evaluate(), 1e-10);
    }

    @Test
    @DisplayName("Тест на Multiplication")
    void testThatMultiplicationReturnedValue() {
        var two = new Constant(2);
        var four = new Constant(4);
        var sumTwoFour = new Addition(two, four);

        var negativeOne = new Negate(new Constant(1));
        var multiplication = new Multiplication(sumTwoFour, negativeOne);

        assertEquals(-6.0, multiplication.evaluate(), 1e-10);
    }

    @Test
    @DisplayName("Тест на Exponent")
    void testThatExponentReturnedValue() {
        var two = new Constant(2);
        var four = new Constant(4);
        var sumTwoFour = new Addition(two, four); // Addition： 6

        var negativeOne = new Negate(new Constant(1));
        var multiplication = new Multiplication(sumTwoFour, negativeOne); // Multiplication： -6
        var exponent = new Exponent(multiplication, 2);

        assertEquals(36.0, exponent.evaluate(), DELTA);
    }
}
