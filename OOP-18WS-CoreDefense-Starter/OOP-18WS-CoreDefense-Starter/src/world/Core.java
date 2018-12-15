package world;
import de.ur.mi.graphics.Ellipse;

public class Core {


    public void draw() {
        Ellipse core = new Ellipse(Constants.CANVAS_CENTER_X, Constants.CANVAS_CENTER_Y, Constants.CORE_DIAMETER, Constants.CORE_DIAMETER, Constants.CIRCLE_COLOR);
        core.draw();
    }

    public boolean collidesWith(Projectile projectile) {
        // TODO implement collision detection
        // projectile.
        return false;
    }
}
