import de.ur.mi.graphics.Color;
import de.ur.mi.graphicsapp.GraphicsApp;
import game.GameManager;

import java.awt.event.KeyEvent;

import world.Constants;

public class CoreDefense extends GraphicsApp {

    private GameManager gameManager;

    public void setup() {
        setupCanvas();
        setupGame();
    }

    private void setupGame() {
        gameManager = new GameManager();
    }

    private void setupCanvas() {
        size(Constants.WIDTH, Constants.HEIGHT);
        frameRate(Constants.FRAMERATE);
    }

    public void draw() {
        background(Color.BLACK);
        gameManager.update();
        gameManager.draw();
    }

    public void keyPressed(KeyEvent e) {
        // translate key presses into input commands for the game manager
    }

    public void keyReleased(KeyEvent e) {
        // translate key presses into input commands for the game manager
    }
}
