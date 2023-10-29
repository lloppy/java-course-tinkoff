package edu.hw3.task5;

public final class Person {
    private final String firstName;
    private final String lastName;

    public Person(final String fullName) {
        String[] parts = new String[] {"", ""};

        if (fullName != null && !fullName.isEmpty()) {
            parts = fullName.split(" ");
        }

        if (parts.length == 2) {
            this.firstName = parts[0];
            this.lastName = parts[1];
        } else {
            this.firstName = fullName;
            this.lastName = "";
        }
    }

    public String getLastName() {
        if (lastName.isEmpty()) {
            return firstName;
        }
        return lastName;
    }

    public String getFullPersonName() {
        if (lastName.isEmpty()) {
            return firstName;
        }
        return firstName + " " + lastName;
    }
}
