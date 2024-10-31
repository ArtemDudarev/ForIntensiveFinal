package org.example;

import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class LogFile {
    private static final String LOG_FILE = "ecosystem_log.txt";
    private static final DateTimeFormatter DATE_FORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

    public static void log(String message) {
        try (FileWriter writer = new FileWriter(LOG_FILE, true)) {
            LocalDateTime now = LocalDateTime.now();
            String formattedDateTime = now.format(DATE_FORMATTER);
            writer.write(formattedDateTime + ": " + message + "\n");
        } catch (IOException e) {
            System.err.println("Error writing to log file: " + e.getMessage());
        }
    }
}
