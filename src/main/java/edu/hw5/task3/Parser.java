package edu.hw5.task3;

import java.time.LocalDate;
import java.util.Optional;

public abstract class Parser {
    public Parser nextParser;

    public Parser(Parser nextParser) {
        this.nextParser = nextParser;
    }

    public abstract Optional<LocalDate> getParseDate(String string);

}
