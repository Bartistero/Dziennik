package Model.Students;

import java.awt.image.AreaAveragingScaleFilter;
import java.util.ArrayList;

public class MarkStudent extends Student {

    private ArrayList<Integer> marks;

    public MarkStudent(int id, String name, String surrname){
        super(id,name,surrname);
        marks = new ArrayList<Integer>();
    }

    public ArrayList<Integer> getMarks() {
        return marks;
    }
}
