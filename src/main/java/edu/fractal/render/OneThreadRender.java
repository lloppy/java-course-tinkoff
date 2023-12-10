package edu.fractal.render;

import edu.fractal.entities.Pixel;
import edu.fractal.entities.Point;
import edu.fractal.image.FractalImage;
import edu.fractal.variations.AffineTransformations;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;
import org.w3c.dom.css.Rect;

/*
Аффинная трансформация - умножение, а потом сложение матриц
матрица умножается на вектор координат точки,
чтобы получить новые координаты точки после преобразования:

x' = ax + by + c
y' = dx + ey + f

Коэффициенты аффинных преобразований:

Поворот: a и b определяют угол поворота.
Масштабирование: a и c определяют коэффициенты масштабирования по горизонтали и вертикали.
Сдвиг: c и f определяют сдвиг по горизонтали и вертикали.
Отражение: a и d определяют направление отражения.

*/
public class OneThreadRender implements Renderer {
    @Override
    public void render(
        FractalImage canvas,
        Rect world,
        List<AffineTransformations> variations,
        int samples,
        int iterations,
        long seed
    ) {
        Map<Point, Pixel> pixelMap = new HashMap<>();
        double newX;
        double newY;
        Random rand = ThreadLocalRandom.current();
        long tran = 0;

        for (int i = 0; i < samples; i++) {
            newX = rand.nextDouble(0, 600);
            newY = rand.nextDouble(0, 600);

            for (int step = -20; step < iterations; step++) {
                AffineTransformations affine = variations.get(rand.nextInt(variations.size()));




            }

        }
    }




}











