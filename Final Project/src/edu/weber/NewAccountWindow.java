package edu.weber;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class NewAccountWindow extends JFrame {

    public NewAccountWindow(ArrayList<AccountHolder> listOfAccounts)
    {
        super("New Account");

        NewAccountPanel newAccountPanel = new NewAccountPanel(listOfAccounts);

        add(newAccountPanel, BorderLayout.CENTER);

        setSize(600, 500);
        setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        setVisible(true);
    }
}
