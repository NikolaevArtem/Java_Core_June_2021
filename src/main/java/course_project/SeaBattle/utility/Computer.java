package course_project.SeaBattle.utility;

import course_project.SeaBattle.model.Player;

import course_project.SeaBattle.model.Square;
import course_project.SeaBattle.model.SquareType;

import java.util.Random;

public class Computer extends Player {

   private static final Random random = new Random();

    public static Square giveSquare() {
        return new Square(random.nextInt(10), random.nextInt(10), SquareType.SHIP);
    }

    public static int giveDirection() {
        return random.nextInt(2);
    }
}
