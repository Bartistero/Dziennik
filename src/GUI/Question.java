package GUI;

import javax.swing.*;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.Date;

public class Question {

    private String name = "";

    public Question(JPanel frame, int x) {


        if (x == 0){

            SimpleDateFormat formatter = new SimpleDateFormat("dd.MM.yyyy");
            Date date = new Date();
            String text = "Data: ";
            name = (String) JOptionPane.showInputDialog(frame, text, "Dodawanie nowej Lekcji", JOptionPane.INFORMATION_MESSAGE,
                    null, null, formatter.format(date));
        }else if(x ==1){

            String text = "Tytuł: ";
            name = (String) JOptionPane.showInputDialog(frame, text, "Dodawanie nowej rubryki", JOptionPane.INFORMATION_MESSAGE,
                    null, null, null);
        }

    }

    public String getName() {
        return name;
    }
}
