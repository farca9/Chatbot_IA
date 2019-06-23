import Core.ChatbotCore;
import NLP.Lema;
import Produccion.MTEntry;
import Produccion.Regla;
import UI.Chatbox;

import javax.swing.*;
import java.awt.*;
import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) {

        /*try {
            System.setOut(new PrintStream(new PrintStream(new File("LogChatbot.txt"))));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }*/


            JFrame frame = new JFrame("Chatbox");
            frame.setContentPane(new Chatbox().mainPanel);
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.pack();
            frame.setVisible(true);
            frame.setLocationRelativeTo(null);
            frame.setIconImage(Toolkit.getDefaultToolkit().getImage(frame.getClass().getResource("/res/logo2.png")));
            frame.setTitle("Bernard Lowe - Asistente de ventas");




    }
}
