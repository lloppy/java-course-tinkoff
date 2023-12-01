package edu.hw8.task2;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class FixedThreadPool implements ThreadPool {
    public static final int DOUBLE_CAPACITY = 2;

    private final int threadsNumber;
    private final Thread[] threads;
    private final BlockingQueue<Runnable> taskQueue;

    public FixedThreadPool(int threadsNumber) {
        this.threadsNumber = threadsNumber;
        this.threads = new Thread[threadsNumber];
        this.taskQueue = new ArrayBlockingQueue<>(threadsNumber * DOUBLE_CAPACITY);
    }

    @Override
    public void start() {
        for (int i = 0; i < threadsNumber; i++) {
            threads[i] = new Thread(() -> {
                while (!Thread.currentThread().isInterrupted()) {
                    try {
                        Runnable task = taskQueue.take();
                        task.run();
                    } catch (InterruptedException e) {
                        Thread.currentThread().interrupt();
                    }
                }
            });
            threads[i].start();
        }
    }

    @Override
    public void execute(Runnable runnable) {
        try {
            taskQueue.put(runnable);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }

    @Override
    public void close() throws Exception {
        for (Thread thread : threads) {
            thread.interrupt();
        }
    }
}
