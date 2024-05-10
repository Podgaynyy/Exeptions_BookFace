package org.example.BookFace;

import java.io.*;
import java.time.format.DateTimeFormatter;

public class BookFace {

    public static void logHuman(Human human) {
        String filename = human.getFamiliname() + ".txt"; // Имя файла соответствует фамилии
        File file = new File(filename);

        // Формируем строку данных
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        String dateString = human.getDob().format(formatter); // Форматируем дату в строку
        String data = String.format("%s %s %s %s %s %s",
                human.getFamiliname(),
                human.getName(),
                human.getSecondname(),
                dateString,
                human.getTelnumber(),
                human.getGender().toString());

        // Проверяем, существует ли уже такая запись
        if (!containsEntry(file, data)) {
            try (FileWriter fw = new FileWriter(file, true); // Добавляем возможность дописывания в файл
                 BufferedWriter bw = new BufferedWriter(fw);
                 PrintWriter out = new PrintWriter(bw)) {

                // Записываем строку в файл
                out.println(data);
            } catch (IOException e) {
                System.err.println("Ошибка при записи в файл: " + e.getMessage());
            }
        }
    }

    private static boolean containsEntry(File file, String entry) {
        if (file.exists()) {
            try (BufferedReader br = new BufferedReader(new FileReader(file))) {
                String line;
                while ((line = br.readLine()) != null) {
                    if (line.equals(entry)) {
                        return true; // Данные уже записаны
                    }
                }
            } catch (IOException e) {
                System.err.println("Ошибка при чтении файла: " + e.getMessage());
            }
        }
        return false;
    }
}