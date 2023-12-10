package edu.fractal.variations;

public class SwirlAffineTransformations extends AffineTransformations {

    public SwirlAffineTransformations(double a, double b, double c, double d, double e, double f) {
        super(a, b, c, d, e, f);
    }

    @Override
    public void generateTransformation() {
        // Пусть коэффициенты будут от -0.5 до -0.5 (рандом генерирует от 0 до 1)
        this.a = Math.random() - 0.5;
        this.b = Math.random() - 0.5;
        this.c = Math.random() - 0.5;
        this.d = Math.random() - 0.5;
        this.e = Math.random() - 0.5;
        this.f = Math.random() - 0.5;
    }

    @Override
    public double applyX(double x, double y) {
        return this.a * x * Math.sin(Math.pow(this.c, 2)) - this.b * y * Math.cos(Math.pow(this.c, 2)) + this.c;
    }

    @Override
    public double applyY(double x, double y) {
        return this.a * x * Math.cos(Math.pow(this.c, 2)) + this.b * y * Math.sin(Math.pow(this.c, 2)) + this.c;
    }
}

