package course_project.SeaBattle.Utility;

import course_project.SeaBattle.Models.Player;

import course_project.SeaBattle.Models.Square;

import java.util.Random;

public class Computer extends Player {

   private static final Random random = new Random();

    public static Square giveSquare() {
        return new Square(random.nextInt(10), random.nextInt(10), SquareStatus.SHIP);
    }

    public static int giveDirection() {
        return random.nextInt(2);
    }
}
