package UI;

import Core.ChatbotCore;
import Exceptions.NoLemasException;
import Exceptions.NoRulesException;

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
    private boolean firstInteraction=true;

    private void createUIComponents() {
    }


    public Chatbox(){
        this.createUIComponents();

        sendButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(firstInteraction){

                    String output;
                    try {
                        output=ChatbotCore.getInstance().innerSendAndReceive();
                        chatTextArea.append("\n>> Bot (" + sdf.format(new Date()) + "): " + output + "\n");
                    } catch (NoRulesException ex) {
                        ex.printStackTrace();
                    }

                    inputTextArea.setText("");

                    firstInteraction=false;
                } else {

                    String input, output1, output2;
                    input = inputTextArea.getText();


                    chatTextArea.append("\n<< You (" + sdf.format(new Date()) + "): " + input + "\n");

                    input = input.toLowerCase();
                    try {
                        output1 = ChatbotCore.getInstance().sendAndReceive(input);
                    } catch (NoRulesException ex) {
                        output1 = ChatbotCore.generarNoComprendo();
                    } catch (NoLemasException ex) {
                        output1 = ChatbotCore.generarNoComprendo();
                    }

                    chatTextArea.append("\n>> Bot (" + sdf.format(new Date()) + "): " + output1 + "");

                    try{
                        output2 = ChatbotCore.getInstance().innerSendAndReceive();
                    } catch (NoRulesException ex) {
                        ex.printStackTrace();
                        output2 = "no inner rule found /notonfirst";
                    }

                    chatTextArea.append("\n>> Bot (" + sdf.format(new Date()) + "): " + output2 + "\n");

                    inputTextArea.setText("");
                }

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
                firstInteraction=true;

                sendButton.doClick();

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

        sendButton.doClick();

    }

}
