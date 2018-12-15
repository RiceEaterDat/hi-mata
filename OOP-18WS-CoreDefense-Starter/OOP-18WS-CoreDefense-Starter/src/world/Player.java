package world;

import de.ur.mi.geom.Point;
import de.ur.mi.graphics.*;

import world.Constants;

public class Player {

    private Ellipse player;
    private Point orbitCenter;
    private double angle;
    private double range;

    private

    public Player(/* insert parameters here */) {
    }

    public void update() {
        updateAngle();
        updateRange();
        updatePosition();
    }


    public void draw() {
        //player.draw();
    }

    public void setOrbitMovementType( MovementType ORBIT_NONE, MovementType CLOCKWISE, MovementType COUNTER_CLOCKWISE ) {
        switch(OrbitMovementType) {

            break;
        }
    }

    public void setRangeMovementType(/* MovementType type */) {
    }

    public boolean collidesWith(Projectile projectile) {
        return false;
    }

    ///////////////////////////////////////////////////////////////////////////

    private void updateAngle() {
    }

    private void updateRange() {
    }

    private Point calculateOrbitPosition(Point orbitCenter, double distanceFromCenter, double orbitAngle) {
        double newX = orbitCenter.getX() + distanceFromCenter * Math.cos(Math.toRadians(orbitAngle));
        double newY = orbitCenter.getY() + distanceFromCenter * Math.sin(Math.toRadians(orbitAngle));
        return new Point(newX, newY);
    }

    private void updatePosition() {
    }
}
