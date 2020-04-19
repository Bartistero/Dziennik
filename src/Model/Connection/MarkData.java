package Model.Connection;

import Model.Students.MarkStudent;
import Model.Students.PresentStudent;

import java.awt.image.AreaAveragingScaleFilter;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

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

    public ArrayList<MarkStudent> getStudentList() {
        return studentList;
    }
}

