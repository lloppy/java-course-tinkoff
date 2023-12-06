package edu.hw9.task2;

import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.RecursiveTask;
import java.util.function.Predicate;

public class SearchPredicateTask extends RecursiveTask<List<String>> {
    private final Path directory;
    private final Predicate<Path> predicate;

    public SearchPredicateTask(Path directory, Predicate<Path> predicate) {
        this.directory = directory;
        this.predicate = predicate;
    }

    @Override
    protected List<String> compute() {
        List<String> result = new ArrayList<>();
        List<SearchPredicateTask> forks = new ArrayList<>();

        try (DirectoryStream<Path> paths = Files.newDirectoryStream(directory)) {
            for (Path path : paths) {
                if (Files.isRegularFile(path)) {
                    if (predicate.test(path)) {
                        result.add(path.toString());
                    }
                } else if (Files.isDirectory(path)) {
                    SearchPredicateTask task = new SearchPredicateTask(path, predicate);
                    task.fork();
                    forks.add(task);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        for (SearchPredicateTask task : forks) {
            result.addAll(task.join());
        }

        return result;
    }
}
