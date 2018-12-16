package world;

import de.ur.mi.graphics.Color;
import de.ur.mi.graphics.Label;
import de.ur.mi.graphics.Rect;

public class Informationbar {
    private int points;
    private int lives;
    private int level;
    private Label point;
    private Label live;
    private Label lvl;
    private Rect infoRect;

    public Informationbar(int points, int lives, int level) {
        this.points = points;
        this.lives = lives;
        this.level = level;
        infoRect = new Rect(0, 0, 800, 50, Color.LIGHT_GRAY);
        point = new Label(10, 30, "Points: " + points, Color.BLACK, 24);
        live = new Label(200, 30, "Lives: " + lives, Color.BLACK, 24);
        lvl = new Label(650, 30, "Level: " + level, Color.BLACK, 24);
    }

    public void draw() {
        infoRect.draw();
        point.draw();
        live.draw();
        lvl.draw();
    }


    public void updatePoints() {
        point.setText("Points: " + (++this.points));
    }

    public void updateLives() {
        this.lives--;
        live.setText("Lives: " + this.lives);

    }

    public void setLevel(int level) {
        this.level = level;
    }
}
