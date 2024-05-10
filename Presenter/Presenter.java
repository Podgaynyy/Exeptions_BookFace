package org.example.Presenter;

import org.example.BookFace.BookFace;
import org.example.BookFace.Gender;
import org.example.BookFace.Human;
import org.example.View.ConsoleUI;

import java.time.LocalDate;

public class Presenter {
    private ConsoleUI view;
    private BookFace bookFace;


    public Presenter(ConsoleUI view) {
        this.view = view;
        this.bookFace = new BookFace();
    }
    public void saveHuman(String familyName, String name, String secondName,
                          LocalDate dob, String telNumber, Gender g) {
        bookFace.logHuman(new Human(familyName, name, secondName,dob, telNumber, g));
        view.printAnswer("Человек сохранён");
    }
}
