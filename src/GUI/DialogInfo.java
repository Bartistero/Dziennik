package GUI;

import javax.swing.*;
import java.io.IOException;

public class DialogInfo extends IOException {

    int choice = 0;
    JPanel frame;
    String text;
    String title;

    public DialogInfo(JPanel frame, String text, String title) {
        this.text = text;
        this.title = title;
        this.frame = frame;
        show();
    }

    public void show() {
        choice = JOptionPane.showOptionDialog(frame, text, title, 2, JOptionPane.INFORMATION_MESSAGE,
                null, null, null);
    }

    public int getChoice() {
        return choice;
    }

    public void setText(String text) {
        this.text = text;
    }
}
