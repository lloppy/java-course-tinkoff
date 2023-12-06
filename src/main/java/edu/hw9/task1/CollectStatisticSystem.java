package edu.hw9.task1;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentLinkedQueue;

public final class CollectStatisticSystem {
    public CollectStatisticSystem() {
    }

    private final ConcurrentLinkedQueue<Metric> metrics = new ConcurrentLinkedQueue<>();

    public void push(final String metricName, final double[] values) {
        metrics.add(new Metric(metricName, values));
    }

    public List<MetricType> stats() {
        Map<String, List<Double>> metricsData = new ConcurrentHashMap<>();

        metrics.forEach(metric -> {
            metricsData.compute(metric.metricName(), (key, values) -> {
                if (values == null) {
                    values = new ArrayList<>();
                }
                for (double value : metric.values()) {
                    values.add(value);
                }
                return values;
            });
        });

        List<MetricType> result = new ArrayList<>();
        metricsData.forEach((metricName, values) -> {
            double sum = 0;
            double min = Double.MAX_VALUE;
            double max = Double.MIN_VALUE;

            for (double value : values) {
                sum += value;
                min = Math.min(min, value);
                max = Math.max(max, value);
            }

            double average = sum / values.size();
            result.add(new MetricType(metricName, sum, average, min, max));
        });

        return result;
    }
}
