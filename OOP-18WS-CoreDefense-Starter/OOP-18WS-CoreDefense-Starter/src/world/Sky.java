package world;


import de.ur.mi.graphics.*;
import de.ur.mi.geom.*;
import de.ur.mi.util.*;

import java.util.Random;


public class Sky {


    private Image[] stars = new Image[Constants.MAX_STARS];
    private Projectile[] projectiles = new Projectile[5];
    private int callCount = 0;

    private RandomGenerator random;

    public Sky() {
        createStars();
        Random r = new Random();
        for (int i = 0; i < 5; i++) {
            projectiles[i] = new Projectile(20, 900, 200+(2*i*50));
        }
    }

    public void draw() {
        for (int i = 0; i < stars.length; i++) {
            stars[i].draw();
        }
        for (int i = 0; i < 5; i++) {
            projectiles[i].update();
            projectiles[i].draw();
        }
    }

    public void createStars() {
        for (int i = 0; i < Constants.MAX_STARS; i++) {
            random = RandomGenerator.getInstance();
            int diameter = random.nextInt(Constants.MIN_STAR_WIDTH, Constants.MAX_STAR_WIDTH);
            Point center = randomPoint(diameter);

            Image star = new Image(center, diameter, diameter, "data/assets/star.png");
            stars[i] = star;
        }
    }


    private Point randomPoint(int diameter) {
        int lowerX = diameter / 2;
        int upperX = Constants.WIDTH - diameter / 2;
        int lowerY = diameter / 2;
        int upperY = Constants.HEIGHT - diameter / 2;

        int x = random.nextInt(lowerX, upperX);
        int y = random.nextInt(lowerY, upperY);
        return new Point(x,y);
    }

    public void updateStars() {
        if (callCount % 80 == 0) {
            createStars();
        }
        callCount++;
        if (callCount > 59) {
            callCount = 0;
        }

    }
}
