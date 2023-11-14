package edu.hw6.task3;

import edu.hw6.task1.DiskMap;
import java.io.IOException;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import org.junit.jupiter.api.Test;
import static edu.hw6.task3.AbstractFilter.readable;
import static edu.hw6.task3.AbstractFilter.regularFile;
import static edu.hw6.task3.AbstractFilter.writable;

class AbstractFilterTest {

    private void createDisk(String filename) {
        DiskMap diskMap = new DiskMap();

        Path currentDirectory = Paths.get("src/test/java/edu/hw6/task2/").toAbsolutePath();
        Path filePath = currentDirectory.resolve(filename);

        diskMap.saveFile(filePath);
    }

    @Test
    void testThatAllFilesRegularReadableWritableReturnedTrue() {
        List<String> filenames = List.of(
            "file1.txt",
            "file2.txt",
            "pictureFile1.png",
            "pictureFile2.png"
        );

        Path currentDirectory = Paths.get("src/test/java/edu/hw6/task3/files/rrw/").toAbsolutePath();
        for (String filename : filenames) {
            Path filePath = currentDirectory.resolve(filename);

            try {
                Files.write(filePath, new byte[]{(byte) 0x89, (byte) 'P', (byte) 'N', (byte) 'G'});
                readable.accept(filePath);
                writable.accept(filePath);
                regularFile.accept(filePath);

            } catch (IOException e) {
                throw new RuntimeException(e);
            }

        }

        System.out.println("Filtered Files:");
        DirectoryStream.Filter<Path> filter = regularFile
            .and(readable)
            .and(writable);

        try (DirectoryStream<Path> entries = Files.newDirectoryStream(currentDirectory, filter)) {
            entries.forEach(System.out::println);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    @Test
    void testThatAllFilesIsReturnedTrue() {
        List<String> filenames = List.of(
            "file1.txt",
            "file2.txt",
            "pictureFile1.png",
            "pictureFile2.png"
        );

        Path currentDirectory = Paths.get("src/test/java/edu/hw6/task3/files/rrw/").toAbsolutePath();
        for (String filename : filenames) {
            Path filePath = currentDirectory.resolve(filename);

            try {
                Files.write(filePath, new byte[]{(byte) 0x89, (byte) 'P', (byte) 'N', (byte) 'G'});
                readable.accept(filePath);
                writable.accept(filePath);
                regularFile.accept(filePath);

            } catch (IOException e) {
                throw new RuntimeException(e);
            }

        }

        System.out.println("Filtered Files:");

        DirectoryStream.Filter<Path> filter = regularFile
            .and(readable)
            .and(writable);

        try (DirectoryStream<Path> entries = Files.newDirectoryStream(currentDirectory, filter)) {
            entries.forEach(System.out::println);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
