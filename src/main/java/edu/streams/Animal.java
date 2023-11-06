package edu.streams;

public record Animal(
    String name,
    Type type,
    Sex sex,
    int age,
    int height,
    int weight,
    boolean bites
) {
    enum Type {
        CAT, DOG, BIRD, FISH, SPIDER
    }

    enum Sex {
        M, F
    }

    private static final int PAWS_CAT_DOG = 4;
    private static final int PAWS_BIRD = 2;
    private static final int PAWS_FISH = 0;
    private static final int PAWS_SPIDER = 8;

    public int paws() {
        return switch (type) {
            case CAT, DOG -> PAWS_CAT_DOG;
            case BIRD -> PAWS_BIRD;
            case FISH -> PAWS_FISH;
            case SPIDER -> PAWS_SPIDER;
        };
    }
}
