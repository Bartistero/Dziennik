package Model.Connection;

import GUI.Configuration;
import Model.Students.ConfigurationStudent;
import Model.Students.MarkStudent;
import Model.Students.PresentStudent;

import java.util.ArrayList;
import java.util.Vector;

public class ModelFasade implements Fasade {

    private PresentData presentData;
    private MarkData markData;
    private ConfigurationData configurationData;
    private boolean error = true;
    Conect conect;


    @Override
    public ArrayList<PresentStudent> getPresentData() {

        error = true;
        conect = new Conect();
        if (conect.newConection()) {
            error = false;
            presentData = new PresentData(conect);
            error = presentData.readData();
            conect.disconect();
            return presentData.getStudentList();

        } else {
            error = true;
            return null;
        }
    }

    @Override
    public void writePresentData(Vector<String> columnNames, Vector<Vector<String>> data) {

        error = true;
        conect = new Conect();
        if (conect.newConection()) {
            error = false;
            presentData = new PresentData(conect);
            error = presentData.writeData(columnNames, data);
            System.out.println(error);

        } else {
            error = false;
        }
    }

    @Override
    public ArrayList<MarkStudent> getMarkData() {
        error = true;
        conect = new Conect();
        if (conect.newConection()) {
            error = false;
            markData = new MarkData(conect);
            error = markData.readData();
            conect.disconect();
            return markData.getStudentList();

        } else {
            error = true;
            return null;
        }

    }

    @Override
    public void writeMarksData(Vector<String> columnNames, Vector<Vector<String>> data) {

        error = true;
        conect = new Conect();
        if (conect.newConection()) {
            error = false;
            markData = new MarkData(conect);
            error = markData.writeData(columnNames, data);
            System.out.println(error);

        } else {
            error = false;
        }
    }

    @Override
    public ArrayList<ConfigurationStudent> getConfigData() {
        error = true;
        conect = new Conect();
        if (conect.newConection()) {
            error = false;
            configurationData = new ConfigurationData(conect);
            error = configurationData.readData();
            conect.disconect();
            for(ConfigurationStudent c : configurationData.getStudentList()){

                System.out.println(configurationData.getStudentList().get(0).getid());
            }
            return configurationData.getStudentList();

        } else {
            error = true;
            return null;
        }
    }


    @Override
    public void writeConfigData() {

    }

    public boolean getError() {
        return error;
    }
}
