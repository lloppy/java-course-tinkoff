package edu.hw2;

import edu.hw2.task2.Task2.Rectangle;
import edu.hw2.task2.Task2.Shape;
import edu.hw2.task2.Task2.Square;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import static java.lang.Math.sqrt;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class Task2Test {
    private static final double DELTA = 1e-10;

    static Arguments[] rectangles() {
        return new Arguments[] {
            Arguments.of(new Rectangle(10, 20)),

            /**
            Текст задания:
            замена объекта базового класса на объект класса потомка -> код сломался
            не стоит их друг от друга-то наследовать

            если их не наследовать друг от друга,
            то остается одно решение - наследовать их обоих от чего-то другого
            например - создать новый интерфейс, где написать "контракт" на функцию площади
            */
            Arguments.of(new Square(sqrt(200)))
        };
    }

    @ParameterizedTest
    @MethodSource("rectangles")
    void rectangleArea(Shape rectangle) {
        double expected = 200.0;
        assertEquals(rectangle.area(), expected, DELTA);
    }

    @Test
    public void testThatRectangleAreaReturnsCorrectArea() {
        Rectangle rectangle = new Rectangle(5.0, 10.0);
        assertEquals(50.0, rectangle.area());
    }

    @Test
    public void testThatSquareAreaReturnsCorrectArea() {
        Square square = new Square(10.0);
        assertEquals(100.0, square.area());
    }

    @Test
    public void testRectangleAreaThrowsExceptionForNegativeHeight() {
        assertThrows(IllegalArgumentException.class, () -> new Rectangle(-1.0, 10.0));
    }

    @Test
    public void testRectangleAreaThrowsExceptionForNegativeWidth() {
        assertThrows(IllegalArgumentException.class, () -> new Rectangle(5.0, -1.0));
    }

    @Test
    public void testSquareAreaThrowsExceptionForNegativeSide() {
        assertThrows(IllegalArgumentException.class, () -> new Square(-1.0));
    }
}
