package GUI;

import Control.Present.PresenceTable;

import javax.swing.*;
import javax.swing.event.CellEditorListener;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableCellRenderer;
import java.awt.*;
import java.awt.event.ActionListener;

public class Presence extends JFrame {

    private JPanel presence = new JPanel();
    private JPanel handling;
    private JPanel finish;
    private JPanel tab;

    private JButton present;
    private JButton absent;
    private JButton late;
    private JButton newLesson;
    private JButton save;
    private JButton cancel;

    private JTable table;

    private BorderLayout border;

    private PresenceTable model;

    public Presence(PresenceTable model) {
        this.model = model;
        setFrame();
    }

    private void setFrame() {

        border = new BorderLayout();

        presence.setLayout(border);

        handling = new JPanel();
        handling.setBackground(Color.LIGHT_GRAY);
        handling.setLayout(new GridBagLayout());
        GridBagConstraints gc = new GridBagConstraints();
        gc.insets = new Insets(2, 1, 1, 1);

        //Left panel
        gc.fill = GridBagConstraints.HORIZONTAL;
        gc.gridx = 0;
        gc.gridy = 0;

        present = new JButton("Obecność");
        handling.add(present, gc);

        gc.gridx = 0;
        gc.gridy = 1;

        absent = new JButton("Nieobecność");
        handling.add(absent, gc);

        gc.gridx = 0;
        gc.gridy = 2;
        late = new JButton("Spóźnienie");
        handling.add(late, gc);

        gc.gridx = 0;
        gc.gridy = 3;
        newLesson = new JButton("Nowa Lekcja");
        handling.add(newLesson,gc);

        presence.add(handling, BorderLayout.EAST);


        //fotter
        finish = new JPanel();
        finish.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        finish.setLayout(new GridBagLayout());
        gc.insets = new Insets(2, 5, 1, 2);


        gc.gridx = 0;
        gc.gridy = 0;
        save = new JButton("Zapisz");
        finish.add(save, gc);

        gc.gridx = 1;
        gc.gridy = 0;
        cancel = new JButton("Anuluj");
        finish.add(cancel, gc);

        presence.add(finish, BorderLayout.SOUTH);


        //Center Panel
        tab = new JPanel();
        tab.setLayout(new BorderLayout());


        table = new JTable(model);
        //set size frist column
        setTableView();
        tab.add(table.getTableHeader(),BorderLayout.PAGE_START);
        JScrollPane scrollPane = new JScrollPane(table);
        tab.add(scrollPane,BorderLayout.CENTER);

        presence.add(tab,BorderLayout.CENTER);

    }

    public void addListenner(ActionListener listener){

        present.addActionListener(listener);
        absent.addActionListener(listener);
        late.addActionListener(listener);
        newLesson.addActionListener(listener);
        save.addActionListener(listener);
        cancel.addActionListener(listener);
    }

    public JPanel showPresence() {

        return presence;
    }

    public JButton getPresent() {

        return present;
    }

    public JButton getAbsent() {

        return absent;
    }

    public JButton getLate() {

        return late;
    }

    public JButton getSave() {
        return save;
    }

    public JButton getCancel() {

        return cancel;
    }

    public JPanel getPresence() {

        return presence;
    }

    public BorderLayout getBorder() {

        return border;
    }

    public JButton getNewLesson() {

        return newLesson;
    }


    public JTable getTable(){

        return table;
    }
    public void setTableView(){
        table.getColumnModel().getColumn(0).setMaxWidth(50);
        table.getColumnModel().getColumn(0).setMinWidth(200);
        table.getColumnModel().getColumn(1).setMinWidth(200);
        table.getColumnModel().getColumn(2).setMinWidth(200);

        table.setColumnSelectionAllowed(false);
        table.setRowSelectionAllowed(false);
        table.setCellSelectionEnabled(true);
        table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

        table.getSelectionModel().addListSelectionListener(new RowColumnListSelectionListener(table));



        DefaultTableCellRenderer renderer = new DefaultTableCellRenderer();
        renderer.setHorizontalAlignment(JLabel.CENTER);
        for(int i=0;i<table.getColumnCount();i++)
            table.getColumnModel().getColumn(i).setCellRenderer(renderer);

        table.setRowHeight(25);
        table.setFont(new Font("Calibri",Font.PLAIN,20));


        //tab.add(scrollPane, BorderLayout.EAST);
    }
    public static class RowColumnListSelectionListener implements ListSelectionListener {
       JTable table;
        public RowColumnListSelectionListener(JTable table){
            this.table = table;
        }
        @Override
        public void valueChanged(ListSelectionEvent e) {
            System.out.println("Zaznaczono: " + table.getSelectedRow()+ " " + table.getSelectedColumn());
            table.revalidate();
        }
    }
}
