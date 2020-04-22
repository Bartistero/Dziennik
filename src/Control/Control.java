package Control;

import GUI.*;
import Model.Students.MarkStudent;
import Model.Students.PresentStudent;
import Model.Table.MarkTable;
import Model.Table.PresenceTable;
//import PresenceControl;
import Model.Connection.ModelFasade;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import static java.awt.BorderLayout.CENTER;

public class Control<Static> {

    private Gui frame;
    private JPanel center;
    private ModelFasade model;

    private PresenceControl presenceControl;
    private PresenceTable presenceTable;
    private Presence pr;

    private MarkControl markControl;
    private MarkTable markTable;
    private Mark mark;


    public Control(Gui frame, ModelFasade model) {
        this.frame = frame;
        this.model = model;
        frame.addListenner(new listener());
    }

    class listener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            Object source = e.getSource();

            if (source == frame.getPresence()) {
                if (frame.getBorder().getLayoutComponent(CENTER) != null)
                    frame.remove(frame.getBorder().getLayoutComponent(CENTER));

                ArrayList<PresentStudent> sourceData;
                sourceData = model.getPresentData();
                if (!model.getError()) {
                    presenceTable = PresenceTable.getInstance(sourceData);
                    pr = new Presence(presenceTable);
                    presenceControl = new PresenceControl(frame, model, pr, presenceTable);
                    center = pr.getPresence();
                    frame.add(center);
                    frame.getBorder().addLayoutComponent(center, CENTER);
                    frame.revalidate();
                } else {
                    error();
                    System.out.println("nie działąm");
                }
            } else if (source == frame.getMarks()) {
                if (frame.getBorder().getLayoutComponent(CENTER) != null)
                    frame.remove(frame.getBorder().getLayoutComponent(CENTER));

                ArrayList<MarkStudent> sourceData;
                sourceData = model.getMarkData();

                if (!model.getError()) {
                    markTable = MarkTable.getInstance(sourceData);
                    Mark mr = new Mark(markTable);
                    markControl = new MarkControl(frame, model, mr, markTable);
                    center = mr.showMarks();
                    frame.add(center);
                    frame.getBorder().addLayoutComponent(center, CENTER);
                    frame.revalidate();
                } else {
                    error();
                    System.out.println("nie działąm");
                }
            } else if (source == frame.getNewPupil()) {
                if (frame.getBorder().getLayoutComponent(CENTER) != null)
                    frame.remove(frame.getBorder().getLayoutComponent(CENTER));

                Configuration pr = new Configuration();
                center = pr.showConfiguration();
                frame.add(center);
                frame.getBorder().addLayoutComponent(center, CENTER);
                frame.revalidate();
            }
        }
    }

    public void error() {

        DialogInfo error = new DialogInfo(center, "Nie nawiązano połączenia z bazą danych", "Błąd!");
    }
}

