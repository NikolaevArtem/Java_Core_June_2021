package course_project.seaBattle;


import java.util.Random;
import java.util.Scanner;

import static course_project.seaBattle.Field.*;
import static course_project.seaBattle.Field.computerShip;
import static course_project.seaBattle.Ship.*;

public class Game {
    Scanner scanner = new Scanner(System.in);
    Random rand = new Random();

    private static boolean checkWin(int playerShip, int computerShip) {
        if (playerShip == 0) {
            System.out.println("Computer win -_-");
            return false;
        } else if (computerShip == 0) {
            System.out.println("You win!!");
            return false;
        } else {
            return true;
        }
    }

    public void run() {
        System.out.println("Print your name");
        Player User = new Player(scanner.nextLine());
        course_project.seaBattle.Computer computer = new course_project.seaBattle.Computer("Computer");
        randomGenerateShip(player_field, rand);
        printAllMaps(User, computer);
        randomGenerateShip(computer_field, rand);
        System.out.println("Start game");
        do {
            playerShoot(scanner, computer_field);
            computerShoot(player_field, rand);
        }
        while (checkWin(playerShip, computerShip));
        System.out.println(" End ");
        System.out.println("if you like this game you can buy it for three hundred bucks");
    }
}