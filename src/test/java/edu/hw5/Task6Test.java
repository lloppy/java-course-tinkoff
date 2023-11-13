package edu.hw5;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Task6Test {

    @Test
    void isSubsequence() {
        String sequence = "achfdbaabgabcaabg";
        assertEquals(true, Task6.isSubsequence("abc", sequence));
        assertEquals(false, Task6.isSubsequence("abz", sequence));
    }
}
