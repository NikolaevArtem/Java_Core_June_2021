package course_project.service;

import course_project.model.Battlefield;
import course_project.model.Player;

import java.io.IOException;
import java.util.Scanner;

public class Runner {
    public void run() {
        Player a, b, c;
        boolean win;
        boolean enteredFirst = false;
        boolean enteredSecond = false;
        Scanner readIt = new Scanner(System.in);

        Player player1 = new Player();
        Player player2 = new Player();
        Battlefield battlefieldOne = new Battlefield();
        Battlefield battlefieldTwo = new Battlefield();
        BattleFieldService playerOneBattlefieldService = new BattleFieldService(battlefieldOne);
        BattleFieldService playerTwoBattlefieldService = new BattleFieldService(battlefieldTwo);
        PlayerService playerServiceOne = new PlayerService(player1, playerOneBattlefieldService);
        PlayerService playerServiceTwo = new PlayerService(player2, playerTwoBattlefieldService);
        System.out.println("Enter name of the first player");
        player1.setName(readIt.nextLine());
        while (!enteredFirst) {
            System.out.println("Choose ship placement mode: auto or manual");
            String modeFirst = readIt.nextLine();
            if (modeFirst.equalsIgnoreCase("auto")) {
                playerOneBattlefieldService.autoShipPlacement(player1);
                enteredFirst = true;
            } else if (modeFirst.equalsIgnoreCase("manual")) {
                playerOneBattlefieldService.arrangement(player1, readIt);
                enteredFirst = true;
            }
        }

        System.out.println("Enter name of the second player");
        player2.setName(readIt.nextLine());
        while (!enteredSecond) {
            System.out.println("Choose ship placement mode: auto or manual");
            String modeSecond = readIt.nextLine();
            if (modeSecond.equalsIgnoreCase("auto")) {
                playerTwoBattlefieldService.autoShipPlacement(player2);
                enteredSecond = true;
            } else if (modeSecond.equalsIgnoreCase("manual")) {
                playerTwoBattlefieldService.arrangement(player2, readIt);
                enteredSecond = true;
            }
        }

        int first = (int) (Math.random() * 2);
        if (first == 0) {
            a = player1;
            b = player2;
        } else {
            a = player2;
            b = player1;
        }
        System.out.println("Players have put their ships. Let the battle begin!\n Player  " + a.getName() + " starts");

        do {
            while (true) {
                try {
                    win = playerServiceOne.makeShot(a, b, readIt);
                    break;
                } catch (IOException e) {
                    System.out.println(a.getName() + ", enter coordinates in format \"A1\"");
                }
            }
            c = a;
            a = b;
            b = c;
        } while (!win);

        System.out.println("Game is over!");

        readIt.close();
    }

}

