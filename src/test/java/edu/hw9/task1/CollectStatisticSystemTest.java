package edu.hw9.task1;

import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

class CollectStatisticSystemTest {

    @Test
    public void testStats() {
        CollectStatisticSystem collector = new CollectStatisticSystem();

        collector.push("metric1", new double[] {1.0, 2.0, 3.0});
        collector.push("metric2", new double[] {0.5, 1.5, 2.5});

        List<MetricType> stats = collector.stats();
        double averageMetric1 = (1 + 2 + 3) / 3;

        assertEquals(2, stats.size());
        assertEquals(averageMetric1, stats.get(0).average());
    }

    @Test
    public void testCollectStatisticSystem() throws InterruptedException {
        CollectStatisticSystem collector = new CollectStatisticSystem();
        int numberOfThreads = 10;
        int dataPerThread = 1000;

        CountDownLatch latch = new CountDownLatch(numberOfThreads);
        ExecutorService executorService = Executors.newFixedThreadPool(numberOfThreads);

        for (int i = 0; i < numberOfThreads; i++) {
            executorService.submit(() -> {
                try {
                    for (int j = 0; j < dataPerThread; j++) {
                        collector.push("metric", new double[] {1, 1, 1}); // добавляем три однёрки
                    }                                                               // сумма чисел одного пуша - 3
                } finally {
                    latch.countDown();
                }
            });
        }

        latch.await();

        for (MetricType metric : collector.stats()) {
            System.out.println("Metric: " + metric.metricName());
            System.out.println("Sum: " + metric.sum());
            System.out.println("Average: " + metric.average());
            System.out.println("Min: " + metric.min());
            System.out.println("Max: " + metric.max());
            System.out.println();

            // сумма чисел одного пуша - 3
            assertEquals(3 * numberOfThreads * dataPerThread, metric.sum());
            assertEquals(1, metric.average());
            assertEquals(1, metric.min());
            assertEquals(1, metric.max());
        }

    }

}
