package Model.Connection;

import Control.Control;
import GUI.Gui;
import Model.Connection.Fasade;
import Model.Connection.PresentData;
import Model.Students.PresentStudent;
import Model.Students.Student;

import javax.jws.WebParam;
import java.util.ArrayList;
import java.util.Vector;

public class ModelFasade implements Fasade {

    private PresentData pd;
    private boolean error = true;
    Conect conect;


    @Override
    public ArrayList<PresentStudent>  getPresentData() {

        conect = new Conect();
        if(conect.newConection()){
            error = false;
            pd = new PresentData(conect);
            pd.readData();
            conect.disconect();
            return pd.getStudentList();

        }else{
            error = true;
            return null;
        }
    }

    @Override
    public void writePresentData(Vector<String> columnNames, Vector<Vector<String>> data) {

    }

    @Override
    public void getMarksData() {

    }

    @Override
    public void getConfigData() {

    }

    @Override
    public void writeMarksData() {

    }

    @Override
    public void writeConfigData() {

    }

    public boolean getError() {
        return error;
    }
}
