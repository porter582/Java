package edu.weber;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class FormPanel extends JPanel {

    private JLabel accountNumber;
    private JTextField accountField;
    private JButton submitButton;
    private JButton newAccountButton;
    private FormListener formListener;
    private ArrayList<AccountHolder> listOfAccounts = new ArrayList<>(); //array list of accounts to be created
    private int iAccountNumber = 0;
    private boolean found = false;
    private AccountHolder accountHolder = new AccountHolder();

    public FormPanel()
    {
        AccountHolder customer1 = new AccountHolder();
        customer1.setAccountNumber(1);
        customer1.setFirstName("Porter");
        customer1.setLastName("Joe");
        customer1.deposit(52.3);
        //*************************************************this will create transactions for customer1*******************************
        for (int i = 0; i <30 ; i++) {
            customer1.setTransaction("2007-07-26","Walmart",12.9);
        }
        listOfAccounts.add(customer1);


        AccountHolder customer2 = new AccountHolder();
        customer2.setAccountNumber(10001);
        customer2.setFirstName("Joe");
        customer2.setLastName("Shmoe");
        customer2.deposit(500.00);
        //*************************************************this will create transactions for customer2*******************************
        for (int i = 0; i <56 ; i++) {
            customer2.setTransaction("2007-07-26","BigOTires",1222.9);
        }

        listOfAccounts.add(customer2);

        Dimension dim = getPreferredSize();
        dim.width = 250;
        setPreferredSize(dim);

        accountNumber = new JLabel("Account Number: ");
        accountField = new JTextField(10);
        submitButton = new JButton("Submit");
        newAccountButton = new JButton("New Account");

        submitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String accountNumber = accountField.getText();
                iAccountNumber = Integer.parseInt(accountNumber);

                for (int i = 0; i < listOfAccounts.size(); i++) { //for loop used to find account in listOfAccounts
                    if (listOfAccounts.get(i).getAccountNumber() == iAccountNumber) {
                        found = true;
                        accountHolder = listOfAccounts.get(i);
                        break;
                    }
                }

                if(found)
                {
                    new AccountFrame(accountHolder, listOfAccounts);

                }
                FormEvent event = new FormEvent(this, accountNumber);
                if(formListener != null)
                {
                    formListener.formEventOccured(event);
                }
            }
        });

        newAccountButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                NewAccountWindow newAccountWindow = new NewAccountWindow(listOfAccounts);
                newAccountWindow.show();
            }
        });


        Border innerBorder = BorderFactory.createTitledBorder("Main Menu: ");

        Border outerBorder = BorderFactory.createEmptyBorder(5,5,5,5);
        setBorder(BorderFactory.createCompoundBorder(innerBorder, outerBorder));

        setLayout(new GridBagLayout());
        GridBagConstraints gc = new GridBagConstraints();

        /*********** first row ****************/
        gc.weightx = 1; //weights control how much space it takes up relative to other cells
        gc.weighty = .1;

        gc.gridx = 0;
        gc.gridy = 0;

        gc.fill = GridBagConstraints.NONE;
        gc.anchor = GridBagConstraints.LINE_END;
        gc.insets = new Insets(0,0,0,5);
        add(accountNumber, gc);

        gc.gridx = 1;
        gc.gridy = 0;
        gc.insets = new Insets(0,0,0,0);
        gc.anchor = GridBagConstraints.LINE_START;

        add(accountField, gc);

        /*********** second row ***************/
        gc.weightx = 1;
        gc.weightx = .1;

        gc.gridx = 0;
        gc.gridy = 1;
        gc.insets = new Insets(0,0,0,5);
        gc.anchor = GridBagConstraints.LINE_END;
        //add(occupationLabel, gc);

        gc.gridx = 1;
        gc.gridy = 1;
        gc.insets = new Insets(0,0,0,0);
        gc.anchor = GridBagConstraints.LINE_START;
        add(submitButton, gc);

        /*********** third row ****************/
        gc.weightx = 1;
        gc.weighty = 2;

        gc.gridx = 1;
        gc.gridy = 2;
        gc.insets = new Insets(0,0,0,0);
        gc.anchor = GridBagConstraints.FIRST_LINE_START;
        add(newAccountButton, gc);

    }
}