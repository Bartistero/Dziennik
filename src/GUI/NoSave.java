package GUI;

import jdk.nashorn.internal.scripts.JO;

import javax.swing.*;
import java.awt.event.ActionListener;

public class NoSave extends JFrame {

    private int choice;

    public NoSave(JPanel frame) {
        String text = "Czy na pewno chcesz zamknąć bez zapisywania?";
        String[] options = {"Tak", "Nie", "Anuluj"};
        choice = JOptionPane.showOptionDialog(frame, text, "Ostrzeżenie", 2, JOptionPane.INFORMATION_MESSAGE,
                null, options, options[2]);
    }

    public int getChoice() {
        return choice;
    }
}
