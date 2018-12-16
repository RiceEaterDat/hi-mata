package world;

import de.ur.mi.graphics.Color;

public class Constants {

    //CoreDefense
    public static final int WIDTH = 800;
    public static final int HEIGHT = 800;
    public static final int FRAMERATE = 60;

    //Sky
    public static final int MAX_STARS = 50;
    public static final int MIN_STAR_WIDTH = 5;
    public static final int MAX_STAR_WIDTH = 10;

    //GameManager
    public static final int GAME_STATE_STARTED = 1;
    public static final int CANVAS_CENTER_X = 400;
    public static final int CANVAS_CENTER_Y = 400;

    //Core
    public static final int CORE_DIAMETER = 80;
    public static final Color CIRCLE_COLOR = Color.YELLOW;

    //Projectile
    public static final Color PROJECTILE_COLOR = Color.CYAN;
    public static final double SPAWN_RADIUS = 600;

    //Player
    public static final Color PLAYER_COLOR = Color.RED;
    public static final int PLAYER_THICKNESS = 10;
    public static final double ANGLE_SPEED = 0.1;
    public static final double RANGE_SPEED = 2;
    public static final double RANGE_START = 70;
    public static final double ANGLE_START = 0;
}
