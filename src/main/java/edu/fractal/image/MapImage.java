package edu.fractal.image;

import edu.fractal.entities.Pixel;
import edu.fractal.entities.Point;
import java.util.Map;

public record MapImage(Map<Point, Pixel> pixelMap, int width, int height) {
}
