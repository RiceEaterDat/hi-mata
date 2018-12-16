package world;

import de.ur.mi.geom.Point;
import de.ur.mi.graphics.*;

import static world.Constants.ANGLE_START;
import static world.Constants.RANGE_START;


public class Player {

    private Line player;
    private Point orbitCenter;
    private double angle;
    private double range;

    private MovementType orbitMovement;
    private MovementType orbitRange;


    public Player(/* insert parameters here */) {

        //X = radius * cos(angle) + Constants.CANVAS_CENTER_X;
        //Y = radius * sin(angle) + offset_y;
        this.range = RANGE_START;
        this.angle = ANGLE_START;
        this.orbitMovement = MovementType.ORBIT_NONE;
        this.orbitRange = MovementType.RANGE_NONE;

    }

    public void update() {

        updateAngle();
        updateRange();
        updatePosition();
    }


    public void draw() {
        //default : 0.01
        double increase = (Constants.RANGE_START / range) * 0.2;
        System.out.println(increase);
        Point start = new Point(range * Math.cos(angle - increase) + Constants.CANVAS_CENTER_X, range * Math.sin(angle - increase) + Constants.CANVAS_CENTER_Y);
        Point end = new Point(range * Math.cos(angle + increase) + Constants.CANVAS_CENTER_X, range * Math.sin(angle + increase) + Constants.CANVAS_CENTER_Y);
        Line player = new Line(start, end, Constants.PLAYER_COLOR);
        player.setBorderWeight(Constants.PLAYER_THICKNESS);
        player.draw();
    }

    public void setOrbitMovementType( MovementType type ) {
        this.orbitMovement = type;
    }

    public void setRangeMovementType(MovementType type) {
        this.orbitRange = type;
    }

    public boolean collidesWith(Projectile projectile) {
        return false;
    }

    ///////////////////////////////////////////////////////////////////////////

    private void updateAngle() {
        switch(this.orbitMovement) {
            case ORBIT_NONE:
                break;
            case CLOCKWISE:
                this.angle += Constants.ANGLE_SPEED;
                break;
            case COUNTER_CLOCKWISE:
                this.angle -= Constants.ANGLE_SPEED;
                break;
            default:
                break;
        }
    }

    private void updateRange() {
        switch(this.orbitRange) {
            case RANGE_NONE:
                break;
            case RANGE_DOWN:
                if (this.range > Constants.RANGE_START) this.range -= Constants.RANGE_SPEED;
                break;
            case RANGE_UP:
                this.range += Constants.RANGE_SPEED;
                break;
            default:
                break;
        }
    }

    private Point calculateOrbitPosition(Point orbitCenter, double distanceFromCenter, double orbitAngle) {
        double newX = orbitCenter.getX() + distanceFromCenter * Math.cos(Math.toRadians(orbitAngle));
        double newY = orbitCenter.getY() + distanceFromCenter * Math.sin(Math.toRadians(orbitAngle));
        return new Point(newX, newY);
    }

    private void updatePosition() {
    }
}
