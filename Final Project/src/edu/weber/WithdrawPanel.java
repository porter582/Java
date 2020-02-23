package edu.weber;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class WithdrawPanel extends JPanel {

    private JLabel label;
    private JButton button;
    private JTextField textField;
    private double amount;


    public WithdrawPanel(AccountHolder accountHolder)
    {
        label = new JLabel("Withdraw Amount: ");
        textField  = new JTextField(10);
        button = new JButton("Submit");

        Border innerBorder = BorderFactory.createTitledBorder("Account Options: ");

        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                amount = Double.parseDouble(textField.getText());
                Thread t = new Thread();
                accountHolder.withdraw(amount);
                t.start();
                try {
                    t.join(60);
                } catch (InterruptedException c) {
                    c.printStackTrace();
                }
            }
        });


        Border outerBorder = BorderFactory.createEmptyBorder();
        setBorder(BorderFactory.createCompoundBorder(innerBorder, outerBorder));

        setLayout(new GridBagLayout());
        GridBagConstraints gc = new GridBagConstraints();

        /*********** first row ****************/
        gc.fill = GridBagConstraints.HORIZONTAL;
        gc.ipady = 0;       //reset to default
        gc.weighty = 0.20;   //request any extra vertical space
        gc.anchor = GridBagConstraints.FIRST_LINE_START; //bottom of space
        gc.insets = new Insets(10,100,0,100);  //top padding
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
        gc.insets = new Insets(10,100,0,100);  //top padding
        gc.anchor = GridBagConstraints.LINE_START;
        add(button, gc);
    }
}
