package edu.hw8.task1;

import java.io.*;
import java.net.*;

public class QuoteClient {
    private static final int PORT = 9876;

    public static void main(String[] args) {
        try {
            for (int i = 0; i < 10; i++) {
                Socket socket = new Socket("localhost", PORT);
                String keyword = getUserInput();
                sendRequest(socket, keyword);
                readResponse(socket);
                socket.close();
                Thread.sleep(500);
            }
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }

    private static void sendRequest(Socket socket, String keyword) throws IOException {
        PrintWriter writer = new PrintWriter(socket.getOutputStream(), true);
        writer.println(keyword);
    }

    private static void readResponse(Socket socket) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        String response = reader.readLine();
        System.out.println("Ответ сервера: " + response);
    }

    private static String getUserInput() throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        System.out.print("Введите ключевое слово: ");
        return reader.readLine();
    }
}

