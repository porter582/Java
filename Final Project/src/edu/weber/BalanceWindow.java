package edu.weber;

import javax.swing.*;
import java.awt.*;

public class BalanceWindow extends JFrame {

    private JLabel balanceLabel;
    private String sBalance;

    public BalanceWindow(AccountHolder accountHolder)
    {
        super("Balance for: " + accountHolder.getAccountNumber());

        sBalance = Double.toString(accountHolder.getBalance());

        balanceLabel = new JLabel();
        balanceLabel.setText(sBalance);
        add(balanceLabel, BorderLayout.CENTER);
        setSize(600, 500);
        setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        setVisible(true);
    }

}