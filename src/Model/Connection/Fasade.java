package Model.Connection;

import Model.Students.PresentStudent;
import Model.Students.Student;

import java.util.ArrayList;

public interface Fasade {
    public ArrayList<PresentStudent>  getPresentData();
    public void getMarksData();
    public void getConfigData();
    public void writePresentData();
    public void writeMarksData();
    public void writeConfigData();
}
