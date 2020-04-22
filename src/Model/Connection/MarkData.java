package Model.Connection;

import Model.Students.MarkStudent;
import Model.Students.PresentStudent;

import java.awt.image.AreaAveragingScaleFilter;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Vector;

public class MarkData {

    private MarkStudent markStudent;
    private Conect conect;
    private Statement statement;
    private ResultSet resultSet;


    private ArrayList<MarkStudent> studentList;

    public MarkData(Conect conect) {

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
        MarkStudent.getMarkColumn().clear();

        try {
            statement = conect.getConnection().createStatement();
            resultSet = statement.executeQuery("SELECT * FROM oceny");
            int columns = resultSet.getMetaData().getColumnCount();
            while (resultSet.next()) {

                id = resultSet.getString("ID");
                name = resultSet.getString("Name");
                surname = resultSet.getString("Surrname");
                markStudent = new MarkStudent(id, name, surname);

                for (int i = 4; i <= columns; i++) {
                    markStudent.getMarks().add(resultSet.getString(i));
                    if (column == true) {
                        MarkStudent.getMarkColumn().add(resultSet.getMetaData().getColumnName(i));
                    }
                }
                column = false;
                studentList.add(markStudent);
                //studentList.get(0).getPresent().size();
            }

        } catch (Exception e) {
            System.out.println("Coś nie pykło :(");
            return false;
        }
        return true;
    }


    protected boolean writeData(Vector<String> columnNames, Vector<Vector<String>> data) {

        String query;
        ArrayList<String> name = new ArrayList<>();
        ;

        try {
            int columnSizeTable = columnNames.size();

            statement = conect.getConnection().createStatement();
            resultSet = statement.executeQuery("SELECT count(*) FROM information_schema.columns WHERE table_name = \"oceny\"");
            resultSet.next();

            int columnSizeDataBase = resultSet.getInt("count(*)");

            query = "SHOW COLUMNS FROM oceny";
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
                    query = "ALTER TABLE `oceny` DROP `" + name.get(j) + "`";
                    System.out.println(query);
                    statement.executeUpdate(query);
                }
            }

            if (columnSizeTable > columnSizeDataBase) {

                for (int i = columnSizeDataBase; i < columnSizeTable; i++) {
                    query = "ALTER TABLE oceny ADD `" + columnNames.get(i) + "` text";
                    System.out.println(query);
                    statement.executeUpdate(query);
                }
            }
            //write data
            for (int i = 3; i < columnNames.size(); i++)
                for (int j = 0; j < data.size(); j++) {

                    query = "UPDATE oceny SET `" + columnNames.get(i) + "` = \"" + data.get(j).get(i) + "\" WHERE Id = " + j;
                    int n2 = statement.executeUpdate(query);
                    System.out.println(n2);
                }
        } catch (Exception e) {
            System.out.println(e);
            return false;

        }
        return true;
    }

    public ArrayList<MarkStudent> getStudentList() {
        return studentList;
    }
}

