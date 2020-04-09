package GUI;

import javafx.scene.layout.BorderRepeat;
import sun.awt.image.GifImageDecoder;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.CompoundBorder;
import javax.swing.plaf.basic.BasicInternalFrameTitlePane;
import javax.swing.table.TableColumn;
import java.awt.*;

public class Presence extends JFrame {

    private JPanel presence = new JPanel();
    private JPanel handling;
    private JPanel finish;
    private JPanel tab;

    private JButton present;
    private JButton absent;
    private JButton late;

    private JTable table;


    public Presence() {
        setFrame();
    }

    private void setFrame() {
        presence.setLayout(new BorderLayout());

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

        presence.add(handling, BorderLayout.EAST);


        //fotter
        finish = new JPanel();
        finish.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        finish.setLayout(new GridBagLayout());
        gc.insets = new Insets(2, 5, 1, 2);


        gc.gridx = 0;
        gc.gridy = 0;
        JButton save = new JButton("Zapisz");
        finish.add(save, gc);

        gc.gridx = 1;
        gc.gridy = 0;
        JButton cancel = new JButton("Anuluj");
        finish.add(cancel, gc);

        presence.add(finish, BorderLayout.SOUTH);


        //Center Panel
        tab = new JPanel();
        tab.setLayout(new GridLayout());

        String[] columnNames2 = {"Lp.", "Imię", "Nazwisko", "Obecność"};
        Object[][] data2 = {{"1.", "Bartosz", "Sterniczuk", "+"}};

        table = new JTable(data2, columnNames2);

        table.setPreferredScrollableViewportSize(new Dimension(500, 50));
        table.setFillsViewportHeight(true);
        JScrollPane scrollpane = new JScrollPane(table);

        presence.add(scrollpane, BorderLayout.CENTER);
    }

    public JPanel showPresence() {
        return presence;
    }

}
