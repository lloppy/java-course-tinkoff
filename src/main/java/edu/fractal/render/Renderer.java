package edu.fractal.render;

import edu.fractal.image.FractalImage;
import edu.fractal.variations.AffineTransformations;
import java.util.List;
import org.w3c.dom.css.Rect;

public interface Renderer {
    void render(
        FractalImage canvas,
        Rect world,
        List<AffineTransformations> variations,
        int samples,
        int iterations,
        long seed
    );

}
