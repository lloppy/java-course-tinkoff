package edu.log.generators;

import edu.log.analyzer.LogAnalyzer;
import edu.log.entity.CodeResponse;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.OffsetDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Map;

public class MarkdownReportGenerator extends ReportGenerator {
    private LogAnalyzer logAnalyzer;

    public MarkdownReportGenerator() {
        super();
    }


    @Override
    public void generateReport(String fileName) {
        Path currentDirectory = Paths.get("src/main/java/edu/log/generators/reports").toAbsolutePath();
        Path filePath = currentDirectory.resolve(fileName + ".md");
        logAnalyzer = new LogAnalyzer(path, from, to);

        try (PrintWriter writer = new PrintWriter(new FileWriter(filePath.toFile()))) {
            writeGeneralInfoSection(logAnalyzer, writer, fileName, from, to);
            writeResourceSection(logAnalyzer, writer);
            writeResponseCodeSection(logAnalyzer, writer);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void writeGeneralInfoSection(
            LogAnalyzer logAnalyzer,
            PrintWriter writer,
            String fileName,
            OffsetDateTime from,
            OffsetDateTime to
    ) {
        writer.println("#### Общая информация\n");
        writer.println("|        Метрика        |     Значение |");
        writer.println("|:---------------------:|-------------:|");
        writer.println("|         Файл          | " + fileName + " |");
        writer.println("|    Начальная дата     | " + from.format(DateTimeFormatter.ofPattern("dd.MMM.yyyy")) + " |");
        writer.println("|     Конечная дата     | " + (to.isEqual(OffsetDateTime.now()) ? "-" : to.format(DateTimeFormatter.ofPattern("dd.MMM.yyyy"))) + " |");
        writer.println("|  Количество запросов  | " + logAnalyzer.getTotalRequests() + " |");
        writer.println("| Средний размер ответа | " + logAnalyzer.getAverageResponseSize() + "b |");
        writer.println();
    }

    private static void writeResourceSection(LogAnalyzer logAnalyzer, PrintWriter writer) {
        writer.println("#### Запрашиваемые ресурсы\n");
        writer.println("|     Ресурс      | Количество |");
        writer.println("|:---------------:|-----------:|");

        Map<String, Integer> resourceCount = logAnalyzer.getResourceCount();
        for (Map.Entry<String, Integer> entry : resourceCount.entrySet()) {
            writer.println("|  `" + entry.getKey() + "`  |      " + entry.getValue() + " |");
        }

        writer.println();
    }

    private static void writeResponseCodeSection(LogAnalyzer logAnalyzer, PrintWriter writer) {
        writer.println("#### Коды ответа\n");
        writer.println("| Код |          Имя          | Количество |");
        writer.println("|:---:|:---------------------:|-----------:|");

        Map<Integer, Integer> responseCodeCount = logAnalyzer.getResponseCodeCount();
        for (Map.Entry<Integer, Integer> entry : responseCodeCount.entrySet()) {
            int codeResponse = entry.getKey();
            writer.println("| " + codeResponse + " | " + CodeResponse.getDescriptionByCode(codeResponse) + " |       " +
                entry.getValue() + " |");
        }
    }

}
