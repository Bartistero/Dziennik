package Control.Present;

import Control.Control;
import Model.Connection.ModelFasade;
import Model.Connection.PresentData;
import Model.Students.PresentStudent;

import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import java.util.ArrayList;
import java.util.Vector;

public class PresenceTable extends AbstractTableModel {

    //singleton
    private static PresenceTable instance;

    public static PresenceTable getInstance(ModelFasade model) {
        if (instance == null) {
            instance = new PresenceTable(model);
        }
        return instance;
    }

    private Vector<String> columnNames;
    private Vector<Vector<String>> data;
    private ModelFasade model;
    private ArrayList<PresentStudent> sourceData;

    private PresenceTable(ModelFasade model) {
        this.model = model;
        sourceData = model.getPresentData();
        columnNames = new Vector<>();
        data = new Vector<>();
        setColumnNames();
        setData();
    }

    private void setColumnNames() {
        int size = 0;
        if (sourceData.size() > 0) {
            size = sourceData.get(0).getLesson().size();

            //columnNames = new String[3 + size];
            columnNames.add("Lp.");
            columnNames.add("Imie");
            columnNames.add("nazwisko");

            for (int i = 3; i < size + 3; i++) {
                columnNames.add(sourceData.get(i - 3).getLesson().get(i - 3));
            }
        }
    }

    private void setData() {

        if (sourceData.size()  > 0) {
            int sizeY = sourceData.size();
            int sizeX = sourceData.get(0).getPresent().size() + 3;
            //data = new Object[sizeY][sizeX];


            for (int i = 0; i < sizeY; i++) {
                Vector<String> rowVetor = new Vector<String>();
                /*data[i][0] = sourceData.get(i).getid();
                data[i][1] = sourceData.get(i).getName();
                data[i][2] = sourceData.get(i).getSurname();*/
                rowVetor.add(sourceData.get(i).getid());
                rowVetor.add(sourceData.get(i).getName());
                rowVetor.add(sourceData.get(i).getSurname());
                data.add(rowVetor);
            }

            for (int i = 0; i < sizeY; i++) {
                for (int j = 0; j < sizeX - 3; j++) {

                   data.get(i).add(sourceData.get(i).getPresent().get(j));
                }
            }
        }
    }
    public void addNewColumn(String name) {
        columnNames.add(name);
        for (int i = 0; i < data.size(); i++) {
            data.get(i).add("-");
        }
        this.fireTableStructureChanged();
    }
    @Override
    public int getRowCount() {

        return data.size();
    }

    @Override
    public int getColumnCount() {

        return columnNames.size();
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {

        return data.get(rowIndex).get(columnIndex);
    }

    @Override
    public String getColumnName(int column) {

        return columnNames.get(column);
    }


}
