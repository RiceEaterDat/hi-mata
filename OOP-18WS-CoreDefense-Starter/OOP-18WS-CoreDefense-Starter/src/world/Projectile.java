package world;

import com.sun.xml.internal.bind.v2.runtime.reflect.opt.Const;
import de.ur.mi.geom.Point;
import de.ur.mi.graphics.Color;
import de.ur.mi.graphics.Ellipse;
import de.ur.mi.graphics.GraphicsObject;
import de.ur.mi.graphics.Line;

import java.util.Random;

public class Projectile {
    private Ellipse projectile;

    private double speed;
    private double startX;
    private double startY;

    private double deltaX;
    private double deltaY;

    private int ticks = 0;

    private boolean debug = true;

    private Line l;

    public Projectile(double speed, double startX, double startY) {
        this.speed = speed/1e4;

        deltaX = Constants.CANVAS_CENTER_X - startX;
        deltaY = Constants.CANVAS_CENTER_Y - startY;

        this.startX = startX;
        this.startY = startY;
        l = new Line(startX, startY, -startX+2*Constants.CANVAS_CENTER_X, -startY+2*Constants.CANVAS_CENTER_Y, Color.RED);
        Random r = new Random();
        int radius = r.nextInt(20);

        this.projectile = new Ellipse(startX, startY, radius , radius, Constants.PROJECTILE_COLOR);
    }

    public void update() {
        double newX = startX + deltaX * ticks * speed;
        double newY = startY + deltaY * ticks * speed;
        projectile.setPosition(newX, newY);
        ticks++;

    }

    public void draw() {
        if (debug) l.draw();
        projectile.draw();
    }

    public double getRadius() {
        return projectile.getWidth()/2.0;
    }

    public boolean hitTest(double x, double y) {
        double deltaY = projectile.getX() - Constants.CANVAS_CENTER_X;
        double deltaX = projectile.getY() - Constants.CANVAS_CENTER_Y;

        return Math.sqrt(Math.pow(deltaX,2) + Math.pow(deltaY, 2)) > getRadius();
    }

    public double distanceTo(GraphicsObject graphicsObject) {
        return projectile.distanceTo(graphicsObject);
    }
}
