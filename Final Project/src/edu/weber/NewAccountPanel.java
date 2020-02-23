package edu.weber;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class NewAccountPanel extends JPanel {

    private JLabel label;
    private JButton button;
    private JTextField firstName;
    private JTextField lastName;
    private int newAccountNumber;

    public NewAccountPanel(ArrayList<AccountHolder> listOfAccounts)
    {

        for(int i = 0; i < listOfAccounts.size(); i++)
        {
            if(i == listOfAccounts.size() - 1)
            {
                newAccountNumber = listOfAccounts.get(i).getAccountNumber();
                newAccountNumber++;
            }
        }

        label = new JLabel("Account Number: " + newAccountNumber);
        firstName = new JTextField();
        lastName = new JTextField();
        button = new JButton("Submit");

        Border innerBorder = BorderFactory.createTitledBorder("Enter First Name and Last Name: ");

        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                AccountHolder accountHolder = new AccountHolder();
                accountHolder.setFirstName(firstName.toString());
                accountHolder.setLastName(lastName.toString());
                accountHolder.setAccountNumber(newAccountNumber);
                listOfAccounts.add(accountHolder);
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
        add(firstName, gc);

        /*********** second row ***************/
        gc.fill = GridBagConstraints.HORIZONTAL;
        gc.weightx = 1;
        gc.weightx = .1;

        gc.gridx = 0;
        gc.gridy = 2;
        gc.insets = new Insets(0,0,0,5);
        gc.anchor = GridBagConstraints.LINE_START;
        add(button, gc);
        /*********** third row ****************/
        gc.weightx = 1;
        gc.weighty = 2;

        gc.gridx = 1;
        gc.gridy = 2;
        gc.insets = new Insets(0,0,0,0);
        gc.anchor = GridBagConstraints.FIRST_LINE_START;
        add(lastName, gc);

        /***************************/
        gc.weightx = 1;
        gc.weighty = 2;

        gc.gridx = 1;
        gc.gridy = 3;
        gc.insets = new Insets(0,0,0,0);
        gc.anchor = GridBagConstraints.FIRST_LINE_START;
        add(label, gc);
    }
}
