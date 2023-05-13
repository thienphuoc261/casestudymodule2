package service;

import java.io.BufferedReader;
import java.io.FileReader;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class ReportExport {
    private static final String EXPORT_HISTORY_FILE = "C:\\Users\\ADMIN\\Desktop\\New folder (2)\\Case Study Module 2\\untitled\\src\\data\\exportHistory.csv";
    private static final String IMPORT_HISTORY_FILE = "C:\\Users\\ADMIN\\Desktop\\New folder (2)\\Case Study Module 2\\untitled\\src\\data\\importHistory.csv";

    public static void exportReportByDate(LocalDate reportDate) {
        try {
            FileReader fileReader = new FileReader(EXPORT_HISTORY_FILE);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            String line;

            while ((line = bufferedReader.readLine()) != null) {
                String[] data = line.split(" - ");
                String dateString = data[0].trim();
                LocalDateTime dateTime = LocalDateTime.parse(dateString, DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss"));
                LocalDate date = dateTime.toLocalDate();

                if (date.equals(reportDate)) {
                    System.out.println(line);
                }
            }

            bufferedReader.close();
            fileReader.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void importReportByDate(LocalDate importDate) {
        try {
            FileReader fileReader = new FileReader(IMPORT_HISTORY_FILE);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            String line;

            while ((line = bufferedReader.readLine()) != null) {
                String[] data = line.split(" - ");
                String dateString = data[0].trim();
                LocalDateTime dateTime = LocalDateTime.parse(dateString, DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss"));
                LocalDate date = dateTime.toLocalDate();

                if (date.equals(importDate)) {
                    System.out.println(line);
                }
            }

            bufferedReader.close();
            fileReader.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void importReportByWeek(LocalDate endDate) {
        LocalDate starDate = endDate.minusDays(7);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
        try {
            FileReader fileReader = new FileReader(IMPORT_HISTORY_FILE);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            String line;

            while ((line = bufferedReader.readLine()) != null) {
                String[] data = line.split(" - ");
                String dateString = data[0].trim();
                LocalDateTime exportDateTime = LocalDateTime.parse(dateString, formatter).toLocalDate().atStartOfDay();

                if (exportDateTime.toLocalDate().isAfter(starDate) && exportDateTime.toLocalDate().isBefore(endDate.plusDays(1))) {
                    System.out.println(line);
                }
            }

            bufferedReader.close();
            fileReader.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void exportReportByWeek(LocalDate endDate) {
        LocalDate startDate = endDate.minusDays(7);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
        try {
            FileReader fileReader = new FileReader(EXPORT_HISTORY_FILE);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            String line;

            while ((line = bufferedReader.readLine()) != null) {
                String[] data = line.split(" - ");
                String dateString = data[0].trim();
                LocalDateTime exportDateTime = LocalDateTime.parse(dateString, formatter).toLocalDate().atStartOfDay();

                if (exportDateTime.toLocalDate().isAfter(startDate) && exportDateTime.toLocalDate().isBefore(endDate.plusDays(1))) {
                    System.out.println(line);
                }
            }

            bufferedReader.close();
            fileReader.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void importReportByMonth(LocalDate endDate) {
        LocalDate startDate = endDate.minusDays(30);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
        try {
            FileReader fileReader = new FileReader(IMPORT_HISTORY_FILE);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            String line;

            while ((line = bufferedReader.readLine()) != null) {
                String[] data = line.split(" - ");
                String dateString = data[0].trim();
                LocalDateTime importDateTime = LocalDateTime.parse(dateString, formatter).toLocalDate().atStartOfDay();

                if (importDateTime.toLocalDate().isAfter(startDate) && importDateTime.toLocalDate().isBefore(endDate.plusDays(1))) {
                    System.out.println(line);
                }
            }

            bufferedReader.close();
            fileReader.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void exportReportByMonth(LocalDate endDate) {
        LocalDate startDate = endDate.minusDays(30);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
        try {
            FileReader fileReader = new FileReader(IMPORT_HISTORY_FILE);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            String line;

            while ((line = bufferedReader.readLine()) != null) {
                String[] data = line.split(" - ");
                String dateString = data[0].trim();
                LocalDateTime exportDateTime = LocalDateTime.parse(dateString, formatter).toLocalDate().atStartOfDay();

                if (exportDateTime.toLocalDate().isAfter(startDate) && exportDateTime.toLocalDate().isBefore(endDate.plusDays(1))) {
                    System.out.println(line);
                }
            }

            bufferedReader.close();
            fileReader.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void importReportByYear(LocalDate endDate) {
        LocalDate startDate = endDate.minusDays(365);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
        try {
            FileReader fileReader = new FileReader(IMPORT_HISTORY_FILE);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            String line;

            while ((line = bufferedReader.readLine()) != null) {
                String[] data = line.split(" - ");
                String dateString = data[0].trim();
                LocalDateTime importDateTime = LocalDateTime.parse(dateString, formatter).toLocalDate().atStartOfDay();

                if (importDateTime.toLocalDate().isAfter(startDate) && importDateTime.toLocalDate().isBefore(endDate.plusDays(1))) {
                    System.out.println(line);
                }
            }

            bufferedReader.close();
            fileReader.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void exportReportByYear(LocalDate endDate) {
        LocalDate startDate = endDate.minusDays(365);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
        try {
            FileReader fileReader = new FileReader(EXPORT_HISTORY_FILE);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            String line;

            while ((line = bufferedReader.readLine()) != null) {
                String[] data = line.split(" - ");
                String dateString = data[0].trim();
                LocalDateTime exportDateTime = LocalDateTime.parse(dateString, formatter).toLocalDate().atStartOfDay();

                if (exportDateTime.toLocalDate().isAfter(startDate) && exportDateTime.toLocalDate().isBefore(endDate.plusDays(1))) {
                    System.out.println(line);
                }
            }

            bufferedReader.close();
            fileReader.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
