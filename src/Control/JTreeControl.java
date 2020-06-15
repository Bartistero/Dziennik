package Control;

import GUI.Configuration;
import Model.Connection.ModelFasade;
import Model.Students.ConfigurationStudent;
import Model.Students.Student;
import org.omg.PortableInterceptor.INACTIVE;

import javax.swing.*;
import javax.swing.event.TreeSelectionEvent;
import javax.swing.event.TreeSelectionListener;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;
import javax.swing.tree.MutableTreeNode;
import java.util.ArrayList;

public class JTreeControl {

    private JTree tree;
    private DefaultMutableTreeNode top;
    private ArrayList<ConfigurationStudent> list;
    DefaultMutableTreeNode treeNode;
    int marked;
    ConfigurationStudent student;

    public JTreeControl(ArrayList<ConfigurationStudent> list) {

        this.list = list;
        top = new DefaultMutableTreeNode("Studeneci");
        //add("0");
        setTree(list);

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

    public void setTree(ArrayList<ConfigurationStudent> students) {

        for (int i = 0; i < students.size(); i++) {
            add(students.get(i));
        }
    }


    public void add(ConfigurationStudent student) {
        treeNode = new DefaultMutableTreeNode(student);
        top.add(treeNode);
    }

    public void deleteElement(DefaultMutableTreeNode node,ConfigurationStudent student) {

       /* DefaultMutableTreeNode node = new DefaultMutableTreeNode();
        node.add((MutableTreeNode) student);*/
       list.remove(student);
        top.remove(node);
    }


    public void update() {
        DefaultTreeModel model = (DefaultTreeModel) tree.getModel();
        DefaultMutableTreeNode root = (DefaultMutableTreeNode) model.getRoot();
        model.reload(root);
    }

    private ConfigurationStudent getStudent() {
        return student;
    }

    public JTree getTree() {
        return tree;
    }

    public ArrayList<ConfigurationStudent> getList() {
        return list;
    }
}
