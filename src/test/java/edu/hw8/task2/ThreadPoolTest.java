package edu.hw8.task2;

import java.util.concurrent.CountDownLatch;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

class ThreadPoolTest {
    @Test
    public void testThreadPoolStart() {
        ThreadPool threadPool = new FixedThreadPool(3);

        threadPool.start();
    }

    @Test
    public void testThreadPoolExecute() throws InterruptedException {
        // Given
        ThreadPool threadPool = new FixedThreadPool(3);
        CountDownLatch latch = new CountDownLatch(1);

        // When
        threadPool.start();
        threadPool.execute(() -> latch.countDown());
    }

    @Test
    public void testThreadPoolClose() {
        ThreadPool threadPool = new FixedThreadPool(3);

        threadPool.start();
        assertDoesNotThrow(threadPool::close);
    }
}
