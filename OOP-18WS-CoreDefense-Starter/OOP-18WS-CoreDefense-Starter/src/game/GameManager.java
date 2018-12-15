package game;

import de.ur.mi.geom.Point;
import world.Constants;
import world.Player;
import world.Sky;
import world.Core;

public class GameManager {


    private Player player;
    private Sky sky = new Sky();
    private Core core = new Core();

    private int gameState = Constants.GAME_STATE_STARTED;

    public GameManager() {
        setupGameObjects();
    }

    public void update() {
        sky.updateStars();
    }

    public void draw() {
        player.draw();
        sky.draw();
        core.draw();
    }

    public void transmitMovementCommand(/* MovementType type */) {
    }

    ///////////////////////////////////////////////////////////////////////////

    private void setupGameObjects() {
        Point orbitCenter = new Point(Constants.CANVAS_CENTER_X, Constants.CANVAS_CENTER_Y);

        player = new Player(/* insert parameters here */);
    }

    private void checkAndHandleCollision() {
    }

}
