package edu.weber;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class BallComponent extends JPanel {

    private ArrayList<Ball> balls = new ArrayList<>();

    public void add(Ball ball)
    {
        balls.add(ball);
    }

    public void paintComponent(Graphics g)
    {
        //erase background
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;
        for(Ball ball : balls)
        {
            g2d.fill(ball.getShape());
        }
    }
}
