package edu.weber;

import javafx.scene.control.ToolBar;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainFrame extends JFrame {

    private JButton button;
    private TextPanel textArea;
    private Toolbar toolBar;
    private FormPanel formPanel;

    public MainFrame()
    {
        super("Hello World!");
        setLayout(new BorderLayout());

        button = new JButton("Click Me");
        textArea = new TextPanel();
        toolBar = new Toolbar();
        formPanel = new FormPanel();

        toolBar.setStringListener(new StringListener() {
            @Override
            public void textEmitted(String text) {
                textArea.appendText(text);
            }
        });

        formPanel.setFormListener(new FormListener() {
            @Override
            public void formEventOccured(FormEvent e) {
                String name = e.getName();
                String occupation = e.getOccupation();
                textArea.appendText(name + ": " + occupation + "\n");
            }
        });

        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                textArea.appendText("Hello\n");
            }
        });

        add(textArea, BorderLayout.CENTER);
        add(button, BorderLayout.SOUTH);
        add(toolBar, BorderLayout.NORTH);
        add(formPanel, BorderLayout.WEST);

        setSize(600, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

}
