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
        if (gameState != Constants.GAME_STATE_ENDED) {
            checkAndHandleCollision();
            player.update();
            currentProjectile.update();
            sky.updateStars();
        }
    }

    public void draw() {
        if (gameState != Constants.GAME_STATE_ENDED) {
            player.draw();
            sky.draw();
            core.draw();
            informationbar.draw();
            currentProjectile.draw();
        } else {
            sky.draw();
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

    private void setupGameObjects() {
        player = new Player();
        projectiles = new ProjectileGenerator().getProjectiles();
        currentProjectile = projectiles.get(0);
        informationbar = new Informationbar(Constants.STARTING_POINTS, Constants.STARTING_LIVES, Constants.STARTING_LEVEL);
    }

    private void checkAndHandleCollision() {
        if (projectiles.isEmpty()) {
            renderGameFinishScreen();
            gameState = Constants.GAME_STATE_ENDED;
            return;
        }

        if (core.collidesWith(currentProjectile)) {
            projectiles.remove(0);
            if (!projectiles.isEmpty()) {
                currentProjectile = projectiles.get(0);
            }
            if (informationbar.updateLives() == Constants.NO_LIVES_LEFT) {
                gameState = Constants.GAME_STATE_ENDED;
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
