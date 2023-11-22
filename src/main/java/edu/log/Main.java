package edu.log;

import edu.log.generators.ReportGenerator;

public final class Main {
    private static String command;

    public Main(final String userCommand) {
        this.command = userCommand;
    }

    /**
     * This is the main method that serves as the entry point for the application.
     * It reads user input, processes commands, and generates reports accordingly.
     *
     * @param args The command-line arguments.
     */
    public static void main(final String[] args) {
        // String command = new Scanner(System.in).nextLine();

        ReportGenerator generator = CommandProcessor.processCommand(command);
        generator.generateReport("new_report");
    }
}
