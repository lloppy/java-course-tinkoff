package edu.fractal.variations;

public class CrossAffineTransformations extends AffineTransformations {

    public CrossAffineTransformations(double a, double b, double c, double d, double e, double f) {
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
        return this.c * Math.sqrt(1 / Math.pow(x * x - y * y, 2));
    }

    @Override
    public double applyY(double x, double y) {
        return this.c * Math.sqrt(1 / Math.pow(x * x - y * y, 2));
    }
}
