package Model.Table;

import Model.Students.MarkStudent;
import Model.Students.PresentStudent;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.AbstractTableModel;
import java.util.ArrayList;
import java.util.Vector;

public class MarkTable extends AbstractTableModel implements Table {

    private static MarkTable instance = null;
    private ArrayList<MarkStudent> sourceData;
    private Vector<String> columnNames;
    private Vector<Vector<String>> data;
    private boolean edited = false;

    //singleton
    public static MarkTable getInstance(ArrayList<MarkStudent> sourceData) {
        if (instance == null) {
            instance = new MarkTable(sourceData);
        }
        return instance;
    }

    public void delete() {
        instance = null;
    }

    public MarkTable(ArrayList<MarkStudent> sourceData) {

        this.sourceData = sourceData;
        columnNames = new Vector<>();
        data = new Vector<>();
        setColumnNames();
        setData();
    }

    private void setColumnNames() {
        int size = 0;
        if (sourceData.size() > 0) {
            size = sourceData.get(0).getMarkColumn().size();
            columnNames.add("Lp.");
            columnNames.add("Imie");
            columnNames.add("nazwisko");

            for (int i = 3; i < size + 3; i++)
                columnNames.add(sourceData.get(0).getMarkColumn().get(i - 3));
        }
    }

    private void setData() {

        if (sourceData.size() > 0) {
            int sizeY = sourceData.size();
            int sizeX = sourceData.get(0).getMarks().size() + 3;


            for (int i = 0; i < sizeY; i++) {
                Vector<String> rowVetor = new Vector<String>();
                rowVetor.add(sourceData.get(i).getid());
                rowVetor.add(sourceData.get(i).getName());
                rowVetor.add(sourceData.get(i).getSurname());
                data.add(rowVetor);
            }

            for (int i = 0; i < sizeY; i++) {
                for (int j = 0; j < sizeX - 3; j++) {

                    data.get(i).add(sourceData.get(i).getMarks().get(j));
                }
            }
        }
    }

    @Override
    public void changeData(PresenceTable.TableListener listener, String s) {
        int column = listener.getColumn();
        int row = listener.getRow();

        if (column > 2) {
            data.get(row).set(column, s);
            this.fireTableDataChanged();
            listener.setSelect(column, row + 1);
            edited = true;
        }

    }

    @Override
    public boolean addNewColumn(String name) {

        boolean add = true;
        for (int i = 0; i < columnNames.size() && add == true; i++) {
            if (columnNames.get(i).equals(name) || name.isEmpty())
                add = false;
        }
        if (add) {

            columnNames.add(name);
            for (int i = 0; i < data.size(); i++) {
                data.get(i).add("1");
            }
            this.fireTableStructureChanged();
            edited = true;
            return true;
        } else {

            return false;
        }
    }

    @Override
    public boolean deleteColumn(TableListener listener) {

        int column = listener.getColumn();
        if (column > 2) {
            columnNames.remove(column);
            for (int i = 0; i < data.size(); i++)
                data.get(i).remove(column);

            this.fireTableStructureChanged();
            listener.setSelect(0, 0);
            edited = true;

            return true;
        } else return false;
    }

    @Override
    public String getSelectedColumn(PresenceTable.TableListener listener) {

        return columnNames.get(listener.getColumn());
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

    public Vector<Vector<String>> getData() {
        return data;
    }

    public Vector<String> getColumnNames() {
        return columnNames;
    }
}
