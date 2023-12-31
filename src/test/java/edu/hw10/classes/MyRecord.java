package edu.hw10.classes;

import edu.hw10.task1.annotations.Max;
import edu.hw10.task1.annotations.Min;
import edu.hw10.task1.annotations.NotNull;

public record MyRecord(@Max(10) @Min(9) int intValue, @Max(1) double doubleValue, @NotNull String string) {
    public static MyRecord createMyRecord(@Max(10) @Min(9) int intValue, @Max(1) double doubleValue, @NotNull String string) {
        return new MyRecord(intValue, doubleValue, string);
    }
}
