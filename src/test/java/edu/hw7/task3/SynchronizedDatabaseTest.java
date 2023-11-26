package edu.hw7.task3;

import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.logging.Logger;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class SynchronizedDatabaseTest {
    private static final Logger LOGGER = Logger.getLogger(SynchronizedDatabaseTest.class.getName());

    @Test
    void testMultithreading() throws InterruptedException {
        SynchronizedDatabase synchronizedDatabase = new SynchronizedDatabase();
        ExecutorService executorService = Executors.newFixedThreadPool(2);

        Runnable addTask = () -> {
            for (int i = 0; i < 100; i++) {
                Person person = new Person(i, String.format("Name%s", i), String.format("Address%s", i), String.format("Phone%s", i));
                synchronizedDatabase.add(person);
                LOGGER.info(String.format("Added: %s", person));
            }
        };

        Runnable deleteTask = () -> {
            for (int i = 0; i < 50; i++) {
                synchronizedDatabase.delete(i);
                LOGGER.info(String.format("Deleted: %s", i));
            }
        };

        executorService.submit(addTask);
        executorService.submit(deleteTask);

        executorService.shutdown();
        while (!executorService.isTerminated()) {
        }

        LOGGER.info(String.format("Final size: %s", synchronizedDatabase.getSize()));
        assertTrue(50 <= synchronizedDatabase.getSize());
    }

    @Test
    void testAddAndFind() {
        // given
        SynchronizedDatabase database = new SynchronizedDatabase();
        Person harryPotter = new Person(1, "Harry Potter", "4 Privet Drive", "555-1234");

        // when
        database.add(harryPotter);

        // then
        assertEquals(List.of(harryPotter), database.findByName("Harry Potter"));
        assertEquals(List.of(harryPotter), database.findByAddress("4 Privet Drive"));
        assertEquals(List.of(harryPotter), database.findByPhone("555-1234"));
    }

    @Test
    void testDelete() {
        // given
        SynchronizedDatabase database = new SynchronizedDatabase();
        Person harryPotter = new Person(1, "Harry Potter", "4 Privet Drive", "555-1234");

        // when
        database.add(harryPotter);
        database.delete(1);

        // then
        assertEquals(List.of(), database.findByName("Harry Potter"));
        assertEquals(List.of(), database.findByAddress("4 Privet Drive"));
        assertEquals(List.of(), database.findByPhone("555-1234"));
    }

    @Test
    void testFindByValuesAvailability() {
        // given
        SynchronizedDatabase database = new SynchronizedDatabase();
        Person gollum = new Person(5, "Gollum", "Caves of Misty Mountains", "8 (800) 555-35-55");

        // when
        database.add(gollum);

        // then
        assertEquals(List.of(gollum), database.findByName("Gollum"));
        assertEquals(List.of(gollum), database.findByAddress("Caves of Misty Mountains"));
        assertEquals(List.of(gollum), database.findByPhone("8 (800) 555-35-55"));

        // when
        database.delete(5);

        // then
        assertEquals(List.of(), database.findByName("Gollum"));
        assertEquals(List.of(), database.findByAddress("Caves of Misty Mountains"));
        assertEquals(List.of(), database.findByPhone("8 (800) 555-35-55"));
    }
}
