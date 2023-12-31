package edu.hw2.task2;

public class Task2 {

    public interface Shape {
        double area();
    }

    public static final class Rectangle implements Shape {
        private final double height;
        private final double width;

        public Rectangle(
            final double rectangleHeight,
            final double rectangleWidth
        ) {
            if (rectangleHeight < 0 || rectangleWidth < 0) {
                throw new IllegalArgumentException(
                    "Height or width must be non-negative"
                );
            }
            this.height = rectangleHeight;
            this.width = rectangleWidth;
        }

        @Override
        public double area() {
            return width * height;
        }
    }

    public static final class Square implements Shape {
        private final double side;

        public Square(final double squareSide) {
            if (squareSide < 0) {
                throw new IllegalArgumentException("Side must be non-negative");
            }
            this.side = squareSide;
        }

        @Override
        public double area() {
            return side * side;
        }
    }
}
