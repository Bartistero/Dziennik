package Control;

import GUI.*;
import Model.Connection.ModelFasade;
import Model.Students.ConfigurationStudent;

import javax.swing.*;
import javax.swing.event.TreeSelectionEvent;
import javax.swing.event.TreeSelectionListener;
import javax.swing.tree.DefaultMutableTreeNode;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;

import static java.awt.BorderLayout.CENTER;

public class ConfigurationControl {

    private Gui frame;
    private ModelFasade model;
    private Configuration configuration;
    private JTreeControl treeControl;
    private ConfigurationStudent student;
    private NewPerson newPerson;
    private boolean save = false;
    private boolean edit = false;
    private DefaultMutableTreeNode node;

    public ConfigurationControl(Gui frame,ModelFasade model, Configuration configuration, JTreeControl treeControl) {

        this.treeControl = treeControl;
        this.frame = frame;
        this.model = model;
        this.configuration = configuration;
        configuration.addListenner(new listener());

        setDataTree();

    }

    public void setStudent(ConfigurationStudent student) {
        configuration.gettName().setText(student.getName());

    }

    public void setDataTree() {
        treeControl.getTree().addTreeSelectionListener(new TreeSelectionListener() {
            public void valueChanged(TreeSelectionEvent e) {
                 node = (DefaultMutableTreeNode)
                        e.getPath().getLastPathComponent();
                if (node.isLeaf()) {
                    student = (ConfigurationStudent) node.getUserObject();
                    configuration.gettName().setText(student.getName());
                    configuration.gettSurrname().setText(student.getSurname());
                    configuration.gettAddress().setText(student.getAddress());
                    configuration.gettPesel().setText(student.getPESEL());
                    configuration.gettIndex().setText(student.getid());
                    configuration.gettTel().setText(student.getTel());
                    configuration.gettMail().setText(student.geteMail());

                }
            }
        });
    }

    class listener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            Object source = e.getSource();

