package Control;

import GUI.*;
import Model.Connection.ModelFasade;
import Model.Table.PresenceTable;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import static java.awt.BorderLayout.CENTER;

public class PresenceControl {

    private Presence presence;
    private Gui frame;
    private ModelFasade model;
    private PresenceTable presenceTable;
    private DialogInfo error;
    PresenceTable.TableListener tableListener;


    public PresenceControl(Gui frame, ModelFasade model, Presence presence, PresenceTable presenceTable) {
        this.presenceTable = presenceTable;
        this.frame = frame;
        this.presence = presence;
        this.model = model;
        tableListener = new PresenceTable.TableListener(presence.getTable());
        presence.addListenner(new listener(), tableListener);
    }

    private void zapisz() {
        model.writePresentData(presenceTable.getColumnNames(), presenceTable.getData());
        if (!model.getError())
            error = new DialogInfo(presence.getPresence(), "Wystąpił bład, nie zapisano danych.", "Błąd!");

        else if (frame.getBorder().getLayoutComponent(CENTER) != null) {

            error = new DialogInfo(presence.getPresence(), "Dane zostały pomyślnie zapisane", "Sukces!");
            frame.remove(frame.getBorder().getLayoutComponent(CENTER));
            JPanel empty = new JPanel();
            frame.add(empty, CENTER);
            presenceTable.delete();
            frame.revalidate();
        }
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
                    presenceTable.delete();
                    frame.revalidate();
                } else if (x == 1) {
                    zapisz();
                }
            } else if (source == presence.getSave()) {

                zapisz();
            } else if (source == presence.getPresent()) {

                presenceTable.changeData(tableListener, "+");

            } else if (source == presence.getAbsent()) {

                presenceTable.changeData(tableListener, "-");

            } else if (source == presence.getLate()) {

                presenceTable.changeData(tableListener, "S");

            } else if (source == presence.getNewLesson()) {

                Question nl = new Question(presence.getPresence(), 0);
                String name = nl.getName();
                if (name != null) {
                    if (presenceTable.addNewColumn(name)) {
                        presence.setTableView();
                    } else {
                        error = new DialogInfo(presence.getPresence(), "Taka lekcja już istnieje, lub nie może być pusta!", "Uwaga!");
                    }
                }
            } else if (source == presence.getDeleteLesson()) {

                String column = presenceTable.getSelectedColumn(tableListener);
                DialogInfo question = new DialogInfo(presence.getPresence(), "Czy jesteś pewny, że chcesz usunąć kolumnę " + column + "?", "Uwaga!");
                if (question.getChoice() == 0) {
                    if (presenceTable.deleteColumn(tableListener)) {
                        presence.setTableView();

                    } else {
                        question.setText("Nie można usunąć tej kolumny!");
                        question.show();
                    }

                }
            }
        }
    }
}

