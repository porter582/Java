package edu.weber;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class AccountFormPanel extends JPanel {

    private JButton depositButton;
    private JButton withdrawButton;
    private JButton balanceButton;
    private JButton transactionButton;
    private JButton transferToDiffAccountButton;


    public AccountFormPanel(AccountHolder accountHolder, ArrayList<AccountHolder> listOfAccounts)
    {
        depositButton = new JButton("Deposit");
        withdrawButton = new JButton("Withdraw");
        balanceButton = new JButton("Balance");
        transactionButton = new JButton("Transactions");
        transferToDiffAccountButton = new JButton("Transfer");

        depositButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                DepositWindow depositWindow = new DepositWindow(accountHolder);
                depositWindow.show();
            }
        });

        withdrawButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                WithdrawWindow withdrawWindow = new WithdrawWindow(accountHolder);
                withdrawWindow.show();
            }
        });

        balanceButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                BalanceWindow balanceWindow = new BalanceWindow(accountHolder);
                balanceWindow.show();
            }

        });
        transactionButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                TransactionWindows transaction = new TransactionWindows(accountHolder);
                transaction.show();
            }

        });

        transferToDiffAccountButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                TransferFrame transferFrame = new TransferFrame(accountHolder, listOfAccounts);
                transferFrame.show();
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
        add(depositButton, gc);

        gc.gridx = 1;
        gc.gridy = 0;
        gc.insets = new Insets(0,0,0,0);
        gc.anchor = GridBagConstraints.LINE_START;

        add(withdrawButton, gc);

        /*********** second row ***************/
        gc.weightx = 1;
        gc.weightx = .1;

        gc.gridx = 0;
        gc.gridy = 1;
        gc.insets = new Insets(0,0,0,5);
        gc.anchor = GridBagConstraints.LINE_END;
        add(transactionButton, gc);

        gc.gridx = 1;
        gc.gridy = 1;
        gc.insets = new Insets(0,0,0,0);
        gc.anchor = GridBagConstraints.LINE_START;
        add(balanceButton, gc);

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