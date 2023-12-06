package edu.hw9.task2;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public final class StartUtil {
    private static final Logger LOGGER = LogManager.getLogger(StartUtil.class);

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
            LOGGER.error("Error creating directory with files", e);
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
                        LOGGER.error("Error deleting directory", e);
                    }
                });
        } catch (IOException e) {
            LOGGER.error("Error walking through directory", e);
        }
    }
}
