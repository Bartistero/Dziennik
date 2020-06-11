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

import static java.awt.BorderLayout.CENTER;

public class ConfigurationControl {

    private Gui frame;
    private ModelFasade model;
    private Configuration configuration;
    private JTreeControl treeControl;

    public ConfigurationControl(Gui frame, ModelFasade model, Configuration configuration,JTreeControl treeControl) {
        this.treeControl = treeControl;
        this.frame = frame;
        this.model = model;
        this.configuration = configuration;
        configuration.addListenner(new listener());

        setDataTree();


    }
    public void setStudent(ConfigurationStudent student){
        configuration.gettName().setText(student.getName());

    }
    public void setDataTree(){
        treeControl.getTree().addTreeSelectionListener(new TreeSelectionListener() {
            public void valueChanged(TreeSelectionEvent e) {
                DefaultMutableTreeNode node = (DefaultMutableTreeNode)
                        e.getPath().getLastPathComponent();
                if(node.isLeaf()) {
                    ConfigurationStudent student = (ConfigurationStudent)node.getUserObject();
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

            if(source == configuration.getNewPupil()){
                NewPerson person = new NewPerson(frame);
            }else if(source == configuration.getEdit()){
                System.out.println("Działąm edycja");

            }else if(source == configuration.getDelete()){
                System.out.println("Działąm usuń");

            }else if(source == configuration.getSave()){
                System.out.println("Działąm zapisz");

            }else if(source == configuration.getCancel()){
                System.out.println("Działam anuluj");

            }
        }
    }

}
