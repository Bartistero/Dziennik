package Model.Students;

import Control.PresTabModel;

import java.util.ArrayList;

public class PresentStudent extends Student {

    private ArrayList<String> present;

   public PresentStudent(int id, String name, String surrname){
       super(id,name,surrname);
       present = new ArrayList<>();
   }

    public ArrayList<String> getPresent() {
        return present;
    }
}
