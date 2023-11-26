package edu.hw7.task4;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertFalse;

class MonteCarloPiTest {
    private boolean isMultiFasterThanSingle;
    private static final double NANO_T0_SECONDS = 0.000000001;
    private static final String SINGLE_TEMPLATE = "Время в секундах на выполнения в одном потоке - %s\n";
    private static final String MULTI_TEMPLATE = "Время в секундах на выполнения многопоточного варианта - %s\n";


    @Test
    @DisplayName("10_000_000 симуляций")
    void test10MSimulations() {
        runTest(10_000_000);
        assertFalse(isMultiFasterThanSingle);
    }

    @Test
    @DisplayName("100_000_000 симуляций")
    void test100MSimulations() {
        runTest(100_000_000);
    }

    @Test
    @DisplayName("1_000_000_000 симуляций")
    void test1BSimulations() {
        runTest(1_000_000_000);
        assertFalse(isMultiFasterThanSingle);
    }

    private void runTest(final int totalSimulations) {
        double totalSingleThreadTime = 0;
        double totalMultiThreadTime = 0;

        double start;
        double end;

        try {
            System.out.printf("Число итераций: %s\n\n", totalSimulations);

            start = System.nanoTime();
            double singleThreadResult = MonteCarloPi.calculatePiSingleThread(totalSimulations);
            end = System.nanoTime();
            System.out.printf(SINGLE_TEMPLATE, (end - start) * NANO_T0_SECONDS);
            System.out.printf("Результат вычисления: %s\n", singleThreadResult);
            System.out.printf("Погрешность: %s\n\n", Math.abs(Math.PI - singleThreadResult));

            totalSingleThreadTime += end - start;

            start = System.nanoTime();
            double multiThreadResult = MonteCarloPi.approximationPiMultiThreading(totalSimulations);
            end = System.nanoTime();
            System.out.printf(MULTI_TEMPLATE, (end - start) * NANO_T0_SECONDS);
            System.out.printf("Результат вычисления: %s\n", multiThreadResult);
            System.out.printf("Погрешность: %s\n\n", Math.abs(Math.PI - multiThreadResult));

            totalMultiThreadTime += end - start;

            System.out.printf("Среднее время на выполнения в одном потоке: %s\n", totalSingleThreadTime);
            System.out.printf("Среднее время многопоточного выполнения: %s\n", totalMultiThreadTime);

            isMultiFasterThanSingle =  totalMultiThreadTime > totalSingleThreadTime;
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
