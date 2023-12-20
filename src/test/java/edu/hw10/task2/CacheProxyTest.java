package edu.hw10.task2;

import java.nio.file.Path;
import edu.hw10.task2.cache.CacheProxy;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

class CacheProxyTest {

    @Test
    public void testCreateProxy() {
        // Given
        FibonacciCalculator calculator = new SimpleFibonacciCalculator();
        Path path = Path.of("src/main/resources/hw6/task2");
        FibonacciCalculator proxy = CacheProxy.create(calculator, FibonacciCalculator.class, path);

        // When
        long result1 = proxy.fibonacci(5);
        long result2 = proxy.fibonacci(5);

        // Then
        assertEquals(result1, result2);
    }
}
