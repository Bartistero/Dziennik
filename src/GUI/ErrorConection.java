package GUI;

import javax.swing.*;

public class ErrorConection {
    public ErrorConection(JPanel frame) {
        String text = "Wystąpił błąd podczas łączenia z bazą dancych";
        JOptionPane.showOptionDialog(frame, text, "Ostrzeżenie", 2, JOptionPane.INFORMATION_MESSAGE, null, null, null);
    }
}
