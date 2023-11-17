package edu.log;

import edu.log.entity.FileFormat;
import edu.log.generators.AsciiDocReportGenerator;
import edu.log.generators.MarkdownReportGenerator;
import edu.log.generators.ReportGenerator;

import java.util.Scanner;

public final class Run {
    public static void main(String[] args) {
        String command = new Scanner(System.in).nextLine();

        // java -jar nginx-log-stats.jar --path src/main/java/edu/log/repository/logs.txt --from 18/May/2015 --format adoc
        // java -jar nginx-log-stats.jar --path src/main/java/edu/log/repository/logs.txt --from 18/May/2015 --to 19/May/2015 --format markdown

        ReportGenerator generator;
        if (command.contains("--format adoc")) {
            generator = new AsciiDocReportGenerator();
            generator.setFormat(FileFormat.ADOC);
        } else {
            generator = new MarkdownReportGenerator();
            generator.setFormat(FileFormat.MARKDOWN);
        }

        if (command.contains("--path")) {
            generator.setPath(findCommand(command, "--path "));
        }

        if (command.contains("--from")) {
            generator.setFrom(findCommand(command, "--from "));
        }

        if (command.contains("--to")) {
            generator.setTo(findCommand(command, "--to "));
        }

        generator.generateReport("reportForOneDay");
    }

    private static String findCommand(String line, String command) {
        int startIndex = line.indexOf(command) + command.length();
        String substring = line.substring(startIndex);
        int endIndex = substring.indexOf(' ');

        return line.substring(startIndex, startIndex + endIndex);
    }
}
