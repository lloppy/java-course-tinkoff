package edu.hw6.task5;

import java.util.Arrays;
import org.junit.jupiter.api.Test;

class HackerNewsTest {

    @Test
    void test() {
        HackerNews hackerNews = new HackerNews();

        System.out.println(Arrays.toString(hackerNews.hackerNewsTopStories()));
        String newsTitle = hackerNews.news(37570037);
        System.out.println(newsTitle);
    }

    @Test
    void test2() {
        HackerNews hackerNews = new HackerNews();

        System.out.println(Arrays.toString(hackerNews.hackerNewsTopStories()));
        String newsTitle = hackerNews.news(38249214);
        System.out.println(newsTitle);
    }
}
