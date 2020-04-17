package MAIN;

import Control.Control;
import GUI.Gui;
import Model.Connection.ModelFasade;


public class Main {
    public static void main(String arg[]) {

        Gui frame = new Gui();
        frame.frame();

        ModelFasade model = new ModelFasade();

        Control ct = new Control(frame, model);


    }

}
