package edu.hw2.task1;

public final class Task1 {
    private Task1() {
    }

    public sealed interface Expr {
        double evaluate();

        record Constant(double value) implements Expr {
            @Override
            public double evaluate() {
                return value;
            }
        }

        record Negate(Expr constant) implements Expr {
            @Override
            public double evaluate() {
                return -constant.evaluate();
            }
        }

        record Exponent(Expr base, int exponent) implements Expr {
            @Override
            public double evaluate() {
                return Math.pow(base.evaluate(), exponent);
            }
        }

        //Сложение
        record Addition(Expr... summands) implements Expr {
            @Override
            public double evaluate() {
                double result = 0;
                for (Expr summand : summands) {
                    result += summand.evaluate();
                }
                return result;
            }
        }

        record Multiplication(Expr... operands) implements Expr {
            @Override
            public double evaluate() {
                double result = 1.0;
                for (Expr operand : operands) {
                    result *= operand.evaluate();
                }
                return result;
            }
        }
    }
}
