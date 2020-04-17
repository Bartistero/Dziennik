package GUI;

import javax.swing.*;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.Date;

public class NewLesson {

    private String name;

    public NewLesson(JPanel frame) {

        SimpleDateFormat formatter = new SimpleDateFormat("dd.MM.yyyy");
        Date date = new Date();

        String text = "Data: ";
        name = (String) JOptionPane.showInputDialog(frame, text, "Dodawanie nowej Lekcji", JOptionPane.INFORMATION_MESSAGE,
                null, null, formatter.format(date));
    }

    public String getName() {
        return name;
    }
}
