package edu.hw8.task1;

import java.io.*;
import java.net.*;
import java.util.concurrent.*;

public class QuoteServer {
    private static final int PORT = 9876;
    private static final int MAX_CONNECTIONS = 5;

    private static ExecutorService threadPool = Executors.newFixedThreadPool(MAX_CONNECTIONS);

    private static final String[] KEYWORDS = {
        "личности",
        "оскорбления",
        "глупый",
        "интеллект"
    };

    private static final String[] RESPONSES = {
        "Не переходи на личности там, где их нет",
        "Если твои противники перешли на личные оскорбления, будь уверен(а) — твоя победа не за горами",
        "А я тебе говорил, что ты глупый? Так вот, я забираю свои слова обратно... Ты просто бог идиотизма.",
        "Чем ниже интеллект, тем громче оскорбления"
    };

    public static void main(String[] args) {
        try (ServerSocket serverSocket = new ServerSocket(PORT)) {
            System.out.println("Сервер запущен. Ожидание подключений...");

            while (true) {
                Socket clientSocket = serverSocket.accept();
                System.out.println("Подключен клиент: " + clientSocket.getInetAddress());

                threadPool.execute(() -> handleClient(clientSocket));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void handleClient(Socket clientSocket) {
        try (
            BufferedReader reader = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
            PrintWriter writer = new PrintWriter(clientSocket.getOutputStream(), true)
        ) {
            String keyword = reader.readLine();
            String response = findResponse(keyword);
            writer.println(response);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                clientSocket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private static String findResponse(String keyword) {
        for (int i = 0; i < KEYWORDS.length; i++) {
            if (KEYWORDS[i].equalsIgnoreCase(keyword)) {
                return RESPONSES[i];
            }
        }
        return "Ключевое слово не распознано";
    }
}
