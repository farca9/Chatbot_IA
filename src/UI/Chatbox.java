package UI;

import Core.ChatbotCore;
import sun.java2d.pipe.SpanShapeRenderer;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Chatbox {
    private JButton sendButton;
    private JTextArea inputTextArea;
    private JTextArea chatTextArea;
    public JPanel mainPanel;
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
                inputTextArea.setText("");

                chatTextArea.append("\n<< You ("+sdf.format(new Date())+"): "+input+"\n");

                input=input.toLowerCase();
                output = ChatbotCore.getInstance().sendAndReceive(input);

                chatTextArea.append("\n>> Bot ("+sdf.format(new Date())+"): "+output+"\n");

            }
        });

    }

}
