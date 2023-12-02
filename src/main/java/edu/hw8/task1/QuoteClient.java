package edu.hw8.task1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import static java.lang.System.in;
import static java.lang.System.out;

@SuppressWarnings("RegexpSinglelineJava")
public final class QuoteClient {
    private QuoteClient() {
    }

    private static final int PORT = 1704;
    private static final String HOST_NAME = "localhost";
    private static final String SERVER_RESPONSE = "Ответ сервера: %s\n";
    private static final String INPUT_WORD = "Введите ключевое слово: ";
    private static final int MILLIS_TO_SLEEP = 500;
    private static final int SOCKETS_COUNT = 500;

    /**
     * Main method, the entry point for client execution.
     *
     * @param args Command-line arguments (not used in this application).
     */
    public static void main(final String[] args) {
        try {
            for (int i = 0; i < SOCKETS_COUNT; i++) {
                Socket socket = new Socket(HOST_NAME, PORT);
                String keyword = getUserInput();
                sendRequest(socket, keyword);
                readResponse(socket);
                socket.close();
                Thread.sleep(MILLIS_TO_SLEEP);
            }
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }

    private static void sendRequest(
        final Socket socket,
        final String keyword
    ) throws IOException {
        PrintWriter writer = new PrintWriter(socket.getOutputStream(), true);
        writer.println(keyword);
    }

    private static void readResponse(final Socket socket) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        String response = reader.readLine();
        out.printf(SERVER_RESPONSE, response);
    }

    private static String getUserInput() throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(in));
        out.printf(INPUT_WORD);
        return reader.readLine();
    }
}

