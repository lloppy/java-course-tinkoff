package edu.hw9.task2;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;

public final class StartUtil {
    private StartUtil() {
    }

    public static void createDirectoryWithFiles(
        final Path rootPath,
        final int fileCount
    ) {
        try {
            Files.createDirectories(rootPath);
            for (int i = 0; i < fileCount; i++) {
                String fileName = "file" + i + ".txt";
                Path filePath = rootPath.resolve(fileName);
                Files.write(filePath, "Test".getBytes(), StandardOpenOption.CREATE);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void deleteDirectory(final Path directory) {
        try {
            Files.walk(directory)
                .sorted((a, b) -> -a.compareTo(b))
                .forEach(path -> {
                    try {
                        Files.deleteIfExists(path);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                });
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
