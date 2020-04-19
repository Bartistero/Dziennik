package GUI;

import Model.Table.MarkTable;
import Model.Table.PresenceTable;

import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import java.awt.*;
import java.awt.event.ActionListener;

public class Mark extends JFrame {

    private JPanel marks = new JPanel();
    private JPanel handling;
    private JPanel mark;
    private JPanel finish;

    private JButton[] mar;
    private JButton NewCol;
    private JButton deleteCol;
    private JButton cancel;
    private JButton save;

    private JPanel tab;
    private JTable table;

    private MarkTable model;

    public Mark(MarkTable model) {
        this.model = model;
        setFrame();
    }

    private void setFrame() {
        marks.setLayout(new BorderLayout());

        handling = new JPanel();
        handling.setBackground(Color.LIGHT_GRAY);
        handling.setLayout(new GridBagLayout());
        GridBagConstraints gc = new GridBagConstraints();
        gc.insets = new Insets(2, 1, 1, 1);

        mark = new JPanel();
        mark.setLayout(new GridLayout(3, 0));


        mar = new JButton[6];
        for (int i = 0; i < 6; i++) {
            mar[i] = new JButton(Integer.toString(i + 1));
            mark.add(mar[i]);
        }
        gc.gridx = 0;
        gc.gridy = 0;
        handling.add(mark, gc);

        NewCol = new JButton("Nowa kolumna");
        gc.gridx = 0;
        gc.gridy = 1;
        handling.add(NewCol, gc);

        deleteCol = new JButton("Usuń  kolumne");
        gc.gridx = 0;
        gc.gridy = 2;
        handling.add(deleteCol, gc);

        marks.add(handling, BorderLayout.EAST);

        finish = new JPanel();
        finish.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        finish.setLayout(new GridBagLayout());
        gc.insets = new Insets(2, 5, 1, 2);
        //gc.fill = GridBagConstraints.REMAINDER;
        //gc.gridheight = 50;

        gc.gridx = 0;
        gc.gridy = 0;
        save = new JButton("Zapisz");
        finish.add(save, gc);

        gc.gridx = 1;
        gc.gridy = 0;
        cancel = new JButton("Anuluj");
        finish.add(cancel, gc);

        marks.add(finish, BorderLayout.SOUTH);

        //Center
        tab = new JPanel();
        tab.setLayout(new BorderLayout());

        table = new JTable(model);
        setTableView();
        tab.add(table.getTableHeader(), BorderLayout.PAGE_START);
        JScrollPane scrollPane = new JScrollPane(table);
        tab.add(scrollPane, BorderLayout.CENTER);

        marks.add(tab, BorderLayout.CENTER);
    }

    public void addListenner(ActionListener listener, MarkTable.TableListener listenerTable) {
        for (int i = 0; i < 6; i++)
            mar[i].addActionListener(listener);
        NewCol.addActionListener(listener);
        deleteCol.addActionListener(listener);
        save.addActionListener(listener);
        cancel.addActionListener(listener);
        table.getSelectionModel().addListSelectionListener(listenerTable);
    }

    public void setTableView() {

        table.getColumnModel().getColumn(0).setMaxWidth(50);
        table.getColumnModel().getColumn(0).setMinWidth(200);
        table.getColumnModel().getColumn(1).setMinWidth(200);
        table.getColumnModel().getColumn(2).setMinWidth(200);

        table.setColumnSelectionAllowed(false);
        table.setRowSelectionAllowed(false);
        table.setCellSelectionEnabled(true);
        table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

        DefaultTableCellRenderer renderer = new DefaultTableCellRenderer();
        renderer.setHorizontalAlignment(JLabel.CENTER);
        for (int i = 0; i < table.getColumnCount(); i++)
            table.getColumnModel().getColumn(i).setCellRenderer(renderer);

        table.setRowHeight(25);
        table.setFont(new Font("Calibri", Font.PLAIN, 20));
    }

    public JPanel showMarks() {
        return marks;
    }

    public JButton[] getMar() {
        return mar;
    }

    public JButton getNewCol() {
        return NewCol;
    }

    public JButton getDeleteCol() {
        return deleteCol;
    }

    public JButton getCancel() {
        return cancel;
    }

    public JButton getSave() {
        return save;
    }

    public JTable getTable() {
        return table;
    }

}
