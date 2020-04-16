package Model.Students;

import java.util.ArrayList;

public abstract class Student {

    private int number;
    private String name;
    private String surname;
    private static ArrayList<String> lesson;

    public Student(int number, String name, String surname) {
        this.number = number;
        this.name = name;
        this.surname = surname;
    }

    public int getNumber() {
        return number;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public static ArrayList<String> getLesson() {
        return lesson;
    }
}
