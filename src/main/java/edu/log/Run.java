package edu.log;

import edu.log.generators.MarkdownReportGenerator;
import edu.log.generators.ReportGenerator;

public class Run {
    public static void main(String[] args) {
        ReportGenerator reportGenerator = new MarkdownReportGenerator();
        reportGenerator.generateReport("report2.md");
    }
}
