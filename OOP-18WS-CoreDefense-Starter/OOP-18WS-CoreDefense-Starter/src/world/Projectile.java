package world;

import de.ur.mi.graphics.Ellipse;
import de.ur.mi.graphics.GraphicsObject;
import java.util.Random;

public class Projectile {
    private Ellipse projectile;

    private double speed;
    private double startX;
    private double startY;

    private double deltaX;
    private double deltaY;

    private int ticks = Constants.TICKS;


    public Projectile(double speed, double startX, double startY) {
        this.speed = speed/1e4;

        deltaX = Constants.CANVAS_CENTER_X - startX;
        deltaY = Constants.CANVAS_CENTER_Y - startY;

        this.startX = startX;
        this.startY = startY;

        Random random = new Random();

        int radius = Constants.MIN_PROJECTILE_RADIUS + random.nextInt(Constants.MAX_PROJECTILE_RADIUS);

        this.projectile = new Ellipse(startX, startY, radius , radius, Constants.PROJECTILE_COLOR);
    }

    public void update() {
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
        return object.distanceTo(projectile) <= getRadius() * Constants.HIT_DETECTION_TOLERANCE;
    }

    public double distanceTo(GraphicsObject graphicsObject) {
        return projectile.distanceTo(graphicsObject);
    }
}
