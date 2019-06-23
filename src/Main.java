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

        Regla r =new Regla(
                1,
                new ArrayList<>(Arrays.asList(new Lema("notebook"))),
                new ArrayList<>(),
                new ArrayList<>(Arrays.asList(new MTEntry("ans", "marca"), new MTEntry("tipoProducto", null))),
                new ArrayList<>(Arrays.asList(new MTEntry("tipoProducto", "notebook"), new MTEntry("ask", "marca"))),
                "Que marca quiere?");

        System.out.println(r.toString());

    }
}
