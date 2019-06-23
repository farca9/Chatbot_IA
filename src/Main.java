import NLP.Lema;
import Produccion.MTEntry;
import Produccion.Regla;
import UI.Chatbox;

import javax.swing.*;
import java.util.ArrayList;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) {

        JFrame frame = new JFrame("Chatbox");
        frame.setContentPane(new Chatbox().mainPanel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
        frame.setLocationRelativeTo(null);

    }
}
