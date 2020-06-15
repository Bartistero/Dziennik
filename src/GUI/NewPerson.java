package GUI;

import com.sun.xml.internal.messaging.saaj.soap.JpegDataContentHandler;
import com.sun.xml.internal.ws.api.model.wsdl.WSDLOutput;
import jdk.nashorn.internal.scripts.JD;
import org.w3c.dom.ls.LSOutput;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

import static javax.swing.WindowConstants.DISPOSE_ON_CLOSE;

public class NewPerson{

    private JPanel panel;

    private JLabel name;
    private JLabel surrname;
    private JLabel address;
    private JLabel pesel;
    private JLabel index;
    private JLabel tel;
    private JLabel mail;

    private JTextField tName;
    private JTextField tSurrname;
    private JTextField tAddress;
    private JTextField tPesel;
    private JTextField tIndex;
    private JTextField tTel;
    private JTextField tMail;

    private JButton okey;
    private JButton cancel;

    private JDialog jd;

    public NewPerson(JPanel frame){

        setWindows();

        jd =new JDialog();
        jd.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        jd.setSize(500,600);
        jd.setLocationRelativeTo(frame);
        jd.add(panel);
        jd.setVisible(true);
    }
    void setWindows(){

        panel = new JPanel();

        panel.setLayout(new GridLayout(9,2));

        name = new JLabel("Imię: ");
        tName = new JTextField();
        panel.add(name);
        panel.add(tName);

        surrname = new JLabel("Nazwisko: ");
        tSurrname = new JTextField();
        panel.add(surrname);
        panel.add(tSurrname);

        address = new JLabel("Adres: ");
        tAddress = new JTextField();
        panel.add(address);
        panel.add(tAddress);

        pesel = new JLabel("PESEL: ");
        tPesel = new JTextField();
        panel.add(pesel);
        panel.add(tPesel);

        index = new JLabel("Index: ");
        tIndex = new JTextField();
        panel.add(index);
        panel.add(tIndex);

        tel = new JLabel("Telefon: ");
        tTel = new JTextField();
        panel.add(tel);
        panel.add(tTel);

        mail = new JLabel("Mail: ");
        tMail = new JTextField();
        panel.add(mail);
        panel.add(tMail);

        okey = new JButton("OK");
        cancel = new JButton("Anuluj");
        panel.add(okey);
        panel.add(cancel);

    }
    public void addListener(ActionListener listener){
        okey.addActionListener(listener);
        cancel.addActionListener(listener);
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

    public JButton getOkey() {
        return okey;
    }

    public JButton getCancel() {
        return cancel;
    }

    public JDialog getJd() {
        return jd;
    }
}
