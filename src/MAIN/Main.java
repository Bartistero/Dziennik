package MAIN;
import Control.Control;
import GUI.Gui;

import java.io.IOException;

public class Main {
    public static void main(String arg[])  {

        Gui frame = new Gui();
        frame.frame();

        Control ct = new Control(frame);

    }
}
