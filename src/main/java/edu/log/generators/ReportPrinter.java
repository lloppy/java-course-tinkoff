package edu.log.generators;

import edu.log.analyzer.LogAnalyzer;
import edu.log.entity.CodeResponse;
import java.io.PrintWriter;
import java.time.OffsetDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Map;

public class ReportPrinter {
    private static final DateTimeFormatter DATE_TIME_FORMATTER =
            DateTimeFormatter.ofPattern("dd.MMM.yyyy");

    private ReportPrinter() {
    }

    public static void writeGeneralInfoSection(
            String fileFormat,
            LogAnalyzer logAnalyzer,
            PrintWriter writer,
            String fileName,
            OffsetDateTime from,
            OffsetDateTime to
    ) {
        writer.println(fileFormat + " Общая информация\n");
        writer.println("|        Метрика        |     Значение |");
        writer.println("|:---------------------:|-------------:|");
        writer.println("|         Файл          | " + fileName + " |");
        writer.println("|    Начальная дата     | " + from.format(DATE_TIME_FORMATTER) + " |");
        writer.println("|     Конечная дата     | " + (to.isEqual(OffsetDateTime.now())
                ? "-" : to.format(DATE_TIME_FORMATTER) + " |"));
        writer.println("|  Количество запросов  | " + logAnalyzer.getTotalRequests() + " |");
        writer.println("| Средний размер ответа | " + logAnalyzer.getAverageResponseSize() + "b |");
        writer.println();
    }

    public static void writeResourceSection(
            String fileFormat,
            LogAnalyzer logAnalyzer,
            PrintWriter writer
    ) {
        writer.println(fileFormat + " Запрашиваемые ресурсы\n");
        writer.println("|     Ресурс      | Количество |");
        writer.println("|:---------------:|-----------:|");

        Map<String, Integer> resourceCount = logAnalyzer.getResourceCount();
        for (Map.Entry<String, Integer> entry : resourceCount.entrySet()) {
            writer.println("|  `" + entry.getKey() + "`  |      " + entry.getValue() + " |");
        }
        writer.println();
    }

    public static void writeResponseCodeSection(
            String fileFormat,
            LogAnalyzer logAnalyzer,
            PrintWriter writer
    ) {
        writer.println(fileFormat + " Коды ответа\n");
        writer.println("| Код |          Имя          | Количество |");
        writer.println("|:---:|:---------------------:|-----------:|");

        Map<Integer, Integer> responseCodeCount = logAnalyzer.getResponseCodeCount();
        for (Map.Entry<Integer, Integer> entry : responseCodeCount.entrySet()) {
            int codeResponse = entry.getKey();
            writer.println("| " + codeResponse + " | " + CodeResponse.getDescriptionByCode(codeResponse)
                    + " |       " + entry.getValue() + " |");
        }
    }
}
