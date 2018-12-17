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
    public static final int GAME_STATE_ENDED = 0;
    public static final int CANVAS_CENTER_X = 400;
    public static final int CANVAS_CENTER_Y = 400;
    public static final int STARTING_LIVES = 10;
    public static final int STARTING_LEVEL = 1;
    public static final int STARTING_POINTS = 0;
    public static final int NO_LIVES_LEFT = 0;

    //Core
    public static final int CORE_DIAMETER = 100;
    public static final Color CIRCLE_COLOR = Color.YELLOW;

    //Projectile
    public static final Color PROJECTILE_COLOR = Color.CYAN;
    public static final double SPAWN_RADIUS = 600;
    public static final int MAX_PROJECTILE_RADIUS = 35;
    public static final int MIN_PROJECTILE_RADIUS = 20;
    public static final int TICKS = 0;
    public static final double HIT_DETECTION_TOLERANCE = 1.1;

    //Player
    public static final Color PLAYER_COLOR = Color.RED;
    public static final int PLAYER_THICKNESS = 10;
    public static final double ANGLE_SPEED = 0.1;
    public static final double RANGE_SPEED = 2;
    public static final double RANGE_START = 70;
    public static final double ANGLE_START = 0;

    //ProjectileGenerator
    public static final int PROJECTILE_COUNT = 10;
    public static final double MAX_SPEED = 60;

    //Informationbar
    public static final int BAR_HEIGHT = 50;
    public static final Color RECT_COLOR = Color.TRANSPARENT;
    public static final Color LABEL_COLOR = Color.GREEN;
    public static final int FONT_SIZE = 24;
    public static final int GAME_OVER_RECT_X = 200;
    public static final int GAME_OVER_RECT_Y = 300;
    public static final int GAME_OVER_RECT_WIDTH = 300;
    public static final int GAME_OVER_RECT_HEIGHT = 300;
    public static final int GAMER_OVER_LABEL_X = 210;
    public static final int GAME_OVER_LABEL_Y = 350;
    public static final int YOU_SURVIVED_WITH_LABEL_Y = 400;
    public static final int YOU_KILLED_LABEL_Y = 450;
    public static final int RESTART_LABEL_Y = 520;
}
