package edu.hw7;

import java.math.BigInteger;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class Task2Test {
    @Test
    void testFactorialForZero(){
        // given
        Integer givenNumber = 0;

        // when
        BigInteger result = Task2.getFactorial(givenNumber);

        // then
        assertEquals(BigInteger.ONE, result);
    }

    @Test
    public void testFactorialForPositiveNumber() {
        // given
        Integer givenNumber = 5;

        // when
        BigInteger result = Task2.getFactorial(givenNumber);

        // then
        assertEquals(BigInteger.valueOf(120), result);
    }

    @Test
    public void testFactorialForNegativeNumber() {
        // given
        Integer givenNumber = -2;

        // then
        assertThrows(
            IllegalArgumentException.class,
            () -> {Task2.getFactorial(givenNumber);}
        );
    }

    @Test
    public void testFactorialForLargeNumber() {
        // given
        Integer givenNumber = 20;

        // when
        BigInteger result = Task2.getFactorial(givenNumber);

        // then
        assertEquals(new BigInteger("2432902008176640000"), result);
    }


}
