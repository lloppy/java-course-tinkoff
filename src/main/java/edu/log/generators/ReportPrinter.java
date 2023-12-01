package edu.log.generators;

import edu.log.analyzer.LogAnalyzer;
import edu.log.entity.CodeResponse;
import java.io.PrintWriter;
import java.time.OffsetDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Map;

public final class ReportPrinter {
    private static final DateTimeFormatter DATE_TIME_FORMATTER =
        DateTimeFormatter.ofPattern("dd.MMM.yyyy");

    private ReportPrinter() {
    }

    public static void writeGeneralInfoSection(
        final String fileFormat,
        final LogAnalyzer logAnalyzer,
        final PrintWriter writer,
        final String fileName,
        final OffsetDateTime from,
        final OffsetDateTime to
    ) {
        writer.println(String.format("%s Общая информация\n", fileFormat));
        writer.println("|        Метрика        |     Значение |");
        writer.println("|:---------------------:|-------------:|");
        writer.println(String.format("|         Файл          | %s |", fileName));
        writer.println(String.format("|    Начальная дата     | %s |", from.format(DATE_TIME_FORMATTER)));
        writer.println(String.format("|     Конечная дата     | %s |",
            to.isEqual(OffsetDateTime.now()) ? "-" : to.format(DATE_TIME_FORMATTER)));
        writer.println(String.format("|  Количество запросов  | %d |", logAnalyzer.getTotalRequests()));
        writer.println(String.format("| Средний размер ответа | %db |\n", logAnalyzer.getAverageResponseSize()));
    }

    public static void writeResourceSection(
        final String fileFormat,
        final LogAnalyzer logAnalyzer,
        final PrintWriter writer
    ) {
        writer.println(String.format("%s Запрашиваемые ресурсы\n", fileFormat));
        writer.println("|     Ресурс      | Количество |");
        writer.println("|:---------------:|-----------:|");

        Map<String, Integer> resourceCount = logAnalyzer.getResourceCount();
        for (Map.Entry<String, Integer> entry : resourceCount.entrySet()) {
            writer.println(String.format("|  `%s`  |      %d |", entry.getKey(), entry.getValue()));
        }
        writer.println();
    }

    public static void writeResponseCodeSection(
        final String fileFormat,
        final LogAnalyzer logAnalyzer,
        final PrintWriter writer
    ) {
        writer.println(String.format("%s Коды ответа\n", fileFormat));
        writer.println("| Код |          Имя          | Количество |");
        writer.println("|:---:|:---------------------:|-----------:|");

        Map<Integer, Integer> responseCodeCount = logAnalyzer.getResponseCodeCount();
        for (Map.Entry<Integer, Integer> entry : responseCodeCount.entrySet()) {
            int codeResponse = entry.getKey();
            writer.println(String.format("| %d | %s | %d |",
                codeResponse, CodeResponse.getDescriptionByCode(codeResponse), entry.getValue()));
        }
    }
}
