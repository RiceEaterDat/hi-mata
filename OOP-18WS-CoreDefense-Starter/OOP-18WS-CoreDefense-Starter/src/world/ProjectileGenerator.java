package world;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class ProjectileGenerator {

    List<Projectile> queue;
    Random random;

    public ProjectileGenerator() {
        this.queue = new ArrayList<>();
        random = new Random();
        generateLevel();
    }

    private void generateLevel() {
        for (int i = 0; i < Constants.PROJECTILE_COUNT; i++) {
            double radius = random.nextDouble() * (2*Math.PI);
            double speed = random.nextDouble() * Constants.MAX_SPEED + 1;

            double x = Constants.SPAWN_RADIUS * Math.cos(radius) + Constants.CANVAS_CENTER_X;
            double y = Constants.SPAWN_RADIUS * Math.sin(radius) + Constants.CANVAS_CENTER_Y;

            queue.add(new Projectile(speed, x, y));
        }

    }

    public List<Projectile> getProjectiles() {
        return queue;
    }
}
