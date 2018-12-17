import de.ur.mi.graphics.Color;
import de.ur.mi.graphicsapp.GraphicsApp;
import game.GameManager;

import java.awt.event.KeyEvent;

import world.Constants;
import world.MovementType;

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
        //left = 37
        //up = 38
        //right = 39
        //down = 40;
        switch(e.getKeyCode()) {
            case 37:
                gameManager.transmitMovementCommand(MovementType.COUNTER_CLOCKWISE);
                break;
            case 38:
                gameManager.transmitMovementCommand(MovementType.RANGE_UP);
                break;
            case 39:
                gameManager.transmitMovementCommand(MovementType.CLOCKWISE);
                break;
            case 40:
                gameManager.transmitMovementCommand(MovementType.RANGE_DOWN);
                break;
            case 82:
                if(Constants.GAME_STATE_STARTED != gameManager.getGameState()) {
                    //Resets the game
                    gameManager = new GameManager();
                }
            default:
                break;
        }
    }

    public void keyReleased(KeyEvent e) {
        // translate key presses into input commands for the game manager
        //left = 37
        //up = 38
        //right = 39
        //down = 40;
        switch(e.getKeyCode()) {
            case 37:
                gameManager.transmitMovementCommand(MovementType.ORBIT_NONE);
                break;
            case 38:
                gameManager.transmitMovementCommand(MovementType.RANGE_NONE);
                break;
            case 39:
                gameManager.transmitMovementCommand(MovementType.ORBIT_NONE);
                break;
            case 40:
                gameManager.transmitMovementCommand(MovementType.RANGE_NONE);
                break;
            default:
                break;
        }
    }
}
