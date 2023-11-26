package edu.hw8.task1;

import java.net.Socket;

public class Task1 {
    boolean needShutDonw = false;

    private Task1() {
    }

    void fun() {
        Socket socket = new Socket();

        Thread serverThread = new Thread(() -> {
            while (needShutDonw) {
                serverThread.interrupt();
            }

        } catch(InterruptedException e){
            // Обработка InterruptedException
            // Второй вызов interrupt() для передачи сигнала обработки прерывания
            Thread.currentThread().interrupt();
        }
    });

    Thread stopperThread = new Thread(() -> {
        serverThread.interrupt();
    });

// Запуск потоков
        stopperThread.start();
        serverThread.start();

}
}
