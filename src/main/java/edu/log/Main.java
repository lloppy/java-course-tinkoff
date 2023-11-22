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

        ReportGenerator generator = CommandProcessor.processCommand(command);
        generator.generateReport("new_report");
    }
}
