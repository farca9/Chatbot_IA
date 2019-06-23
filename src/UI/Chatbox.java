package UI;

import Core.ChatbotCore;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Chatbox {
    private JButton sendButton;
    private JTextArea inputTextArea;
    private JTextArea chatTextArea;
    public JPanel mainPanel;
    private JButton clearButton;
    private JButton recomendarButton;
    private SimpleDateFormat sdf = new SimpleDateFormat("HH:mm");

    private void createUIComponents() {
    }


    public Chatbox(){
        this.createUIComponents();

        sendButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String input, output;
                input = inputTextArea.getText();


                chatTextArea.append("\n<< You ("+sdf.format(new Date())+"): "+input+"\n");

                input=input.toLowerCase();
                output = ChatbotCore.getInstance().sendAndReceive(input);

                chatTextArea.append("\n>> Bot ("+sdf.format(new Date())+"): "+output+"\n");

                inputTextArea.setText("");


            }
        });

        clearButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                inputTextArea.setText("");
                chatTextArea.setText("Bienvenido al Asistente de Compras!!\n");

                ChatbotCore.getInstance().clearChat();

                sendButton.setEnabled(true);
                recomendarButton.setEnabled(true);

            }
        });
        inputTextArea.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                if(e.getKeyCode()==KeyEvent.VK_ENTER){
                    sendButton.doClick(); //TODO FIX SIGUE APARECIENDO ENTER
                }
            }
        });
        recomendarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                inputTextArea.setText("");

                String output = ChatbotCore.getInstance().hacerRecomendacion();

                chatTextArea.append("\n>> Bot ("+sdf.format(new Date())+"): "+output+"\n");

                sendButton.setEnabled(false);
                recomendarButton.setEnabled(false);
            }
        });
    }

}
