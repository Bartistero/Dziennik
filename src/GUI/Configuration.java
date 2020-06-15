package GUI;

import Control.JTreeControl;
import com.sun.xml.internal.ws.api.streaming.XMLStreamReaderFactory;

import javax.swing.*;
import javax.swing.event.TreeModelEvent;
import javax.swing.event.TreeModelListener;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;
import javax.swing.tree.TreePath;
import javax.swing.tree.TreeSelectionModel;
import java.awt.*;
import java.awt.event.ActionListener;
import java.util.Vector;

public class Configuration extends JFrame {

    private JPanel configuration = new JPanel();
    private JPanel option;
    private JPanel finish;
    private JPanel group;
    private JPanel center;

    private JButton newPupil;
    private JButton edit;
    private JButton delete;
    private JButton save;
    private JButton cancel;

    private JTextField tName;
    private JTextField tSurrname;
    private JTextField tAddress;
    private JTextField tPesel;
    private JTextField tIndex;
    private JTextField tTel;
    private JTextField tMail;

    private JTree tree;
    private JTreeControl control;

    private DefaultMutableTreeNode root;


    public Configuration(JTreeControl control) {
        this.control = control;
        showFrame();
        tree = new JTree();
    }

    private void showFrame() {

        configuration.setLayout(new BorderLayout());

        //Tree panel
        group = new JPanel();
        group.setLayout(new BorderLayout());


        tree = (control.getTree());
        tree.setEditable(true);
        tree.getSelectionModel().setSelectionMode
                (TreeSelectionModel.SINGLE_TREE_SELECTION);
        tree.setShowsRootHandles(true);


        group.add(tree);

        configuration.add(group, BorderLayout.WEST);

        //Left-option panel
        option = new JPanel();
        option.setBackground(Color.LIGHT_GRAY);
        option.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        GridBagLayout grid = new GridBagLayout();
        GridBagConstraints gc = new GridBagConstraints();
        gc.insets = new Insets(2, 5, 1, 2);
        gc.fill = GridBagConstraints.HORIZONTAL;
        option.setLayout(grid);

        newPupil = new JButton("Nowy uczeń");
        gc.gridx = 0;
        gc.gridy = 0;
        option.add(newPupil, gc);

        edit = new JButton("Edytuj ucznia");
        gc.gridx = 0;
        gc.gridy = 1;
        option.add(edit, gc);

        delete = new JButton("Usuń ucznia");
        gc.gridx = 0;
        gc.gridy = 2;
        option.add(delete, gc);

        configuration.add(option, BorderLayout.EAST);

        //Footer
        finish = new JPanel();
        finish.setLayout(new GridBagLayout());
        gc.insets = new Insets(2, 5, 5, 2);

        gc.gridx = 0;
        gc.gridy = 0;
        save = new JButton("Zapisz");
        finish.add(save, gc);

        gc.gridx = 1;
        gc.gridy = 0;
        cancel = new JButton("Anuluj");
        finish.add(cancel, gc);

        configuration.add(finish, BorderLayout.SOUTH);


        //Center Panel
        center = new JPanel();
        center.setBackground(Color.white);
        center.setBorder(BorderFactory.createLineBorder(Color.black, 1, false));
        SpringLayout layout = new SpringLayout();
        center.setLayout(layout);


        JLabel name = new JLabel("Imię (Imiona):");
        name.setFont(name.getFont().deriveFont(16.0f));

        tName = new JTextField();
        tName.setPreferredSize(new Dimension(500, 24));
        tName.setEnabled(false);
        tName.setDisabledTextColor(Color.BLACK);

        layout.putConstraint(SpringLayout.WEST, name, 25, SpringLayout.WEST, getContentPane());
        layout.putConstraint(SpringLayout.NORTH, name, 100, SpringLayout.NORTH, getContentPane());
        center.add(name);

        layout.putConstraint(SpringLayout.WEST, tName, 25, SpringLayout.EAST, name);
        layout.putConstraint(SpringLayout.NORTH, tName, 100, SpringLayout.NORTH, getContentPane());
        center.add(tName);


        JLabel surrname = new JLabel("Nazwisko:");
        surrname.setFont(surrname.getFont().deriveFont(16.0f));

        tSurrname = new JTextField();
        tSurrname.setPreferredSize(new Dimension(500, 24));
        tSurrname.setEnabled(false);
        tSurrname.setDisabledTextColor(Color.BLACK);

        layout.putConstraint(SpringLayout.WEST, surrname, 25, SpringLayout.WEST, getContentPane());
        layout.putConstraint(SpringLayout.NORTH, surrname, 50, SpringLayout.NORTH, name);
        center.add(surrname);

        layout.putConstraint(SpringLayout.WEST, tSurrname, 125, SpringLayout.WEST, surrname);
        layout.putConstraint(SpringLayout.NORTH, tSurrname, 50, SpringLayout.NORTH, tName);
        center.add(tSurrname);


        JLabel address = new JLabel("Adres:");
        address.setFont(address.getFont().deriveFont(16.0f));

        tAddress = new JTextField();
        tAddress.setPreferredSize(new Dimension(500, 24));
        tAddress.setEnabled(false);
        tAddress.setDisabledTextColor(Color.BLACK);

        layout.putConstraint(SpringLayout.WEST, address, 25, SpringLayout.WEST, getContentPane());
        layout.putConstraint(SpringLayout.NORTH, address, 50, SpringLayout.NORTH, surrname);
        center.add(address);

        layout.putConstraint(SpringLayout.WEST, tAddress, 125, SpringLayout.WEST, address);
        layout.putConstraint(SpringLayout.NORTH, tAddress, 50, SpringLayout.NORTH, tSurrname);
        center.add(tAddress);


        JLabel pesel = new JLabel("PESEL:");
        pesel.setFont(address.getFont().deriveFont(16.0f));

        tPesel = new JTextField();
        tPesel.setPreferredSize(new Dimension(500, 24));
        tPesel.setEnabled(false);
        tPesel.setDisabledTextColor(Color.BLACK);

        layout.putConstraint(SpringLayout.WEST, pesel, 25, SpringLayout.WEST, getContentPane());
        layout.putConstraint(SpringLayout.NORTH, pesel, 50, SpringLayout.NORTH, address);
        center.add(pesel);

        layout.putConstraint(SpringLayout.WEST, tPesel, 125, SpringLayout.WEST, pesel);
        layout.putConstraint(SpringLayout.NORTH, tPesel, 50, SpringLayout.NORTH, tAddress);
        center.add(tPesel);


        JLabel index = new JLabel("Nr. indeksu:");
        index.setFont(address.getFont().deriveFont(16.0f));

        tIndex = new JTextField();
        tIndex.setPreferredSize(new Dimension(500, 24));
        tIndex.setEnabled(false);
        tIndex.setDisabledTextColor(Color.BLACK);

        layout.putConstraint(SpringLayout.WEST, index, 25, SpringLayout.WEST, getContentPane());
        layout.putConstraint(SpringLayout.NORTH, index, 50, SpringLayout.NORTH, pesel);
        center.add(index);

        layout.putConstraint(SpringLayout.WEST, tIndex, 125, SpringLayout.WEST, index);
        layout.putConstraint(SpringLayout.NORTH, tIndex, 50, SpringLayout.NORTH, pesel);
        center.add(tIndex);


        JLabel tel = new JLabel("Tel.:");
        tel.setFont(address.getFont().deriveFont(16.0f));

        tTel = new JTextField();
        tTel.setPreferredSize(new Dimension(500, 24));
        tTel.setEnabled(false);
        tTel.setDisabledTextColor(Color.BLACK);

        layout.putConstraint(SpringLayout.WEST, tel, 25, SpringLayout.WEST, getContentPane());
        layout.putConstraint(SpringLayout.NORTH, tel, 50, SpringLayout.NORTH, index);
        center.add(tel);

        layout.putConstraint(SpringLayout.WEST, tTel, 125, SpringLayout.WEST, tel);
        layout.putConstraint(SpringLayout.NORTH, tTel, 50, SpringLayout.NORTH, tIndex);
        center.add(tTel);


        JLabel mail = new JLabel("E-Mail:");
        mail.setFont(address.getFont().deriveFont(16.0f));

        tMail = new JTextField();
        tMail.setPreferredSize(new Dimension(500, 24));
        tMail.setEnabled(false);
        tMail.setDisabledTextColor(Color.BLACK);

        layout.putConstraint(SpringLayout.WEST, mail, 25, SpringLayout.WEST, getContentPane());
        layout.putConstraint(SpringLayout.NORTH, mail, 50, SpringLayout.NORTH, tel);
        center.add(mail);

        layout.putConstraint(SpringLayout.WEST, tMail, 125, SpringLayout.WEST, mail);
        layout.putConstraint(SpringLayout.NORTH, tMail, 50, SpringLayout.NORTH, tTel);
        center.add(tMail);

        configuration.add(center, BorderLayout.CENTER);
    }

    public void addListenner(ActionListener listener) {


        newPupil.addActionListener(listener);
        edit.addActionListener(listener);
        delete.addActionListener(listener);
        save.addActionListener(listener);
        cancel.addActionListener(listener);

    }

    public JButton getNewPupil() {
        return newPupil;
    }

    public JButton getEdit() {
        return edit;
    }

    public JButton getDelete() {
        return delete;
    }

    public JButton getSave() {
        return save;
    }

    public JButton getCancel() {
        return cancel;
    }

    public JPanel getConfiguration() {
        return configuration;
    }

    public JTree getTree() {
        return tree;
    }

    public JTextField gettName() {
        return tName;
    }

    public JTextField gettSurrname() {
        return tSurrname;
    }

    public JTextField gettAddress() {
        return tAddress;
    }

    public JTextField gettPesel() {
        return tPesel;
    }

    public JTextField gettIndex() {
        return tIndex;
    }

    public JTextField gettTel() {
        return tTel;
    }

    public JTextField gettMail() {
        return tMail;
    }
}
