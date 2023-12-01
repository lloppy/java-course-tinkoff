package edu.hw8.task1;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class QuoteDictionaryTest {

    @Test
    void findResponse() {
        String keyword = "личности";

        String response = QuoteDictionary.findResponse(keyword);

        String expected = "Не переходи на личности там, где их нет";
        assertEquals(expected,response);
    }

    @Test
    void findUnknownResponse() {
        String keyword = "Unknown keyword";

        String response = QuoteDictionary.findResponse(keyword);

        String expected = "Ключевое слово не распознано";
        assertEquals(expected,response);
    }
}
