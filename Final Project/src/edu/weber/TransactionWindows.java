package edu.weber;

import com.sun.prism.paint.Color;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import static com.sun.glass.ui.Cursor.setVisible;
import static com.sun.javafx.fxml.expression.Expression.add;

public class TransactionWindows extends JFrame {

    private JTextArea transactions;
    // create a ArrayList String type
    ArrayList<String> arrayTransactions = new ArrayList<String>();
    JTextArea textArea = new JTextArea(10,20);
    // create a toolbar
    JToolBar toolBar = new JToolBar();
    // create a panel
    JPanel panel = new JPanel();
    // buttons
    JButton b1 = new JButton("Down");
    JButton b2 = new JButton("Up");



    public TransactionWindows(AccountHolder accountHolder)
    {
        // transactions = new JTextArea();
        arrayTransactions=  accountHolder.getTransaction();
        for (int i = 0; i <arrayTransactions.size() ; i++) {
            textArea.append(String.valueOf(arrayTransactions.get(i))+"\n");

        }
        //***********************button1***************************
        b1.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                //your actions
            }
        });



        // add buttons
        panel.add(b1);
        panel.add(b2);
        toolBar.add(panel);
        add(toolBar,BorderLayout.NORTH);
        add(textArea, BorderLayout.CENTER);
        setSize(600, 500);
        setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        setVisible(true);
    }


}