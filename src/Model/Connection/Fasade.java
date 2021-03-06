package Model.Connection;

import Model.Students.ConfigurationStudent;
import Model.Students.MarkStudent;
import Model.Students.PresentStudent;

import java.awt.image.AreaAveragingScaleFilter;
import java.util.ArrayList;
import java.util.Vector;

public interface Fasade {
    public ArrayList<PresentStudent> getPresentData();

    public void writePresentData(Vector<String> columnNames, Vector<Vector<String>> data);

    public ArrayList<MarkStudent> getMarkData();

    public void writeMarksData(Vector<String> columnNames, Vector<Vector<String>> data);

    public ArrayList<ConfigurationStudent> getConfigData();

    public void writeConfigData(ArrayList<ConfigurationStudent> student);

}
