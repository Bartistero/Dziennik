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
        try{
            boolean delete = true;
            statement = conect.getConnection().createStatement();
            resultSet = statement.executeQuery("SELECT * FROM personaldata");
            int j=0;


            while(resultSet.next()){
                j++;
                delete = true;
                String index = resultSet.getString(1);
                for(int i=0;i<lista.size();i++){
                   if(index.equals(lista.get(i).getid())){
                       delete = false;
                       break;
                   }
                }
                if(delete){
                    delete = true;
                    statement.executeUpdate("DELETE from personaldata WHERE ID =\"" + index +"\"");
                    statement.executeUpdate("DELETE from marks WHERE ID =\"" + index +"\"");
                    statement.executeUpdate("DELETE from present WHERE ID =\"" + index +"\"");
                    System.out.println("Usuam: " + index);
                }
            }
          /*  //save new students in DB
            if(j<lista.size()){
                System.out.println("Warunek jest spełniony");
                for(;j<=lista.size();j++){
                    System.out.println("wykonałem zapis");
                    String query =" INSERT INTO `personaldata`(`ID`, `Name`, `Surrname`, `Addres`, `PESEL`, `Tel`, `eMail`) VALUES ("
                            + lista.get(j).getid() +  "," + lista.get(j).getName() + "," +lista.get(j).getSurname() + "," +
                            lista.get(j).getAddress() + ", " + lista.get(j).getPESEL() + "," +
                            lista.get(j).getTel() + "," + lista.get(j).geteMail() + ")" ;
                    System.out.println(query);
                    statement.executeUpdate(query);

                }
            }*/





                //the error didn't show
            return false;
        }catch(Exception e){
            return true;
        }
    }
    public ArrayList<ConfigurationStudent> getStudentList() {
        return studentList;
    }
}
