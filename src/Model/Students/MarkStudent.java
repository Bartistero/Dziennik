package Model.Students;

import java.awt.image.AreaAveragingScaleFilter;
import java.util.ArrayList;

public class MarkStudent extends Student {

    private ArrayList<String> marks;
    private static ArrayList<String> markColumn = new ArrayList<>();

    public MarkStudent(String id, String name, String surrname) {
        super(id, name, surrname);
        marks = new ArrayList<String>();
    }

    public ArrayList<String> getMarks() {
        return marks;
    }

    public static ArrayList<String> getMarkColumn() {
        return markColumn;
    }
}
