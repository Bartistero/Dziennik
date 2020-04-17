package Model.Connection;

import Model.Students.PresentStudent;
import Model.Students.Student;

import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

public class PresentData{


    private PresentStudent st;
    private Conect conect;
    private Statement statement;
    private ResultSet resultSet;

    private ArrayList<PresentStudent> studentList;

    public PresentData() {
        conect = new Conect();
        statement = conect.getStatement();
        resultSet = conect.getResultSet();
    }

    protected void readData() {
        String id;
        boolean column = true;
        String name;
        String surname;
        studentList = new ArrayList<>();

        if (conect.newConection() == false) {

        } else {
            try {
                statement = conect.getConnection().createStatement();
                resultSet = statement.executeQuery("SELECT * FROM obecnosc");
                int columns = resultSet.getMetaData().getColumnCount();
                while (resultSet.next()) {

                    id = resultSet.getString("ID");
                    name = resultSet.getString("Name");
                    surname = resultSet.getString("Surrname");
                    st = new PresentStudent(id,name,surname);

                    for (int i = 4; i <= columns; i++) {
                        st.getPresent().add(resultSet.getString(i));
                        if(column == true ) {
                            PresentStudent.getLesson().add(resultSet.getMetaData().getColumnName(i));
                        }
                    }
                    column = false;
                    studentList.add(st);
                }

            } catch (Exception e) {
                System.out.println("coś nie pykło :( ");
                System.err.println(e);
            }
        }
        conect.disconect();
    }

    public ArrayList<PresentStudent> getStudentList() {
        return studentList;
    }
}
