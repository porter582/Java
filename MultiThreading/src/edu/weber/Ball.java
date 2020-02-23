package edu.weber;

import java.awt.geom.Ellipse2D;
import java.awt.geom.Rectangle2D;

public class Ball {

    private double x = 0.0;
    private double y = 0.0;
    private double dx = 1.0;
    private double dy = 1.0;

    private static final int XSIZE = 15;
    private static final int YSIZE = 15;

    public void move(Rectangle2D bounds)
    {
        x += dx;
        y += dy;

        if(x < bounds.getMinX())
        {
            dx = -dx;
            x = bounds.getMinX();
        }

        if(x + XSIZE > bounds.getMaxX())
        {
            dx = -dx;
            x = bounds.getMaxX() - XSIZE;
        }

        if(y < bounds.getMinY())
        {
            dy = -dy;
            y = bounds.getMinY();
        }

        if(y + YSIZE > bounds.getMaxY())
        {
            dy = -dy;
            y = bounds.getMaxY() - YSIZE;
        }
    }

    public Ellipse2D getShape()
    {
        return new Ellipse2D.Double(x, y, XSIZE, YSIZE);
    }

}
