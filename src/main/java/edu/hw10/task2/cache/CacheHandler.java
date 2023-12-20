package edu.hw10.task2.cache;

import edu.hw10.task2.annotations.Cache;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Stream;
import static java.nio.file.Files.newOutputStream;

public class CacheHandler implements InvocationHandler {
    private final Map<String, Object> cache = new HashMap<>();
    private final Object target;
    private final Path path;

    public CacheHandler(final Object target, final Path path) {
        this.target = target;
        this.path = path;
        retrieveResults();
    }

    @Override
    public Object invoke(
        final Object proxy,
        final Method method,
        final Object[] args
    ) throws Throwable {
        Cache cacheAnnotation = method.getAnnotation(Cache.class);
        if (cacheAnnotation != null) {
            String key = generateKey(method, args);
            return cache.computeIfAbsent(key, k -> invokeAndPersist(method, args));
        } else {
            return method.invoke(target, args);
        }
    }

    private String generateKey(final Method method, final Object[] args) {
        return method.getName() + Arrays.toString(args);
    }

    private Object invokeAndPersist(final Method method, final Object[] args) {
        try {
            Object result = method.invoke(target, args);
            persistResult(generateKey(method, args), result);
            return result;
        } catch (ReflectiveOperationException e) {
            throw new RuntimeException(e);
        }
    }

    private void persistResult(final String key, final Object result) {
        try (ObjectOutputStream oos = new ObjectOutputStream(
            newOutputStream(path.resolve(key)))
        ) {
            oos.writeObject(result);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private Object readFromFile(final Path file) {
        try (ObjectInputStream ois = new ObjectInputStream(Files.newInputStream(file))) {
            return ois.readObject();
        } catch (IOException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    private void retrieveResults() {
        try (Stream<Path> files = Files.list(path)) {
            files
                .filter(Files::isRegularFile)
                .forEach(file ->
                    cache.put(
                        file.getFileName().toString(),
                        readFromFile(file)
                    ));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}

