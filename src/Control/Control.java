package Control;

import GUI.*;
import Model.Students.ConfigurationStudent;
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

    private Configuration configuration;
    private JTreeControl treeControl;
    private ConfigurationControl configurationControl;


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
                    mark = new Mark(markTable);
                    markControl = new MarkControl(frame, model, mark, markTable);
                    center = mark.showMarks();
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


                ArrayList<ConfigurationStudent> list  = model.getConfigData();
                treeControl = new JTreeControl(list);
                configuration = new Configuration(treeControl);
                configurationControl = new ConfigurationControl(frame,model, configuration,treeControl);
                center = configuration.getConfiguration();
                frame.add(center);
                frame.getBorder().addLayoutComponent(center, CENTER);
                frame.revalidate();
            }
        }
    }

    public void error() {

        DialogInfo error = new DialogInfo(center, "Nie nawiązano połączenia z bazą danych", "Błąd!");
    }

    public Configuration getConfiguration() {
        return configuration;
    }
}

