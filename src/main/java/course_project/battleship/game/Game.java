package course_project.battleship.game;


import course_project.battleship.controller.HumanController;
import course_project.battleship.controller.PlayerController;
import course_project.battleship.player.Human;
import course_project.battleship.player.Player;
import course_project.battleship.utils.Menu;

import java.util.Scanner;

public class Game {
    private final GameMode gameMode = new GameMode();
    private static final Scanner scanner = new Scanner(System.in);

    public void run() {
        System.out.println("----------SeaBattle---------");
        System.out.println("Choose Mode\n1. PvP\n2. PvE");

        int mode = Menu.getInt(2);
        if (mode == 1) {
            gameMode.setMode(GameMode.Mode.PVP);
        } else {
            gameMode.setMode(GameMode.Mode.PVE);
        }
        startGame();
    }

    public void startGame() {
        if (gameMode.getMode() == GameMode.Mode.PVP) {
            playVsHuman();
        } else {
            playVsComputer();
        }
    }

    private void playVsHuman() {
        System.out.println("Player 1, please, enter your name:");
        String playerName1 = scanner.nextLine();
        Player player1 = new Human(playerName1);
        System.out.println("Player 2, please, enter your name:");
        String playerName2 = scanner.nextLine();
        Player player2 = new Human(playerName2);

        System.out.println("-----------------------------");

        PlayerController playerController = new HumanController();
        playerController.placeShips(player1);
        playerController.placeShips(player2);

        String winner;

        while (true) {
            playerController.makeTurns(player1, player2);
            if (GameRule.isWinCondition(player1)) {
                winner = player1.getName();
                break;
            }
            playerController.makeTurns(player2, player1);
            if (GameRule.isWinCondition(player2)) {
                winner = player1.getName();
                break;
            }
        }
        System.out.println(winner + " win this game!");
    }

    public void playVsComputer() {
        throw new UnsupportedOperationException();
    }
}


