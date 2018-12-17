package game;

import de.ur.mi.geom.Point;
import world.*;

import java.util.List;

public class GameManager {


    private Player player;
    private Sky sky = new Sky();
    private List<Projectile> projectiles;
    private Projectile currentProjectile;
    private Core core = new Core();
    private Informationbar informationbar;

    private int gameState = Constants.GAME_STATE_STARTED;

    public GameManager() {
        setupGameObjects();
    }

    public void update() {
        if (gameState != 0) {
            checkAndHandleCollision();
            player.update();
            currentProjectile.update();
            sky.updateStars();
        }
    }

    public void draw() {
        if (gameState != 0) {
            player.draw();
            sky.draw();
            core.draw();
            informationbar.draw();
            currentProjectile.draw();
        } else {
            renderGameFinishScreen();
        }
    }

    public void transmitMovementCommand(MovementType type) {
        if(type == MovementType.COUNTER_CLOCKWISE || type == MovementType.CLOCKWISE || type == MovementType.ORBIT_NONE) {
            player.setOrbitMovementType(type);
        } else {
            player.setRangeMovementType(type);
        }
    }

    ///////////////////////////////////////////////////////////////////////////

    private void setupGameObjects() {
        Point orbitCenter = new Point(Constants.CANVAS_CENTER_X, Constants.CANVAS_CENTER_Y);

        player = new Player(/* insert parameters here */);
        projectiles = new ProjectileGenerator().getProjectiles();
        currentProjectile = projectiles.get(0);
        informationbar = new Informationbar(0, 1, 0);
    }

    //Could actually change the list to be a dequeue and just Pop
    private void checkAndHandleCollision() {

        if (projectiles.isEmpty()) {
            currentProjectile.stopDrawing();
            renderGameFinishScreen();
            gameState = 0;
            return;
        }

        if (core.collidesWith(currentProjectile)) {

            projectiles.remove(0);
            if (!projectiles.isEmpty()) {
                currentProjectile = projectiles.get(0);
            }
            if (informationbar.updateLives() == 0) {
                gameState = 0;
            }
        }

        if (player.collidesWith(currentProjectile)) {

            projectiles.remove(0);
            if (!projectiles.isEmpty()) {
                currentProjectile = projectiles.get(0);
            }
            informationbar.updatePoints();
        }


    }

    private void renderGameFinishScreen() {
        informationbar.renderGameOver();
    }

    public int getGameState() {
        return gameState;
    }
}
