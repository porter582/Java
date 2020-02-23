package edu.weber;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class TransferPanel extends JPanel {

    private JLabel accountToTransfer;
    private JTextField accountToTransferTextBox;
    private JTextField amountBox;
    private JButton transferToDiffAccountButton;
    private double amount;
    private int accountNumber;


    public TransferPanel(AccountHolder accountHolder, ArrayList<AccountHolder> listOfAccounts)
    {
        accountToTransfer = new JLabel("Account to transfer to: ");
        accountToTransferTextBox = new JTextField();
        amountBox = new JTextField();
        transferToDiffAccountButton = new JButton("Transfer");

        transferToDiffAccountButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                amount = Double.parseDouble(amountBox.getText());
                accountHolder.withdraw(amount);
                accountNumber = Integer.parseInt(accountToTransferTextBox.getText());
                for(int i = 0; i < listOfAccounts.size(); i++)
                {
                    if(accountNumber == listOfAccounts.get(i).getAccountNumber())
                    {
                        listOfAccounts.get(i).deposit(amount);
                        break;
                    }
                }
            }

        });

        Border innerBorder = BorderFactory.createTitledBorder("Account Options: ");

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
        add(accountToTransfer, gc);

        gc.gridx = 1;
        gc.gridy = 0;
        gc.insets = new Insets(0,0,0,0);
        gc.anchor = GridBagConstraints.LINE_START;

        add(accountToTransferTextBox, gc);

        /*********** second row ***************/
        gc.weightx = 1;
        gc.weightx = .1;

        gc.gridx = 0;
        gc.gridy = 1;
        gc.insets = new Insets(0,0,0,5);
        gc.anchor = GridBagConstraints.LINE_END;
        add(amountBox, gc);
//
//        gc.gridx = 1;
//        gc.gridy = 1;
//        gc.insets = new Insets(0,0,0,0);
//        gc.anchor = GridBagConstraints.LINE_START;
//        add(balanceButton, gc);

        /*********** third row ****************/
        gc.weightx = 1;
        gc.weighty = 2;

        gc.gridx = 1;
        gc.gridy = 2;
        gc.insets = new Insets(0,0,0,0);
        gc.anchor = GridBagConstraints.FIRST_LINE_START;
        add(transferToDiffAccountButton, gc);
    }
}