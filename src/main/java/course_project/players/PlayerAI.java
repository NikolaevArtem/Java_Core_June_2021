package course_project.players;

import course_project.field_components.Coordinate;

import java.util.Random;

public class PlayerAI extends Player {

    @Override
    public Coordinate move() {
        Random random = new Random(System.currentTimeMillis());
        return Coordinate.get(random.nextInt(10), random.nextInt(10));
    }
}
