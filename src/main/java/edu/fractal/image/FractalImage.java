package edu.fractal.image;

import edu.fractal.entities.Pixel;

public record FractalImage(Pixel[] data, int width, int height) {
    public static FractalImage create(int width, int height) {
    }

    boolean contains(int x, int y) {
    }

    Pixel pixel(int x, int y) {
    }
}
