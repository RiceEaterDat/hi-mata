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

        //TODO: Change 10 to be with respect to level
        //TODO: change speed to be with respect to level
        for (int i = 0; i < 2; i++) {

            double radius = random.nextDouble() * (2*Math.PI);

            double x = Constants.SPAWN_RADIUS * Math.cos(radius) + Constants.CANVAS_CENTER_X;
            double y = Constants.SPAWN_RADIUS * Math.sin(radius) + Constants.CANVAS_CENTER_Y;

            queue.add(new Projectile(25, x, y));

        }

    }

    public List<Projectile> getProjectiles() {
        return queue;
    }
}
