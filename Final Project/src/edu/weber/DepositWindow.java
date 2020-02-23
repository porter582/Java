package edu.weber;

import javax.swing.*;
import java.awt.*;

public class DepositWindow extends JFrame {


    public DepositWindow(AccountHolder accountHolder)
    {
        super("Deposit for: " + accountHolder.getAccountNumber());

        DepositPanel depositPanel = new DepositPanel(accountHolder);

        add(depositPanel, BorderLayout.CENTER);

        setSize(600, 500);
        setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        setVisible(true);
    }
}