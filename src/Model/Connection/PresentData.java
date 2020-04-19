package Model.Connection;

import Model.Students.PresentStudent;
import Model.Students.Student;
import com.sun.scenario.effect.impl.sw.java.JSWBlend_SRC_OUTPeer;

import java.sql.DatabaseMetaData;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collections;
import java.util.ConcurrentModificationException;
import java.util.Vector;

public class PresentData {


    private PresentStudent st;
    private Conect conect;
    private Statement statement;
    private ResultSet resultSet;

    private ArrayList<PresentStudent> studentList;

    public PresentData(Conect conect) {

        this.conect = conect;
        statement = conect.getStatement();
        resultSet = conect.getResultSet();

    }

    protected boolean readData() {
        String id;
        boolean column = true;
        String name;
        String surname;
        studentList = new ArrayList<>();
        PresentStudent.getLesson().clear();

        try {
            statement = conect.getConnection().createStatement();
            resultSet = statement.executeQuery("SELECT * FROM obecnosc");
            int columns = resultSet.getMetaData().getColumnCount();
            while (resultSet.next()) {

                id = resultSet.getString("ID");
                name = resultSet.getString("Name");
                surname = resultSet.getString("Surrname");
                st = new PresentStudent(id, name, surname);

                for (int i = 4; i <= columns; i++) {
                    st.getPresent().add(resultSet.getString(i));
                    if (column == true) {
                        PresentStudent.getLesson().add(resultSet.getMetaData().getColumnName(i));
                    }
                }
                column = false;
                studentList.add(st);
                studentList.get(0).getPresent().size();
            }
        } catch (Exception e) {
            return false;
        }
        return true;
    }

    protected boolean writeData(Vector<String> columnNames, Vector<Vector<String>> data) {

        String query;
        ArrayList<String> name = new ArrayList<>();;

        try{
            int columnSizeTable = columnNames.size();


            statement = conect.getConnection().createStatement();
            resultSet = statement.executeQuery("SELECT count(*) FROM information_schema.columns WHERE table_name = \"obecnosc\"");
            resultSet.next();

            int columnSizeDataBase = resultSet.getInt("count(*)");

                query = "SHOW COLUMNS FROM obecnosc";
                resultSet = statement.executeQuery(query);
                while (resultSet.next()) {
                    name.add(resultSet.getString(1));
                }

                boolean delete = false;
                for (int i = 3; i < columnSizeDataBase; i++) {
                    delete = false;
                    int j = 3;
                    for (; j < columnSizeTable; j++) {
                        if (columnNames.get(j).equals(name.get(i)))
                            delete = true;
                    }
                    if (!delete) {
                        System.out.println("Usuwam: " + name.get(j));
                        query = "ALTER TABLE `obecnosc` DROP `" + name.get(j) + "`";
                        System.out.println(query);
                       int n =  statement.executeUpdate(query);
                        System.out.println(n);
                    }
                }

            if (columnSizeTable > columnSizeDataBase) {

                for (int i = columnSizeDataBase; i < columnSizeTable; i++) {
                    query = "ALTER TABLE obecnosc ADD `" + columnNames.get(i) + "` text";
                    System.out.println(query);
                    statement.executeUpdate(query);
                }
            }
            //write data
            for (int i = 3; i < columnNames.size(); i++)
                for (int j = 0; j < data.size(); j++) {
                    //UPDATE obecnosc SET `18.04.2020` = "123456789" WHERE Id = "0"
                    query = "UPDATE obecnosc SET `" + columnNames.get(i) + "` = \"" + data.get(j).get(i) + "\" WHERE Id = " + j;
                    int n2 = statement.executeUpdate(query);
                    System.out.println(n2);
                   // System.out.print(query);
                   // System.out.println(" I = " + i + " J = " + j);
                }
        } catch (Exception e) {
            System.out.println(e);
            return false;

        }
            return true;
    }

    public ArrayList<PresentStudent> getStudentList() {

        return studentList;
    }
}
