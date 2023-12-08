package edu.hw8.task1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import static java.lang.System.out;

@SuppressWarnings({"RegexpSinglelineJava", "uncommentedmain"})
public final class QuoteServer {
    private QuoteServer() {
    }

    private static final int PORT = 1704;
    private static final int MAX_CONNECTIONS = 4;
    private static final String CLIENT_IS_CONNECTED = "Подключен клиент: %s\n";
    private static final String START_SERVER = "Сервер запущен. Ожидание подключений...\n";

    private static ExecutorService threadPool = Executors.newFixedThreadPool(MAX_CONNECTIONS);

    /**
     * Main : method that simulates a server connection.
     * The server waits for clients to connect indefinitely, accepting connections and
     * assigning each client to a thread in a fixed-size thread pool.
     *
     * @param args Command-line arguments (not used in this application).
     */
    public static void main(final String[] args) {
        try (ServerSocket serverSocket = new ServerSocket(PORT)) {
            out.printf(START_SERVER);
            while (true) {
                Socket clientSocket = serverSocket.accept();
                out.printf(CLIENT_IS_CONNECTED, clientSocket.getInetAddress());

                threadPool.execute(() -> handleClient(clientSocket));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void handleClient(final Socket clientSocket) {
        try (
            BufferedReader reader = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
            PrintWriter writer = new PrintWriter(clientSocket.getOutputStream(), true);
        ) {
            String keyword = reader.readLine();
            String response = QuoteDictionary.findResponse(keyword);
            writer.println(response);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
