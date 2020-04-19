package Model.Connection;

import Model.Students.MarkStudent;
import Model.Students.PresentStudent;
import Model.Students.Student;

import java.util.ArrayList;
import java.util.Vector;

public interface Fasade {
    public ArrayList<PresentStudent> getPresentData();

    public void writePresentData(Vector<String> columnNames, Vector<Vector<String>> data);

    public ArrayList<MarkStudent> getMarkData();

    public void writeMarksData();

    public void getConfigData();

    public void writeConfigData();

}
