package edu.log;

import edu.log.entity.FileFormat;
import edu.log.generators.AsciiDocReportGenerator;
import edu.log.generators.MarkdownReportGenerator;
import edu.log.generators.ReportGenerator;

public final class CommandProcessor {
    private CommandProcessor() {
    }

    public static ReportGenerator processCommand(final String command) {
        ReportGenerator generator;

        if (!command.contains("java -jar nginx-log-stats.jar")) {
            throw new IllegalArgumentException("Invalid command");
        }

        if (command.contains("--format adoc")) {
            generator = new AsciiDocReportGenerator();
            generator.setFormat(FileFormat.ADOC);
        } else {
            generator = new MarkdownReportGenerator();
            generator.setFormat(FileFormat.MARKDOWN);
        }

        return setGeneratorProperties(generator, command);
    }

    private static ReportGenerator setGeneratorProperties(
        final ReportGenerator generator,
        final String command
    ) {
        if (command.contains("--path")) {
            generator.setPath(findCommand(command, "--path "));
        }

        if (command.contains("--from")) {
            generator.setFrom(findCommand(command, "--from "));
        }

        if (command.contains("--to")) {
            generator.setTo(findCommand(command, "--to "));
        }
        return generator;
    }

    private static String findCommand(
        final String line,
        final String command
    ) {
        int startIndex = line.indexOf(command) + command.length();
        String substring = line.substring(startIndex);
        int endIndex = substring.indexOf(' ');

        if (endIndex < 0) {
            endIndex = substring.length();
        }

        return line.substring(startIndex, startIndex + endIndex);
    }
}
