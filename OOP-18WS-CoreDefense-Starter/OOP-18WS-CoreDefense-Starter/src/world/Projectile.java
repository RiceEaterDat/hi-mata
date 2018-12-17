package world;

import de.ur.mi.graphics.Ellipse;
import de.ur.mi.graphics.GraphicsObject;
import de.ur.mi.graphicsapp.GraphicsApp;

import javax.annotation.processing.SupportedSourceVersion;
import java.util.Random;

public class Projectile {
    private Ellipse projectile;

    private double speed;
    private double startX;
    private double startY;

    private double deltaX;
    private double deltaY;

    private int ticks = 0;
    private boolean shouldDraw;

    public Projectile(double speed, double startX, double startY) {
        this.speed = speed/1e4;

        deltaX = Constants.CANVAS_CENTER_X - startX;
        deltaY = Constants.CANVAS_CENTER_Y - startY;

        this.startX = startX;
        this.startY = startY;
        Random r = new Random();
        int radius = Constants.MIN_PROJECTILE_RADIUS + r.nextInt(Constants.MAX_PROJECTILE_RADIUS);

        this.projectile = new Ellipse(startX, startY, radius , radius, Constants.PROJECTILE_COLOR);

        this.shouldDraw = true;
    }

    public void update() {

        if (!shouldDraw) {
            return;
        }

        double newX = startX + deltaX * ticks * speed;
        double newY = startY + deltaY * ticks * speed;
        projectile.setPosition(newX, newY);
        ticks++;

    }

    public void draw() {
        projectile.draw();
    }

    public double getRadius() {
        return projectile.getWidth()/2.0;
    }

    public boolean hitTest(GraphicsObject object) {
        //return (Math.abs(this.projectile.getBottomBorder() - object.getTopBorder()) <= 1)
//                && object.getBottomBorder() <= this.projectile.getBottomBorder()
                //&& object.getRightBorder() >= this.projectile.getLeftBorder()
                //&& object.getLeftBorder() <= this.projectile.getRightBorder();
        return object.distanceTo(projectile) <= getRadius() * 1.1;
    }

    public double distanceTo(GraphicsObject graphicsObject) {
        return projectile.distanceTo(graphicsObject);
    }

    public void stopDrawing() {
        this.shouldDraw = false;
    }

    
}
