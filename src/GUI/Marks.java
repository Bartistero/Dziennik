package GUI;

import javax.swing.*;
import java.awt.*;

public class Marks extends JFrame {

    private JPanel marks = new JPanel();
    private JPanel handling;
    private JPanel mark;
    private JPanel finish;

    private JButton[] mar;
    private JButton makeNewCol;
    private JButton deleteCol;

    private JPanel tab;
    private JTable table;

    public Marks() {

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

        makeNewCol = new JButton("Nowa kolumna");
        gc.gridx = 0;
        gc.gridy = 1;
        handling.add(makeNewCol, gc);

        JButton deleteCol = new JButton("Usuń  kolumne");
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
        JButton save = new JButton("Zapisz");
        finish.add(save, gc);

        gc.gridx = 1;
        gc.gridy = 0;
        JButton cancel = new JButton("Anuluj");
        finish.add(cancel, gc);

        marks.add(finish, BorderLayout.SOUTH);


        tab = new JPanel();
        tab.setLayout(new GridLayout());

        String[] columnNames2 = {"Lp.", "Imię", "Nazwisko", "Ocena"};
        Object[][] data2 = {{"1.", "Bartosz", "Sterniczuk", "1"}, {"2.", "Jan", "Kowalski", "2"}};

        table = new JTable(data2, columnNames2);

        table.setPreferredScrollableViewportSize(new Dimension(500, 50));
        table.setFillsViewportHeight(true);
        JScrollPane scrollpane = new JScrollPane(table);
        //table.setSize(100,80);

        marks.add(scrollpane, BorderLayout.CENTER);
    }

    public JPanel showMarks() {
        return marks;
    }

}
