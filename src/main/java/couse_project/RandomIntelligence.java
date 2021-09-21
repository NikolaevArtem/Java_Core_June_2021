package couse_project;

import java.util.Random;

public class RandomIntelligence {
    private SeaMap map;
    private final SeaMap radar;

    public RandomIntelligence(SeaMap map, SeaMap radar) {
        this.map = map;
        this.radar = radar;
    }

    public boolean shoot() {
        Random random = new Random();
        int x = random.nextInt(10);
        int y = random.nextInt(10);

        if (radar.isFreeEnterCell(x, y)) {
            return radar.registerShot(x, y);
        }

        shoot();
        return false;
    }
}
