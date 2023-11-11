package edu.hw5.task3;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

public final class Task3 {
    private List<Parser> handlers;

    public Task3() {
        buildChain();
    }

    Optional<LocalDate> parseDate(String string) {
        return handlers.stream()
            .map(parser -> parser.getParseDate(string))
            .filter(Optional::isPresent)
            .map(Optional::get)
            .findFirst();
    }

    private void buildChain() {
        DateParser dateParser = new DateParser(null);
        MixParser mixParser = new MixParser(dateParser);
        StringParser stringParser = new StringParser(mixParser);

        handlers = List.of(stringParser, mixParser, dateParser);
    }
}
