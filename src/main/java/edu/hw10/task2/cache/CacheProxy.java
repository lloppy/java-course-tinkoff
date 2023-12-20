package edu.hw10.task2.cache;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;
import java.nio.file.Path;

public final class CacheProxy {
    private CacheProxy() {
    }

    @SuppressWarnings("unchecked")
    public static <T> T create(
        final T target,
        final Class<T> interfaceClass,
        final Path path
    ) {
        InvocationHandler handler = new CacheHandler(target, path);
        return (T) Proxy.newProxyInstance(
            interfaceClass.getClassLoader(),
            new Class<?>[] {interfaceClass},
            handler
        );
    }
}
