package Control;

import GUI.*;
import Model.Connection.ModelFasade;
import Model.Table.MarkTable;
import Model.Table.PresenceTable;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import static java.awt.BorderLayout.CENTER;

public class MarkControl {

    private Mark mark;
    private Gui frame;
    private ModelFasade model;
    private MarkTable markTable;
    private DialogInfo error;
    MarkTable.TableListener tableListener;

    public MarkControl(Gui frame, ModelFasade model, Mark mark, MarkTable markTable) {

        this.markTable = markTable;
        this.frame = frame;
        this.mark = mark;
        this.model = model;
        tableListener = new MarkTable.TableListener(mark.getTable());
        mark.addListenner(new MarkControl.listener(), tableListener);
    }

    private void zapisz() {
       /* model.writePresentData(presenceTable.getColumnNames(), presenceTable.getData());
        if (!model.getError())
            error = new DialogInfo(presence.getPresence(), "Wystąpił bład, nie zapisano danych.", "Błąd!");
        if (frame.getBorder().getLayoutComponent(CENTER) != null)
            frame.remove(frame.getBorder().getLayoutComponent(CENTER));
        JPanel empty = new JPanel();
        frame.add(empty, CENTER);
        presenceTable.delete();
        frame.revalidate();*/
        System.out.println("Tutaj bd zapis");
    }

    class listener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {

            Object source = e.getSource();


            //Czy opłaca się tu zastosować wzorzec strategii???
            if (source == mark.getMar()[0]) {

                markTable.changeData(tableListener, "1");

            } else if (source == mark.getMar()[1]) {

                markTable.changeData(tableListener, "2");

            } else if (source == mark.getMar()[2]) {

                markTable.changeData(tableListener, "3");

            } else if (source == mark.getMar()[3]) {

                markTable.changeData(tableListener, "4");

            } else if (source == mark.getMar()[4]) {

                markTable.changeData(tableListener, "5");

            } else if (source == mark.getMar()[5]) {

                markTable.changeData(tableListener, "6");

            } else if (source == mark.getNewCol()) {

                Question nl = new Question(mark.showMarks(), 1);
                String name = nl.getName();
                if (name != null) {
                    if (markTable.addNewColumn(name)) {
                        mark.setTableView();
                    } else {
                        if (markTable.addNewColumn(name)) {
                            mark.setTableView();
                        } else {
                            error = new DialogInfo(mark.showMarks(),
                                    "Taka lekcja już istnieje, lub nie może być pusta!", "Uwaga!");
                        }
                    }
                }
            } else if (source == mark.getDeleteCol()) {

                String column = markTable.getSelectedColumn(tableListener);
                DialogInfo question = new DialogInfo(mark.showMarks(), "Czy jesteś pewny, że chcesz usinąć kolumnę " + column + "?", "Uwaga!");
                if (question.getChoice() == 0) {
                    if (markTable.deleteColumn(tableListener)) {

                        mark.setTableView();

                    } else {
                        question.setText("Nie można usunąć tej kolumny!");
                        question.show();
                    }
                }

            } else if (source == mark.getSave()) {
                    zapisz();
            } else if (source == mark.getCancel()) {
                NoSave save = new NoSave(mark.showMarks());
                int x = save.getChoice();
                if (x == 0) {
                    if (frame.getBorder().getLayoutComponent(CENTER) != null)
                        frame.remove(frame.getBorder().getLayoutComponent(CENTER));
                    JPanel empty = new JPanel();
                    frame.add(empty, CENTER);
                    markTable.delete();
                    frame.revalidate();
                } else if (x == 1) {
                    zapisz();
                    System.out.println("Tu bd zapis xD");
                }
            }
        }
    }
}
