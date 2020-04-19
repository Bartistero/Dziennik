package Model.Students;

import java.util.ArrayList;

public abstract class Student {

    String id;
    String name;
    String surname;

    public Student(String number, String name, String surname) {
        this.id = number;
        this.name = name;
        this.surname = surname;
    }

    public String getid() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }


}
