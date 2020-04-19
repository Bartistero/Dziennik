package Model.Students;

import Model.Connection.PresentData;

import java.awt.image.AreaAveragingScaleFilter;
import java.util.ArrayList;

public class PresentStudent extends Student {

    private ArrayList<String> present;
    static ArrayList<String> lesson = new ArrayList<>();

   public PresentStudent(String id, String name, String surrname){
       super(id,name,surrname);
       present = new ArrayList<>();
   }

    public static ArrayList<String> getLesson() {

       return lesson;
    }

    public ArrayList<String> getPresent() {

       return present;
    }
}
