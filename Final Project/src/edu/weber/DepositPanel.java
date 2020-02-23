package edu.weber;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class DepositPanel extends JPanel {

    private JLabel label;
    private JButton button;
    private JTextField textField;
    private double amount;

    public DepositPanel(AccountHolder accountHolder)
    {
        label = new JLabel("Deposit Amount: ");
        textField = new JTextField();
        button = new JButton("Submit");

        Border innerBorder = BorderFactory.createTitledBorder("Account Options: ");

        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                amount = Double.parseDouble(textField.getText());
                Thread t = new Thread();
                accountHolder.deposit(amount);
                t.start();
                try {
                    t.join(60);
                } catch (InterruptedException c) {
                    c.printStackTrace();
                }
            }
        });

        Border outerBorder = BorderFactory.createEmptyBorder(10,10,10,20);
        setBorder(BorderFactory.createCompoundBorder(innerBorder, outerBorder));

        setLayout(new GridBagLayout());
        GridBagConstraints gc = new GridBagConstraints();

        /*********** first row ****************/
        gc.fill = GridBagConstraints.HORIZONTAL;
        gc.ipady = 0;       //reset to default
        gc.weighty = 0.20;   //request any extra vertical space
        gc.anchor = GridBagConstraints.FIRST_LINE_START; //bottom of space
        gc.insets = new Insets(10,0,0,0);  //top padding
        gc.gridx = 1;       //aligned with button 2
        gc.gridwidth = 2;   //2 columns wide
        gc.gridy = 1;       //third row
        add(textField, gc);

        /*********** second row ***************/
        gc.fill = GridBagConstraints.HORIZONTAL;
        gc.weightx = 1;
        gc.weightx = .1;

        gc.gridx = 0;
        gc.gridy = 2;
        gc.insets = new Insets(0,0,0,5);
        gc.anchor = GridBagConstraints.LINE_START;
        add(button, gc);
    }
}