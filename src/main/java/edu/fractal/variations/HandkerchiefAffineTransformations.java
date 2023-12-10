package edu.fractal.variations;

public class HandkerchiefAffineTransformations extends AffineTransformations {

    public HandkerchiefAffineTransformations(double a, double b, double c, double d, double e, double f) {
        super(a, b, c, d, e, f);
    }

    @Override
    public void generateTransformation() {
        this.a = Math.random() - 0.5;
        this.b = Math.random() - 0.5;
        this.c = Math.random() - 0.5;
        this.d = Math.random() - 0.5;
        this.e = Math.random() - 0.5;
        this.f = Math.random() - 0.5;
    }

    @Override
    public double applyX(double x, double y) {
        return this.c * Math.sin(Math.sqrt(x * x + y * y) + this.c);
    }

    @Override
    public double applyY(double x, double y) {
        return this.c * Math.cos(Math.sqrt(x * x + y * y) - this.c);
    }
}
