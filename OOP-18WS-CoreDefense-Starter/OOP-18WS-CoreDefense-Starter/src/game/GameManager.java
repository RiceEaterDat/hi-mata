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
        sky.updateStars();
        player.update();

        currentProjectile.update();
        checkAndHandleCollision();
    }

    public void draw() {
        player.draw();
        sky.draw();
        core.draw();
        informationbar.draw();

        currentProjectile.draw();
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
        informationbar = new Informationbar(0, 10, 0);
    }

    private void checkAndHandleCollision() {

        if (projectiles.isEmpty() || projectiles.size() == 0) {
            System.out.println("Empty");
            return;
        }

        if (core.collidesWith(currentProjectile)) {

            projectiles.remove(0);
            currentProjectile = projectiles.get(0);
            informationbar.updateLives();
        }

        if (player.collidesWith(currentProjectile)) {

            projectiles.remove(0);
            currentProjectile = projectiles.get(0);
            informationbar.updatePoints();
        }


    }

    /*

    this.lives--;
        if (this.lives > 0) {
            live.setText("Lives: " + this.lives);
        } else {
            new Rect(300, 300, 200, 200, Color.LIGHT_GRAY).draw();
            new Label(350, 350, "Game Over", Color.BLACK, 32).draw();
            new Label(350, 450, "Final Points: " + this.points, Color.BLACK, 32).draw();
        }

     */

}
