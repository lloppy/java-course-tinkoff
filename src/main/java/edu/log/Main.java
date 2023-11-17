package edu.log;

import edu.log.entity.FileFormat;
import edu.log.generators.AsciiDocReportGenerator;
import edu.log.generators.MarkdownReportGenerator;
import edu.log.generators.ReportGenerator;
import java.util.Scanner;

public final class Main {
    private Main() {
    }

    /**
     * This is the main method that serves as the entry point for the application.
     * It reads user input, processes commands, and generates reports accordingly.
     *
     * @param args The command-line arguments.
     */
    public static void main(String[] args) {
        String command = new Scanner(System.in).nextLine();

        ReportGenerator generator = createReportGenerator(command);
        generator.generateReport("reportForOneDay");
    }

    private static ReportGenerator createReportGenerator(String command) {
        ReportGenerator generator;
        if (command.contains("--format adoc")) {
            generator = new AsciiDocReportGenerator();
            generator.setFormat(FileFormat.ADOC);
        } else {
            generator = new MarkdownReportGenerator();
            generator.setFormat(FileFormat.MARKDOWN);
        }
        return setGeneratorProperties(generator, command);
    }

    private static ReportGenerator setGeneratorProperties(ReportGenerator generator, String command) {
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

    private static String findCommand(String line, String command) {
        int startIndex = line.indexOf(command) + command.length();
        String substring = line.substring(startIndex);
        int endIndex = substring.indexOf(' ');

        return line.substring(startIndex, startIndex + endIndex);
    }
}
