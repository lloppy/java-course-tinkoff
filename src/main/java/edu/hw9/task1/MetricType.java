package edu.hw9.task1;

public record MetricType(
    String metricName,
    double sum,
    double average,
    double min,
    double max) {
}
