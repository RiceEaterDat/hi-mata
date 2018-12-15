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
    public static final int CORE_DIAMETER = 50;
    public static final Color CIRCLE_COLOR = Color.YELLOW;

    //Projectile
    public static final Color PROJECTILE_COLOR = Color.CYAN;

    //MovementType
    public static final int RANGE_NONE = 0;
    public static final int ORBIT_NONE = 1;
    public static final int CLOCKWISE = 2;
    public static final int COUNTER_CLOCKWISE = 3;
    public static final int RANGE_UP = 4;
    public static final int RANGE_DOWN = 5;
}
