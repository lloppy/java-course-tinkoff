package edu.hw9.task2;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.concurrent.ForkJoinPool;
import java.util.function.Predicate;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class SearchPredicateTaskTest {

    @RepeatedTest(1)
    @Test
    public void testSearchPredicateTask() {
        Path rootPath = Paths.get("testRoot");
        int fileCount = 2000;
        String extension = ".txt";

        StartUtil.createDirectoryWithFiles(rootPath, fileCount);
        Predicate<Path> extensionPredicate = path -> path.toString().endsWith(extension);
        SearchPredicateTask searchTask = new SearchPredicateTask(rootPath, extensionPredicate);

        ForkJoinPool forkJoinPool = new ForkJoinPool();
        List<String> result = forkJoinPool.invoke(searchTask);

        assertEquals(fileCount, result.size());
        assertTrue(result.contains(rootPath+"\\file0" + extension));
        assertTrue(result.contains(rootPath+"\\file1000" + extension));
        assertTrue(result.contains(rootPath+"\\file" + (fileCount - 1) + extension));

        StartUtil.deleteDirectory(rootPath);
    }

    @RepeatedTest(1)
    @Test
    public void testSearchPredicateTaskWithNoMatchingFiles() {
        Path rootPath = Paths.get("testRoot");
        int fileCount = 500;
        String extension = ".doc"; // а у нас расширение в createDirectoryWithFiles -
                                   // "file" + i + ".txt"

        StartUtil.createDirectoryWithFiles(rootPath, fileCount);
        Predicate<Path> extensionPredicate = path -> path.toString().endsWith(extension);

        SearchPredicateTask searchTask = new SearchPredicateTask(rootPath, extensionPredicate);
        List<String> result = searchTask.invoke();

        assertEquals(0, result.size());

        StartUtil.deleteDirectory(rootPath);
    }
}
