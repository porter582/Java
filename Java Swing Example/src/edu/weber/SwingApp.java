package edu.weber;

import sun.applet.Main;

import javax.swing.*;

public class SwingApp {

    public static void main(String[] args) {

        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {

                new MainFrame();

//                JFrame frame = new JFrame("Hello World!");
//                frame.setSize(600, 500);
//                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//                frame.setVisible(true);
            }
        });


    }
}