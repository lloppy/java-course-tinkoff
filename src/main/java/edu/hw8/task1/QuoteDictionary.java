package edu.hw8.task1;

public final class QuoteDictionary {
    private QuoteDictionary() {
    }

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

    public static String findResponse(final String keyword) {
        for (int i = 0; i < KEYWORDS.length; i++) {
            if (KEYWORDS[i].equalsIgnoreCase(keyword)) {
                return RESPONSES[i];
            }
        }
        return "Ключевое слово не распознано";
    }
}

