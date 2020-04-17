package Model.Connection;

import Model.Connection.Fasade;
import Model.Connection.PresentData;
import Model.Students.PresentStudent;
import Model.Students.Student;

import javax.jws.WebParam;
import java.util.ArrayList;

public class ModelFasade implements Fasade {

    private PresentData pd;

    public ModelFasade(){
        pd = new PresentData();
    }
    @Override
    public ArrayList<PresentStudent>  getPresentData() {
        pd.readData();
        return pd.getStudentList();
    }

    @Override
    public void getMarksData() {

    }

    @Override
    public void getConfigData() {

    }

    @Override
    public void writePresentData() {

    }

    @Override
    public void writeMarksData() {

    }

    @Override
    public void writeConfigData() {

    }
}
