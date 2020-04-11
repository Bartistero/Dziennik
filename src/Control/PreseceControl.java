package Control;

import GUI.Gui;
import GUI.NoSave;
import GUI.Presence;
import com.sun.imageio.plugins.jpeg.JPEGImageReaderSpi;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import static java.awt.BorderLayout.CENTER;

public class PreseceControl {

    Presence presence;
    private Gui frame;
    //PresentTableControl table = new PresentTableControl();

    public PreseceControl(Presence presence,Gui frame) {
        this.presence = presence;
        this.frame = frame;

        presence.addListenner(new listener());
    }

    class listener implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            Object source = e.getSource();
            if (source == presence.getCancel()) {
                NoSave save = new NoSave(presence.getPresence());
                int x = save.getChoice();
                if(x == 0){
                    if (frame.getBorder().getLayoutComponent(CENTER) != null)
                        frame.remove(frame.getBorder().getLayoutComponent(CENTER));
                    JPanel empty = new JPanel();
                    frame.add(empty, CENTER);
                    frame.revalidate();
                }else if(x == 1){
                    System.out.println("Tu będzie zapis");
                }
            }else if(source == presence.getSave()){
                System.out.println("Tutaj bd zapis xD");
            }else if(source  == presence.getPresent()){

            }else if(source == presence.getAbsent()){

            }else if(source == presence.getLate()){

            }else if(source  == presence.getNewLesson()){

            }
        }

    }
}
