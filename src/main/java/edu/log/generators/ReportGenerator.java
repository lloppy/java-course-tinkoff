package edu.log.generators;

public interface ReportGenerator {
    default void generateReport(String fileName) {
    }
}
