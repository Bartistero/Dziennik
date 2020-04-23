package Model.Students;

import java.util.ArrayList;

public abstract class Student {

    String id;
    String name;
    String surrname;

    public Student(String number, String name, String surname) {
        this.id = number;
        this.name = name;
        this.surrname = surname;
    }

    public Student(){

    }

    public String getid() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surrname;
    }


}
