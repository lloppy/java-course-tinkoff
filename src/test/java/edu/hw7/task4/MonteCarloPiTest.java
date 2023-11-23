package edu.hw7.task4;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertFalse;

class Task4Test {
    private boolean isMultiFasterThanSingle;
    private static final double NANO_T0_SECONDS = 0.000000001;
    private static final String SINGLE_TEMPLATE = "Время в секундах на выполнения в одном потоке - ";
    private static final String MULTI_TEMPLATE = "Время в секундах на выполнения многопоточного варианта - ";


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
            System.out.println("Число итераций: " + totalSimulations + "\n");

            start = System.nanoTime();
            double singleThreadResult = MonteCarloPi.calculatePiSingleThread(totalSimulations);
            end = System.nanoTime();
            System.out.println(SINGLE_TEMPLATE + (end - start) * NANO_T0_SECONDS);
            System.out.println("Результат вычисления: " + singleThreadResult);
            System.out.println("Погрешность: " + Math.abs(Math.PI - singleThreadResult) + "\n");

            totalSingleThreadTime += end - start;

            start = System.nanoTime();
            double multiThreadResult = MonteCarloPi.approximationPiMultiThreading(totalSimulations);
            end = System.nanoTime();
            System.out.println(MULTI_TEMPLATE + (end - start) * NANO_T0_SECONDS);
            System.out.println("Результат вычисления: " + multiThreadResult);
            System.out.println("Погрешность: " + Math.abs(Math.PI - multiThreadResult) + "\n");

            totalMultiThreadTime += end - start;

            System.out.println("Среднее время на выполнения в одном потоке: " + totalSingleThreadTime);
            System.out.println("Среднее время многопоточного выполнения: " + totalMultiThreadTime);

            isMultiFasterThanSingle =  totalMultiThreadTime > totalSingleThreadTime;
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
