package edu.hw10.task1;

import edu.hw10.task1.generator.RandomObjectGenerator;
import edu.hw10.task1.test_class.MyRecord;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class RandomObjectGeneratorTest {
    @Test
    public void testGenerateMyRecord() {
        // Given
        RandomObjectGenerator generator = new RandomObjectGenerator(MyRecord.class);

        // When
        MyRecord myRecordInstance = generator.nextObject();

        // Then
        assertNotNull(myRecordInstance);
        assertEquals(9, myRecordInstance.intValue());
        assertTrue(myRecordInstance.doubleValue() < 1);
        assertNotNull(myRecordInstance.string());
    }

    @Test
    public void testGenerateMyRecordWithFactoryMethod() {
        // Given
        RandomObjectGenerator generator = new RandomObjectGenerator(MyRecord.class);

        // When
        MyRecord myRecordInstance = generator.nextObject("create");

        // Then
        assertNotNull(myRecordInstance);
        assertEquals(9, myRecordInstance.intValue());
        assertTrue(myRecordInstance.doubleValue() < 1);
        assertNotNull(myRecordInstance.string());
    }
}
