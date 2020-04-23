package Model.Connection;

import GUI.Configuration;
import Model.Students.ConfigurationStudent;
import Model.Students.MarkStudent;

import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;


public class ConfigurationData {

    private ConfigurationStudent configurationStudent;
    private Conect conect;
    private Statement statement;
    private ResultSet resultSet;

    private ArrayList<ConfigurationStudent> studentList;

    public ConfigurationData(Conect conect) {

        this.conect = conect;
        statement = conect.getStatement();
        resultSet = conect.getResultSet();
    }

    protected boolean readData() {

        studentList = new ArrayList<>();
        String name;
        String surrname;
        String address;
        String PESEL;
        String id;
        String tel;
        String eMail;

        try {
            statement = conect.getConnection().createStatement();
            resultSet = statement.executeQuery("SELECT * FROM personaldata");
            while (resultSet.next()) {

                configurationStudent = new ConfigurationStudent.Builder()
                        .id(resultSet.getString(1))
                        .name(resultSet.getString(2))
                        .surrname(resultSet.getString(3))
                        .address(resultSet.getString(4))
                        .PESEL(resultSet.getString(5))
                        .tel(resultSet.getString(6))
                        .eMail(resultSet.getString(7))
                        .build();
                studentList.add(configurationStudent);

            }
            return false; // the error didn't show
        } catch (Exception e) {

            return true;
        }
    }

    public ArrayList<ConfigurationStudent> getStudentList() {
        return studentList;
    }
}
