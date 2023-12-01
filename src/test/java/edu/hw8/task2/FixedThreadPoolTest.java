package edu.hw8.task2;

import java.util.concurrent.CountDownLatch;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class FixedThreadPoolTest {
    @Test
    public void testThreadPoolExecution() throws Exception {
        int threadsNumber = 3;
        FixedThreadPool threadPool = new FixedThreadPool(threadsNumber);
        CountDownLatch latch = new CountDownLatch(3);

        threadPool.start();

        for (int i = 0; i < 3; i++) {
            threadPool.execute(() -> {
                try {
                    Thread.sleep(100);
                    latch.countDown();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            });
        }
        assertTrue(1 <= latch.getCount());
        assertTrue(3 == latch.getCount());

        latch.await();
        threadPool.close();

        assertEquals(0, latch.getCount());
    }
}
