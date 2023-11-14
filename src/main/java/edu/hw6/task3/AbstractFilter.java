package edu.hw6.task3;

import java.io.IOException;
import java.nio.file.DirectoryStream;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;

public interface AbstractFilter extends DirectoryStream.Filter<Path> {
    AbstractFilter regularFile = Files::isRegularFile;
    AbstractFilter readable = Files::isReadable;
    AbstractFilter writable = Files::isWritable;

    boolean accept(Path entry) throws IOException;

    default AbstractFilter and(AbstractFilter other) {
        return entry -> accept(entry) && other.accept(entry);
    }

    static AbstractFilter largerThan(long size) {
        return entry -> Files.size(entry) > size;
    }

    static AbstractFilter smallThan(long size) {
        return entry -> Files.size(entry) < size;
    }

    static AbstractFilter sizeEquals(long size) {
        return entry -> Files.size(entry) == size;
    }

    static AbstractFilter globMatches(String glob) {
        return entry -> FileSystems.getDefault().getPathMatcher("glob:" + glob).matches(entry.getFileName());
    }

    static AbstractFilter regexMatches(String regex) {
        return entry -> entry.getFileName().toString().matches(regex);
    }

    static AbstractFilter startsWith(String prefix) {
        return entry -> entry.getFileName().toString().startsWith(prefix);
    }

    static AbstractFilter endsWith(String suffix) {
        return entry -> entry.getFileName().toString().endsWith(suffix);
    }

    static AbstractFilter magicNumber(int... magicBytes) {
        return entry -> {
            try {
                byte[] fileBytes = Files.readAllBytes(entry);
                if (fileBytes.length >= magicBytes.length) {
                    for (int i = 0; i < magicBytes.length; i++) {
                        if ((fileBytes[i] & 0xFF) != magicBytes[i]) {
                            return false;
                        }
                    }
                    return true;
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
            return false;
        };
    }

    static AbstractFilter and(DirectoryStream.Filter<Path>... filters) {
        return entry -> {
            for (DirectoryStream.Filter<Path> filter : filters) {
                if (!filter.accept(entry)) {
                    return false;
                }
            }
            return true;
        };
    }
}
