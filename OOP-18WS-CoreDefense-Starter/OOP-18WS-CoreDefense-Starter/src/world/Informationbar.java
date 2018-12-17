package world;

import de.ur.mi.events.Event;
import de.ur.mi.graphics.Color;
import de.ur.mi.graphics.GraphicsObject;
import de.ur.mi.graphics.Label;
import de.ur.mi.graphics.Rect;
import de.ur.mi.graphics.events.MouseEvent;
import de.ur.mi.graphicsapp.GraphicsApp;

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
        point.setText((++this.points) + " Points");
    }

    public int updateLives() {
        this.lives--;
        live.setText(this.lives + " Lives");
        return this.lives;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public void renderGameOver() {
        new Rect(200, 300, 300, 200, Color.LIGHT_GRAY).draw();
        if (this.lives != 0) {
            new Label(210, 350, "Congratulations", Color.BLACK, 32).draw();
        } else {
            new Label(210, 350, "Game Over", Color.BLACK, 32).draw();
        }
        new Label(210, 450, "Final Points: " + this.points, Color.BLACK, 32).draw();
    }

}


