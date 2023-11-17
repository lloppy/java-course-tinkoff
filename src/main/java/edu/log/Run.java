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
            int startIndex = command.indexOf("--path ") + "--path ".length();
            String substring = command.substring(startIndex);
            int endIndex = substring.indexOf(' ');

            generator.setPath(command.substring(startIndex, startIndex + endIndex));
        }

        if (command.contains("--from")) {
            int startIndex = command.indexOf("--from ") + "--from ".length();
            String substring = command.substring(startIndex);
            int endIndex = substring.indexOf(' ');

            generator.setFrom(command.substring(startIndex, startIndex + endIndex));
        }

        if (command.contains("--to")) {
            int startIndex = command.indexOf("--to ") + "--to ".length();
            String substring = command.substring(startIndex);
            int endIndex = substring.indexOf(' ');

            generator.setTo(command.substring(startIndex, startIndex + endIndex));
        }
        generator.generateReport("reportForOneDay");
    }
}

