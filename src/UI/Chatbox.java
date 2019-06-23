package UI;

import Core.ChatbotCore;
import Exceptions.NoLemasException;
import Exceptions.NoRulesException;

import javax.swing.*;
import javax.swing.text.BadLocationException;
import javax.swing.text.Style;
import javax.swing.text.StyleConstants;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Chatbox {
    private JButton sendButton;
    private JTextArea inputTextArea;
    public JPanel mainPanel;
    private JButton clearButton;
    private JButton recomendarButton;
    private JTextPane chatTextPane;
    private SimpleDateFormat sdf = new SimpleDateFormat("HH:mm");
    private boolean firstInteraction=true;
    private Style styleUser=chatTextPane.addStyle("user",null);
    private Style styleBot=chatTextPane.addStyle("bot",null);


    private void createUIComponents() {

        StyleConstants.setForeground(styleUser, Color.BLUE);
        StyleConstants.setAlignment(styleUser, StyleConstants.ALIGN_RIGHT);
        StyleConstants.setForeground(styleBot, Color.RED);
        StyleConstants.setAlignment(styleBot, StyleConstants.ALIGN_LEFT);

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
                        String line = "\n>> Bernard (" + sdf.format(new Date()) + "): " + output;
                        chatTextPane.getDocument().insertString(chatTextPane.getDocument().getLength(),line, styleBot);
                    } catch (NoRulesException ex) {
                        ex.printStackTrace();
                    } catch (BadLocationException ex) {
                        ex.printStackTrace();
                    }

                    inputTextArea.setText("");

                    firstInteraction=false;
                } else {

                    String input, output1, output2;
                    input = inputTextArea.getText().replace("\n","");


                    String line = "\n<< You (" + sdf.format(new Date()) + "): " + input;
                    try {
                        chatTextPane.getDocument().insertString(chatTextPane.getDocument().getLength(),line, styleUser);
                    } catch (BadLocationException ex) {
                        ex.printStackTrace();
                    }

                    input = input.toLowerCase();
                    try {
                        output1 = ChatbotCore.getInstance().sendAndReceive(input);
                        line = "\n>> Bernard (" + sdf.format(new Date()) + "): " + output1;
                        chatTextPane.getDocument().insertString(chatTextPane.getDocument().getLength(),line, styleBot);
                    } catch (NoRulesException ex) {
                        output1 = ChatbotCore.generarNoComprendo();
                        line = "\n>> Bernard (" + sdf.format(new Date()) + "): " + output1;
                        try {
                            chatTextPane.getDocument().insertString(chatTextPane.getDocument().getLength(),line, styleBot);
                        } catch (BadLocationException exc) {
                            exc.printStackTrace();
                        }
                        inputTextArea.setText("");
                        return;
                    } catch (NoLemasException ex) {
                        output1 = ChatbotCore.generarNoComprendo();
                        line = "\n>> Bernard (" + sdf.format(new Date()) + "): " + output1;
                        try {
                            chatTextPane.getDocument().insertString(chatTextPane.getDocument().getLength(),line, styleBot);
                        } catch (BadLocationException exc) {
                            exc.printStackTrace();
                        }
                        inputTextArea.setText("");
                        return;
                    } catch (BadLocationException ex) {
                        ex.printStackTrace();
                    }

                    try{
                        output2 = ChatbotCore.getInstance().innerSendAndReceive();
                        line = "\n>> Bernard (" + sdf.format(new Date()) + "): " + output2;
                        chatTextPane.getDocument().insertString(chatTextPane.getDocument().getLength(),line, styleBot);
                    } catch (NoRulesException ex) {
                        output2 = ChatbotCore.getInstance().hacerRecomendacion();
                        line = "\n>> Bernard (" + sdf.format(new Date()) + "): " + output2;
                        try {
                            chatTextPane.getDocument().insertString(chatTextPane.getDocument().getLength(),line, styleBot);
                        } catch (BadLocationException exc) {
                            exc.printStackTrace();
                        }
                    } catch (BadLocationException ex) {
                        ex.printStackTrace();
                    }


                    inputTextArea.setText("");
                }

            }
        });

        clearButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                inputTextArea.setText("");
                chatTextPane.setText("");

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

                String line = "\n>> Bernard (" + sdf.format(new Date()) + "): " + output;
                try {
                    chatTextPane.getDocument().insertString(chatTextPane.getDocument().getLength(),line, styleBot);
                } catch (BadLocationException ex) {
                    ex.printStackTrace();
                }


                sendButton.setEnabled(false);
                recomendarButton.setEnabled(false);
            }
        });

        sendButton.doClick();

    }

}
