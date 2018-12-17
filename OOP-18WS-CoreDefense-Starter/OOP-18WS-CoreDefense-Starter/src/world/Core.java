package world;
import de.ur.mi.graphics.Ellipse;

public class Core {

    Ellipse core;

    public Core() {
        this.core = new Ellipse(Constants.CANVAS_CENTER_X, Constants.CANVAS_CENTER_Y, Constants.CORE_DIAMETER, Constants.CORE_DIAMETER, Constants.CIRCLE_COLOR);
    }

    public void draw() {
        core.draw();
    }

    public boolean collidesWith(Projectile projectile) {
        return projectile.distanceTo(core) < Constants.CORE_DIAMETER * 0.75;
    }
}
