package edu.hw10.classes;

import edu.hw10.task1.annotations.Max;
import edu.hw10.task1.annotations.Min;
import edu.hw10.task1.annotations.NotNull;

public class MyClass {
    @Min(9) @Max(10) private final int intValue;
    @Max(1) private final double doubleValue;
    @NotNull private final String stringValue;

    public MyClass(@Min(9) @Max(10) int intValue, @Max(1) double doubleValue, @NotNull String stringValue) {
        this.intValue = intValue;
        this.doubleValue = doubleValue;
        this.stringValue = stringValue;
    }

    public static MyClass createMyClass(
        @Min(9) @Max(10) int intValue,
        @Max(1) double doubleValue,
        @NotNull String string
    ) {
        return new MyClass(intValue, doubleValue, string);
    }

    public int getIntValue() {
        return intValue;
    }

    public double getDoubleValue() {
        return doubleValue;
    }

    public String getStringValue() {
        return stringValue;
    }
}
