package edu.weber;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class TransferFrame extends JFrame{

    public TransferFrame(AccountHolder accountHolder, ArrayList<AccountHolder> listOfAccounts)
    {
        super("Transfer from account: " + accountHolder.getAccountNumber());

        TransferPanel transferPanel = new TransferPanel(accountHolder, listOfAccounts);
        add(transferPanel, BorderLayout.WEST);

        setSize(600, 500);
        setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        setVisible(true);
    }
}