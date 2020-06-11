package Control;

import GUI.Configuration;
import Model.Connection.ModelFasade;
import Model.Students.ConfigurationStudent;
import Model.Students.Student;

import javax.swing.*;
import javax.swing.event.TreeSelectionEvent;
import javax.swing.event.TreeSelectionListener;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;
import java.util.ArrayList;

public class JTreeControl {

    private JTree tree;
    private DefaultMutableTreeNode top;
    private ModelFasade model;
    DefaultMutableTreeNode treeNode;
    int marked;
    ConfigurationStudent student;

    public JTreeControl(ModelFasade model) {
        this.model = model;
        top = new DefaultMutableTreeNode("Studeneci");
        //add("0");
        setTree(model.getConfigData());

        tree = new JTree(top);

       /* tree.addTreeSelectionListener(new TreeSelectionListener() {
            public void valueChanged(TreeSelectionEvent e) {
                DefaultMutableTreeNode node = (DefaultMutableTreeNode)
                        e.getPath().getLastPathComponent();
                if(node.isLeaf()) {
                    student = (ConfigurationStudent)node.getUserObject();

                }
            }
        });*/
    }

    private void setTree(ArrayList<ConfigurationStudent> students) {

        for (int i = 0; i < students.size(); i++) {
            add(students.get(i));
        }
    }


    private void add(ConfigurationStudent student) {
        treeNode = new DefaultMutableTreeNode(student);
        top.add(treeNode);
    }

    /*private void deleteElement() {

        //top.remove(index);
        update();
    }*/


    private void update() {
        DefaultTreeModel model = (DefaultTreeModel) tree.getModel();
        DefaultMutableTreeNode root = (DefaultMutableTreeNode) model.getRoot();
        model.reload(root);
    }

    public ConfigurationStudent getStudent() {
        return student;
    }

    public JTree getTree() {
        return tree;
    }
}
