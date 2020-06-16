package Model.Connection;

import GUI.Configuration;
import Model.Students.ConfigurationStudent;
import Model.Students.MarkStudent;
import com.sun.scenario.effect.impl.sw.sse.SSEBlend_SRC_OUTPeer;

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
    protected  boolean writeData(ArrayList<ConfigurationStudent> lista){
        int j = 0;
         int records = 0;

        try {
            boolean delete = true;
            statement = conect.getConnection().createStatement();
            resultSet = statement.executeQuery("SELECT * FROM personaldata");
            Statement statement2 = conect.getConnection().createStatement();
            while (resultSet.next()) {
                j++;
                delete = true;
                String index = resultSet.getString(1);

                for (int i = 0; i < lista.size(); i++) {
                    if (index.equals(lista.get(i).getid())) {
                        delete = false;
                        break;
                    }
                }
                if (delete) {
                    delete = true;
                    statement2.executeUpdate("DELETE from personaldata WHERE ID =\"" + index + "\"");
                    statement2.executeUpdate("DELETE from marks WHERE ID =\"" + index + "\"");
                    statement2.executeUpdate("DELETE from present WHERE ID =\"" + index + "\"");
                    System.out.println("Usuam: " + index);
                }

            }

        }catch(Exception e) {
            System.out.println("Przy usuwaniu: " + e.getMessage());
            return false;
        }
        //update data
       try {
           resultSet = statement.executeQuery("SELECT * FROM personaldata");
            resultSet.last();
           records = resultSet.getRow();
                for(int i=0;i<records;i++){
                    String query = " UPDATE `personaldata`, `marks`, `present`  SET personaldata.Name =\""  + lista.get(i).getName() +  "\", personaldata.Surrname=\""
                            +lista.get(i).getSurname() + "\", personaldata.Addres=\"" +
                            lista.get(i).getAddress() + "\", personaldata.PESEL=\"" + lista.get(i).getPESEL() + "\",personaldata.Tel=\"" +
                            lista.get(i).getTel() + "\",personaldata.eMail=\"" + lista.get(i).geteMail() +  "\",marks.Name = \""  + lista.get(i).getName() + "\",marks.Surrname =\"" +
                            lista.get(i).getSurname() + "\",present.Name = \""  + lista.get(i).getName() + "\",present.Surrname =\"" +
                            lista.get(i).getSurname() + "\"WHERE personaldata.ID =\"" +lista.get(i).getid() + "\" AND present.Id =\"" + lista.get(i).getid() + "\" AND marks.ID = \""
                            + lista.get(i).getid() + "\" ";
                    //System.out.println(query);
                    statement.executeUpdate(query);
                }


        }catch(Exception e) {
            System.out.println("Przy update " + e.getMessage());
            return false;
        }


        //save new students in DB
        try{
            for(;j<lista.size();j++) {
                System.out.println("wykonałem zapis");
                String query = " INSERT INTO `personaldata`(`ID`, `Name`, `Surrname`, `Addres`, `PESEL`, `Tel`, `eMail`) VALUES (\""
                        + lista.get(j).getid() + "\",\"" + lista.get(j).getName() + "\",\"" + lista.get(j).getSurname() + "\",\"" +
                        lista.get(j).getAddress() + "\",\"" + lista.get(j).getPESEL() + "\",\"" +
                        lista.get(j).getTel() + "\",\"" + lista.get(j).geteMail() + "\")";
                System.out.println(query);
                statement.executeUpdate(query);
            }
        }catch(Exception e){
            System.out.println("przy dodaniu nowego: " + e.getMessage());
            return false;
        }

        //the error didn't show
        return true;
    }
    public ArrayList<ConfigurationStudent> getStudentList() {
        return studentList;
    }
}
