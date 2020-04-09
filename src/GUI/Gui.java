package GUI;


import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;


import static java.awt.BorderLayout.*;

public class Gui extends JFrame {

         JButton presence;
         JButton marks;
         JButton newPupil;

         BorderLayout border;

        public Gui(){
            super("Dziennik");
        }
    public void frame() {
            setFrame();
    }

    private void setFrame(){
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(1000, 1000);
        setLocation(25,25);
        //setResizable(false);

        border = new BorderLayout();
        setLayout(border);

        //NORTH Panel
        JPanel north = new JPanel();
        GridLayout grid = new GridLayout(1,3);
        north.setLayout(grid);
        add(north);

        presence = new JButton();
        presence.setIcon(loadImg("presence.png"));
        north.add(presence);

        marks = new JButton();
        marks.setIcon(loadImg("marks.png"));
        north.add(marks);

        newPupil  = new JButton();
        newPupil.setIcon(loadImg("new.png"));
        north.add(newPupil);

        border.addLayoutComponent(north, NORTH);


        //SOUTH Panel
        JPanel footer = new JPanel();
        add(footer);
        JLabel inf = new JLabel();
        inf.setText("© Wszystkie prawa zastrzeżone - Bartosz Sterniczuk 2020");
        add(inf);
        footer.add(inf);
        border.addLayoutComponent(footer, SOUTH);

        setVisible(true);
    }
    public void addListenner(ActionListener listener){
        presence.addActionListener(listener);
        marks.addActionListener(listener);
        newPupil.addActionListener(listener);
    }

    private ImageIcon loadImg(String name) {
        try
        {
            Image img = ImageIO.read(getClass().getResource("img/"+name));
        ImageIcon img2 = new ImageIcon(img);
            return img2;
        }catch(Exception e){
            System.out.println("Problem with load a Image");
        }return null;
    }

    public JButton getPresence() {
        return presence;
    }

    public JButton getMarks() {
        return marks;
    }

    public JButton getNewPupil() {
        return newPupil;
    }

    public BorderLayout getBorder() {
        return border;
    }
}
