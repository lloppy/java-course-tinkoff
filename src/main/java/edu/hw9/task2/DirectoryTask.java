package edu.hw9.task2;

import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.RecursiveTask;

public class DirectoryTask extends RecursiveTask<List<Path>> {
    private final Path directory;
    private static final int MIN_FILES = 1000; // по заданию

    public DirectoryTask(Path directory) {
        this.directory = directory;
    }

    @Override
    protected List<Path> compute() {
        List<Path> result = new ArrayList<>();

        if (directory != null && Files.isDirectory(directory)) {
            List<DirectoryTask> subtasks = new ArrayList<>();

            try (DirectoryStream<Path> paths = Files.newDirectoryStream(directory)) {
                int filesCounter = 0;

                for (Path path : paths) {
                    if (Files.isRegularFile(path)) {
                        filesCounter++;
                    } else if (Files.isDirectory(path)) {
                        DirectoryTask subtask = new DirectoryTask(path);
                        subtask.fork();
                        subtasks.add(subtask);
                    }
                }

                if (filesCounter > MIN_FILES) {
                    result.add(directory);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }

            for (DirectoryTask subtask : subtasks) {
                result.addAll(subtask.join());
            }
        }

        return result;
    }
}
