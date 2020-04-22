package Model.Table;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

public interface Table {

    public boolean addNewColumn(String name);

    public void changeData(PresenceTable.TableListener listener, String s);

    public boolean deleteColumn(PresenceTable.TableListener listener);

    public String getSelectedColumn(PresenceTable.TableListener listener);


    public static class TableListener implements ListSelectionListener {

        JTable table;
        int row;
        int column;


        public TableListener(JTable table) {
            this.table = table;
            table.addRowSelectionInterval(0, 0);
        }

        @Override
        public void valueChanged(ListSelectionEvent e) {
            column = table.getSelectedColumn();
            row = table.getSelectedRow();
        }

        public void setSelect(int column, int row) {

            table.changeSelection(row, column, false, true);
        }

        public int getColumn() {

            return column;
        }

        public int getRow() {

            return row;
        }

    }
}
