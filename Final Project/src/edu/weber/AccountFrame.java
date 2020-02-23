package edu.weber;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class AccountFrame extends JFrame{

    public AccountFrame(AccountHolder accountHolder, ArrayList<AccountHolder> listOfAccounts)
    {
        super("Bank for: " + accountHolder.getAccountNumber() + " " + accountHolder.getFirstName().toString() + " " + accountHolder.getLastName().toString());

        AccountFormPanel accountFormPanel = new AccountFormPanel(accountHolder, listOfAccounts);
        add(accountFormPanel, BorderLayout.WEST);

        setSize(600, 500);
        setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        setVisible(true);
    }
}