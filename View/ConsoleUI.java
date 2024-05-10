package org.example.View;

import org.example.BookFace.Gender;
import org.example.Presenter.Presenter;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Scanner;

public class ConsoleUI implements View {
    private Scanner scanner;
    private Presenter presenter;
    private boolean work;

    public ConsoleUI() {
        scanner = new Scanner(System.in);
        presenter = new Presenter(this);
        work = true;
    }

    @Override
    public void Start() {
        System.out.println("Приветствую! Выберите действие:");
        while (work) {
            System.out.println("1. Добавить человека");
            System.out.println("2. Закончить программу");

            String line = scanner.nextLine();
            switch (line) {
                case "1":
                    addHuman();
                    break;
                case "2":
                    finish();
                    break;
                default:
                    System.out.println("Введено некорректное значение");
            }
        }
    }

    public void addHuman() {
        try {
            System.out.println("Введите фамилию человека:");
            String familyName = scanner.nextLine();
            System.out.println("Введите имя человека:");
            String name = scanner.nextLine();
            System.out.println("Введите отчество:");
            String secondName = scanner.nextLine();
            System.out.println("Введите дату рождения в формате yyyy-mm-dd:");
            String dobInput = scanner.nextLine();
            LocalDate dob = parseDate(dobInput); // Обработка даты
            System.out.println("Введите телефонный номер:");
            String telNumber = scanner.nextLine();
            validatePhoneNumber(telNumber); // Валидация номера телефона
            System.out.println("Введите пол в формате \"m\" (мужской) или \"f\" (женский):");
            String genderInput = scanner.nextLine().toLowerCase();
            Gender gender = null;

            if (genderInput.equals("m")) {
                gender = Gender.Male;
            } else if (genderInput.equals("f")) {
                gender = Gender.Female;
            } else {
                System.out.println("Введено некорректное значение для пола.");
                return; // Прекращаем выполнение, если пол введен неверно
            }

            presenter.saveHuman(familyName, name, secondName, dob, telNumber, gender);
        } catch (DateTimeParseException e) {
            System.out.println("Ошибка формата даты. Введите дату в формате yyyy-mm-dd.");
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }

    private LocalDate parseDate(String dateStr) throws DateTimeParseException {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        return LocalDate.parse(dateStr, formatter);
    }

    private void validatePhoneNumber(String number) throws IllegalArgumentException {
        if (!number.matches("\\d+(-\\d+)*")) { // Проверка на цифры и дефисы
            throw new IllegalArgumentException("Номер телефона должен содержать только цифры и дефисы.");
        }
    }

    public void printAnswer(String text){
        System.out.println(text);
    }

    public void finish(){
        System.out.println("До новых встреч!");
        work = false;
    }
}
