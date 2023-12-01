package edu.hw7.task4;

import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.atomic.AtomicLong;
import java.util.stream.LongStream;

public final class MonteCarloPi {
    private static final double CIRCLE_RADIUS = 1.0;
    private static final double FOUR_NUMBER = 4.0;

    private MonteCarloPi() {
    }

    public static double calculatePiSingleThread(final int totalSimulations) {
        int circleCount = 0;
        for (int i = 0; i < totalSimulations; i++) {
            double x = Math.random();
            double y = Math.random();
            double distance = Math.sqrt(x * x + y * y);
            if (distance <= 1) {
                circleCount++;
            }
        }
        return FOUR_NUMBER * circleCount / totalSimulations;
    }

    public static double approximationPiMultiThreading(final long totalSimulations) {
        AtomicLong circleCount = new AtomicLong(0);

        circleCount.addAndGet(LongStream.rangeClosed(1, totalSimulations)
            .parallel()
            .filter(i -> {
                double pointX = ThreadLocalRandom.current()
                    .nextDouble(CIRCLE_RADIUS);
                double pointY = ThreadLocalRandom.current()
                    .nextDouble(CIRCLE_RADIUS);
                return Math.pow(pointX, 2) + Math.pow(pointY, 2)
                    <= Math.pow(CIRCLE_RADIUS, 2);
            })
            .count());

        return FOUR_NUMBER * circleCount.get() / totalSimulations;
    }
}