            if (source == configuration.getNewPupil()) {
                newPerson = new NewPerson(configuration.getConfiguration());
                String index = treeControl.getList().get(treeControl.getList().size()-1).getid();
                index = Integer.toString(Integer.valueOf(index) + 1 );
                newPerson.gettIndex().setText(index);
                newPerson.addListener(new listenerDialog());
                newPerson.getJd().addWindowListener(new WindowAdapter() {
                    public void windowClosed(WindowEvent e) {
                        save = false;
                    }
                });


            } else if (source == configuration.getEdit()) {
                if (student != null) {
                    edit = true;
                    newPerson = new NewPerson(configuration.getConfiguration());
                    newPerson.addListener(new listenerDialog());

                    newPerson.gettName().setText(student.getName());
                    newPerson.gettSurrname().setText(student.getSurname());
                    newPerson.gettAddress().setText(student.getAddress());
                    newPerson.gettPesel().setText(student.getPESEL());
                    newPerson.gettIndex().setText(student.getid());
                    newPerson.gettTel().setText(student.getTel());
                    newPerson.gettMail().setText(student.geteMail());
                    newPerson.addListener(new listenerDialog());

                    newPerson.getJd().addWindowListener(new WindowAdapter() {
                        public void windowClosed(WindowEvent e) {
                            save = false;
                            edit = false;
                        }
                    });
                } else {
                    DialogInfo dialogInfo = new DialogInfo(configuration.getConfiguration(), "Najpierw należy wybrać ucznia!", "Błąd!");
                }


            } else if (source == configuration.getDelete()) {

                if(student !=null){
                     DialogInfo dialogInfo = new DialogInfo(configuration.getConfiguration(), "Czy jest pewny, że chcesz usunąć ucznia: " + student.getName() + " "+student.getSurname() + "?", "Ostrzeżenie");
                    if(dialogInfo.getChoice() == 0){
                        if(student!=null){
                            System.out.println(student.getName());
                            treeControl.deleteElement( node,student);
                            treeControl.update();
                        }
                    }
                }else{
                    DialogInfo dialogInfo = new DialogInfo(configuration.getConfiguration(), "Najpierw należy wybrać ucznia!", "Błąd!");
                }

            } else if (source == configuration.getSave()) {

                saveDataInDB();

            } else if (source == configuration.getCancel()) {

                NoSave save = new NoSave(configuration.getConfiguration());
                int x = save.getChoice();
                if (x == 0) {
                    if (frame.getBorder().getLayoutComponent(CENTER) != null)
                        frame.remove(frame.getBorder().getLayoutComponent(CENTER));
                    JPanel empty = new JPanel();
                    frame.add(empty, CENTER);
                    frame.revalidate();
                } else if (x == 1) {
                    saveDataInDB();
                }

            }
        }

        class listenerDialog implements ActionListener {
            @Override
            public void actionPerformed(ActionEvent e) {
                Object source = e.getSource();
                if (source == newPerson.getOkey()) {
                    newsave();

                } else if (source == newPerson.getCancel()) {
                    if (save == false) {
                        NoSave noSave = new NoSave(configuration.getConfiguration());
                        if (noSave.getChoice() == 0) {
                            newPerson.getJd().dispose();
                        } else if (noSave.getChoice() == 1) {
                            newsave();
                        }
                    } else {
                        newPerson.getJd().dispose();
                        save = false;
                        edit = false;
                    }
                }
            }
        }

        private void newsave() {
            if (edit == true) {
                if (save == false) {
                    student.setName(newPerson.gettName().getText());
                    student.setSurrname(newPerson.gettSurrname().getText());
                    student.setAddress(newPerson.gettAddress().getText());
                    student.setPESEL(newPerson.gettPesel().getText());
                    student.setId(newPerson.gettIndex().getText());
                    student.setTel(newPerson.gettTel().getText());
                    student.seteMail(newPerson.gettMail().getText());
                    //treeControl.deleteElement(node);
                   // int position = treeControl.getList().indexOf(student);
                   // System.out.println(position);
                   // treeControl.getList().set(position,student);
                    treeControl.update();
                    save = true;
                    DialogInfo dialogInfo = new DialogInfo(configuration.getConfiguration(), "Dane zostały tymczasowo zapisane \n UWAGA!!! \n Na końcu pracy należy zapisać dane do bazy danych!!!", "Zapis");
                    newPerson.getJd().dispose();
                }

            } else {
                if (save == false) {
                    student = new ConfigurationStudent.Builder()
                            .name(newPerson.gettName().getText())
                            .surrname(newPerson.gettSurrname().getText())
                            .address(newPerson.gettAddress().getText())
                            .PESEL(newPerson.gettPesel().getText())
                            .id(newPerson.gettIndex().getText())
                            .tel(newPerson.gettTel().getText())
                            .eMail(newPerson.gettMail().getText())
                            .build();
                    treeControl.add(student);
                    treeControl.getList().add(student);
                    treeControl.update();
                    save = true;
                    DialogInfo dialogInfo = new DialogInfo(configuration.getConfiguration(), "Dane zostały tymczasowo zapisane \n UWAGA!!! \n Na końcu należy zapisać dane do bazy danych!!!", "Zapis");
                    newPerson.getJd().dispose();
                }
            }
        }
        public void saveDataInDB(){
            model.writeConfigData(treeControl.getList());
            if (!model.getError())
            {
                DialogInfo dialogInfo= new DialogInfo(configuration.getConfiguration(), "Wystąpił bład, nie zapisano danych.", "Błąd!");
            } else if (frame.getBorder().getLayoutComponent(CENTER) != null) {

                DialogInfo dialogInfo = new DialogInfo(configuration.getConfiguration(), "Dane zostały pomyślnie zapisane", "Sukces!");
                frame.remove(frame.getBorder().getLayoutComponent(CENTER));
                JPanel empty = new JPanel();
                frame.add(empty, CENTER);
                frame.revalidate();
            }
        }
    }
}

