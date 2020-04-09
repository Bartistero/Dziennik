package GUI;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.event.TreeSelectionEvent;
import javax.swing.event.TreeSelectionListener;
import javax.swing.tree.DefaultMutableTreeNode;
import java.awt.*;

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

    private DefaultMutableTreeNode root;


    public Configuration() {
        showFrame();
    }

    private void showFrame(){

        configuration.setLayout(new BorderLayout());

        //Tree panel
        group = new JPanel();
        group.setLayout(new BorderLayout());
        root = new DefaultMutableTreeNode("Studenci");
        tree = new JTree(root);
        root.add(new DefaultMutableTreeNode("Bartosz Sterniczuk"));
        root.add(new DefaultMutableTreeNode("Jan Kowalski"));
        root.add(new DefaultMutableTreeNode("Jan Kowalski"));

        group.add(new JScrollPane(tree));
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
        gc.gridy = 1;
        option.add(edit, gc);

        delete = new JButton("Usuń ucznia");
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

        layout.putConstraint(SpringLayout.WEST, mail, 25, SpringLayout.WEST, getContentPane());
        layout.putConstraint(SpringLayout.NORTH, mail, 50, SpringLayout.NORTH, tel);
        center.add(mail);

        layout.putConstraint(SpringLayout.WEST, tMail, 125, SpringLayout.WEST, mail);
        layout.putConstraint(SpringLayout.NORTH, tMail, 50, SpringLayout.NORTH, tTel);
        center.add(tMail);

        configuration.add(center, BorderLayout.CENTER);
    }

    public JPanel showConfiguration() {
        return configuration;
    }
}
