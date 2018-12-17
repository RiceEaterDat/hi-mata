package world;

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
        infoRect = new Rect(0, 0, Constants.WIDTH, Constants.BAR_HEIGHT, Constants.RECT_COLOR);
        point = new Label(10, 30, points + " Points", Constants.LABEL_COLOR, Constants.FONT_SIZE);
        live = new Label(200, 30, lives + " Lives", Constants.LABEL_COLOR, Constants.FONT_SIZE);
        lvl = new Label(650, 30, "Level " + level, Constants.LABEL_COLOR, Constants.FONT_SIZE);
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
        new Rect(Constants.GAME_OVER_RECT_X, Constants.GAME_OVER_RECT_Y, Constants.GAME_OVER_RECT_WIDTH, Constants.GAME_OVER_RECT_HEIGHT, Constants.RECT_COLOR).draw();
        if (this.lives != 0) {
            new Label(Constants.GAMER_OVER_LABEL_X, Constants.GAME_OVER_LABEL_Y, "Congratulations!", Constants.LABEL_COLOR, Constants.FONT_SIZE).draw();
        } else {
            new Label(Constants.GAMER_OVER_LABEL_X, Constants.GAME_OVER_LABEL_Y, "Game Over", Constants.LABEL_COLOR, Constants.FONT_SIZE).draw();
        }
        new Label(Constants.GAMER_OVER_LABEL_X, Constants.YOU_SURVIVED_WITH_LABEL_Y, "You survived with " + this.lives + " live(s) left!", Constants.LABEL_COLOR, Constants.FONT_SIZE).draw();
        new Label(Constants.GAMER_OVER_LABEL_X, Constants.YOU_KILLED_LABEL_Y, "You killed " + this.points + " Projectile(s)!", Constants.LABEL_COLOR, Constants.FONT_SIZE).draw();
        new Label(Constants.GAMER_OVER_LABEL_X, Constants.RESTART_LABEL_Y, "Press (r) to restart the game", Constants.LABEL_COLOR, Constants.FONT_SIZE).draw();
    }
}


