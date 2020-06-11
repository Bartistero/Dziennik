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
            resultSet = statement.executeQuery("SELECT * FROM present");
            int columns = resultSet.getMetaData().getColumnCount();
            while (resultSet.next()) {

                id = resultSet.getString(1);
                name = resultSet.getString(2);
                surname = resultSet.getString(3);
                st = new PresentStudent(id, name, surname);

                for (int i = 4; i <= columns; i++) {
                    st.getPresent().add(resultSet.getString(i));
                    if (column == true) {
                        PresentStudent.getLesson().add(resultSet.getMetaData().getColumnName(i));
                    }
                }
                column = false;
                studentList.add(st);

            }
            return false;
        } catch (Exception e) {
            return true; //return the problem with read data
        }
    }

    protected boolean writeData(Vector<String> columnNames, Vector<Vector<String>> data) {

        String query;
        ArrayList<String> name = new ArrayList<>();
        ;

        try {
            int columnSizeTable = columnNames.size();


            statement = conect.getConnection().createStatement();
            resultSet = statement.executeQuery("SELECT count(*) FROM information_schema.columns WHERE table_name = \"present\"");
            resultSet.next();

            int columnSizeDataBase = resultSet.getInt("count(*)");

            query = "SHOW COLUMNS FROM present";
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
                    query = "ALTER TABLE `present` DROP `" + name.get(j) + "`";
                    statement.executeUpdate(query);
                }
            }

            if (columnSizeTable > columnSizeDataBase) {

                for (int i = columnSizeDataBase; i < columnSizeTable; i++) {
                    query = "ALTER TABLE present ADD `" + columnNames.get(i) + "` text";
                    System.out.println(query);
                    statement.executeUpdate(query);
                }
            }
            //write data
            for (int i = 3; i < columnNames.size(); i++)
                for (int j = 0; j < data.size(); j++) {
                    query = "UPDATE present SET `" + columnNames.get(i) + "` = \"" + data.get(j).get(i) + "\" WHERE Id = " + j;
                    int n2 = statement.executeUpdate(query);
                }
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return false;

        }
        return true;
    }

    public ArrayList<PresentStudent> getStudentList() {

        return studentList;
    }
}
