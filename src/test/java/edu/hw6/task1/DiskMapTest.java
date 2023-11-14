package edu.hw6.task1;

import org.junit.jupiter.api.Test;
import java.nio.file.Path;
import java.nio.file.Paths;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class DiskMapTest {

    @Test
    void testSaveFile() {
        DiskMap diskMap = new DiskMap();
        diskMap.put("key1", "value1");
        diskMap.put("key2", "value2");

        Path currentDirectory = Paths.get("src/test/java/edu/hw6/task1").toAbsolutePath();
        Path filePath = currentDirectory.resolve("testDiskMap.txt");

        diskMap.saveFile(filePath);
        assertEquals("value1", diskMap.get("key1"));
        assertEquals("value2", diskMap.get("key2"));
    }

    @Test
    void testReadFile() {
        DiskMap diskMap = new DiskMap();

        Path currentDirectory = Paths.get("src/test/java/edu/hw6/task1").toAbsolutePath();
        Path filePath = currentDirectory.resolve("testDiskMap.txt");

        diskMap.readFile(filePath);
        assertEquals("value1", diskMap.get("key1"));
        assertEquals("value2", diskMap.get("key2"));
    }

    @Test
    void testSaveAndReadFile() {
        DiskMap diskMap = new DiskMap();
        diskMap.put("Ключ", "значение");
        diskMap.put("Правильный ключ", "правильное значение");

        assertTrue(diskMap.containsKey("Правильный ключ"));
        assertTrue(diskMap.containsValue("правильное значение"));

        Path currentDirectory = Paths.get("src/test/java/edu/hw6/task1").toAbsolutePath();
        Path filePath = currentDirectory.resolve("testSaveAndRead.txt");

        diskMap.saveFile(filePath);

        DiskMap newDisk = new DiskMap();
        newDisk.readFile(filePath);

        assertFalse(newDisk.isEmpty());
        assertFalse(newDisk.containsKey("Неправильный ключ"));
        assertFalse(newDisk.containsValue("неправильное значение"));

        assertTrue(newDisk.containsKey("Правильный ключ"));
        assertTrue(newDisk.containsValue("правильное значение"));
    }
}
