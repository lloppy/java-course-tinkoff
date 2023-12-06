package edu.hw9.task2;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

class DirectoryTaskTest {

    @Test
    public void testDirectoryTaskWithMin1000Files() {
        Path rootPath = Paths.get("testRoot");
        StartUtil.createDirectoryWithFiles(rootPath, 2000);

        DirectoryTask directoryTask = new DirectoryTask(rootPath);
        List<Path> result = directoryTask.invoke();

        assertEquals(1, result.size());
        assertEquals(rootPath, result.get(0));

        StartUtil.deleteDirectory(rootPath);
    }
    
    @Test
    public void testDirectoryTaskWithoutMin1000Files() {
        Path rootPath = Paths.get("testRoot");
        StartUtil.createDirectoryWithFiles(rootPath, 500);

        DirectoryTask directoryTask = new DirectoryTask(rootPath);
        List<Path> result = directoryTask.invoke();

        assertEquals(0, result.size());

        StartUtil.deleteDirectory(rootPath);
    }
}
