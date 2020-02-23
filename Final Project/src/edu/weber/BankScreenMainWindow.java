package edu.weber;

import javax.swing.*;
import java.awt.*;

public class BankScreenMainWindow extends JFrame {

    private FormPanel formPanel;

    public BankScreenMainWindow()
    {
        super("Bank Program");
        setLayout(new BorderLayout());
        formPanel = new FormPanel();

        add(formPanel, BorderLayout.CENTER);

        setSize(600, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }
}