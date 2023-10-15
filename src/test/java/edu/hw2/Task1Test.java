package edu.hw2;

import edu.hw2.Task1.Expr.Constant;
import edu.hw2.Task1.Expr.Negate;
import org.junit.jupiter.api.Test;
import static edu.hw2.Task1.Expr.Addition;
import static edu.hw2.Task1.Expr.Exponent;
import static edu.hw2.Task1.Expr.Multiplication;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.DisplayName;

class Task1Test {

    @Test
    @DisplayName("Тест на Constant")
    void testThatConstantReturnedValue() {
        var two = new Constant(2);
        assertEquals(2.0, two.evaluate(), 1e-10);
    }

    @Test
    @DisplayName("Тест на Negate")
    void testThatNegateReturnedValue() {
        var negOne = new Negate(new Constant(1));
        assertEquals(-1.0, negOne.evaluate(), 1e-10);
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

        var negOne = new Negate(new Constant(1));

        var mult = new Multiplication(sumTwoFour, negOne);
        assertEquals(-6.0, mult.evaluate(), 1e-10);
    }

    @Test
    @DisplayName("Тест на Exponent")
    void testThatExponentReturnedValue() {
        var two = new Constant(2);
        var four = new Constant(4);
        var sumTwoFour = new Addition(two, four); // Addition： 6

        var negOne = new Negate(new Constant(1));
        var mult = new Multiplication(sumTwoFour, negOne); // Multiplication： -6

        var exp = new Exponent(mult, 2);
        assertEquals(36.0, exp.evaluate(), 1e-10);
    }
}
