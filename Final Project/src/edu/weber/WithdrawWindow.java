package edu.weber;

import javax.swing.*;
import java.awt.*;

public class WithdrawWindow extends JFrame{
    //private FormPanel formPanel;

    public WithdrawWindow(AccountHolder accountHolder)
    {
        super("Withdraw for: " + accountHolder.getAccountNumber());
        setLayout(new BorderLayout());
        WithdrawPanel withdrawPanel = new WithdrawPanel(accountHolder);
        add(withdrawPanel, BorderLayout.CENTER);

        setSize(600, 500);
        setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        setVisible(true);
    }
}