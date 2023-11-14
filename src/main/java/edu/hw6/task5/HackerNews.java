package edu.hw6.task5;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.time.Duration;
import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public final class HackerNews {

    private final HttpClient client;

    public HackerNews() {
        this.client = HttpClient.newHttpClient();
    }

    public long[] hackerNewsTopStories() {
        HttpRequest request = createHttpRequest("https://hacker-news.firebaseio.com/v0/topstories.json");

        try {
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
            String jsonResponse = response.body().replaceAll("\\[|\\]", "");

            return Arrays.stream(jsonResponse.split(","))
                .mapToLong(Long::parseLong)
                .toArray();

        } catch (Exception e) {
            return new long[]{};
        }
    }

    public String news(final long id) {
        HttpRequest request = createHttpRequest("https://hacker-news.firebaseio.com/v0/item/" + id + ".json");

        try {
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
            String jsonString = response.body();

            Pattern pattern = Pattern.compile("\"title\":\"([^\"]+)");
            Matcher matcher = pattern.matcher(jsonString);

            return matcher.find() ? matcher.group(1) : "Title not found";

        } catch (Exception e) {
            return "Ошибка";
        }
    }

    private HttpRequest createHttpRequest(final String url) {
        return HttpRequest.newBuilder(URI.create(url))
            .GET()
            .timeout(Duration.ofSeconds(5))
            .build();
    }
}
