package GUI;

import javax.swing.*;
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



    public Presence() {
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


        JTable table = new JTable();

        tab.add(table.getTableHeader(),BorderLayout.PAGE_START);
        tab.add(table,BorderLayout.CENTER);
        presence.add(tab,BorderLayout.CENTER);

    }

    public void addListenner(ActionListener listener){

        present.addActionListener(listener);
        absent.addActionListener(listener);
        late.addActionListener(listener);
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
}
