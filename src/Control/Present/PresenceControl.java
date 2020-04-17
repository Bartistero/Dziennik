package Control.Present;

import Control.Control;
import GUI.Gui;
import GUI.NewLesson;
import GUI.NoSave;
import GUI.Presence;
import Model.Connection.ModelFasade;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import static java.awt.BorderLayout.CENTER;

public class PresenceControl {

    private Presence presence;
    private Gui frame;
    private ModelFasade model;
    private PresenceTable presenceTable;

    public PresenceControl(Gui frame, ModelFasade model, Presence presence, PresenceTable presenceTable) {
        this.presenceTable = presenceTable;
        this.frame = frame;
        this.presence = presence;
        this.model = model;
        presence.addListenner(new listener());

    }

    class listener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            Object source = e.getSource();
            if (source == presence.getCancel()) {
                NoSave save = new NoSave(presence.getPresence());
                int x = save.getChoice();
                if (x == 0) {
                    if (frame.getBorder().getLayoutComponent(CENTER) != null)
                        frame.remove(frame.getBorder().getLayoutComponent(CENTER));
                    JPanel empty = new JPanel();
                    frame.add(empty, CENTER);
                    frame.revalidate();
                } else if (x == 1) {
                    System.out.println("Tu będzie zapis");
                }
            } else if (source == presence.getSave()) {
                System.out.println("Tutaj bd zapis xD");
            } else if (source == presence.getPresent()) {


            } else if (source == presence.getAbsent()) {


            } else if (source == presence.getLate()) {


            } else if (source == presence.getNewLesson()) {
                NewLesson nl = new NewLesson(presence.getPresence());
                String name = nl.getName();
               presenceTable.addNewColumn(name);
               presence.setTableView();
                //presence.getTable().setModel(presenceTable);
                //presence.revalidate();
            }
        }

    }
}
