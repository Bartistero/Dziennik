package Control;

import GUI.Configuration;
import GUI.Gui;
import GUI.Marks;
import GUI.Presence;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import static java.awt.BorderLayout.CENTER;

public class Control {
    private Gui frame;
    private JPanel  center;

    public Control(Gui frame) {
        this.frame = frame;
        this.frame.addListenner(new listener());
    }

    class listener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            Object source = e.getSource();

            if (source == frame.getPresence()) {
                if (frame.getBorder().getLayoutComponent(CENTER) != null)
                    frame.remove(frame.getBorder().getLayoutComponent(CENTER));

                Presence pr = new Presence();
                center = pr.showPresence();
                frame.add(center);
                frame.getBorder().addLayoutComponent(center, CENTER);
                frame.revalidate();
           }else if(source == frame.getMarks()){
                if(frame.getBorder().getLayoutComponent(CENTER)!=null)
                    frame.remove(frame.getBorder().getLayoutComponent(CENTER));

                Marks pr = new Marks();
                center  = pr.showMarks();
                frame.add(center);
                frame.getBorder().addLayoutComponent(center,CENTER);
                frame.revalidate();
            }else if(source == frame.getNewPupil()){
                if(frame.getBorder().getLayoutComponent(CENTER)!=null)
                    frame.remove(frame.getBorder().getLayoutComponent(CENTER));

                Configuration pr = new Configuration();
                center = pr.showConfiguration();
                frame.add(center);
                frame.getBorder().addLayoutComponent(center,CENTER);
                frame.revalidate();
                System.out.println("Konfiguracja działam");
            }
        }
    }
}

