package course_project;

import java.util.Random;
import java.util.Scanner;

public class Game {
    private static boolean isFinish = false;
    private static GameField additionalFieldForComp;
    private static GameField additionalFieldForHuman;
    private static final String ERROR_MESSAGE = "Input must contain letter from A to J and number from 1 to 10 without a space, please try again:";

    public void run() {
        System.out.println("Hey! Mr computer invites you to play sea battle! The ships are already positioned across the field.\n" +
                "Shoot and hit enemy ships. If you shoot successfully, you can shoot again, and the enemy misses a turn. \n" +
                        "The game continues until one of the players (you or computer) shoot all the enemy ships. \n");

        Player human = new Player();
        Player comp = new Player();

        human.printField(comp);

        battle(human, comp);
    }

    public void battle(Player human, Player comp) {
        Scanner sc = new Scanner(System.in);
        additionalFieldForComp = new GameField(false);
        additionalFieldForHuman = new GameField(false);

        while (!isFinish) {
            boolean humanShotOnTarget = true;
            boolean compShotOnTarget = true;

            while (humanShotOnTarget) {
                System.out.println("\nEnter the coordinate of the opponent's field (for example A1):");
                int[] input = readInput(sc);
                int x = input[0];
                int y = input[1];

                humanShotOnTarget = changeCellStatus(x, y, comp);
                if (humanShotOnTarget) {
                    human.printField(comp);
                }

                if (checkFinishOfGame(comp.getNumHitCells(), human.getNumHitCells())) {
                    isFinish = true;
                    return;
                }
            }

            while (compShotOnTarget) {
                int[] enemyMove = enemyMove();
                int enemyX = enemyMove[0];
                int enemyY = enemyMove[1];

                compShotOnTarget = changeCellStatus(enemyX, enemyY, human);
                if (checkFinishOfGame(comp.getNumHitCells(), human.getNumHitCells())) {
                    isFinish = true;
                    return;
                }
            }

            human.printField(comp);
        }
    }

    private int[] enemyMove() {
        boolean shot = false;
        int x = 0, y = 0;
        while (!shot) {
            x = new Random().nextInt(9)+1;
            y = new Random().nextInt(9)+1;

            if (additionalFieldForComp.cells[x][y] == GameField.CellStatus.FREE) {
                additionalFieldForComp.cells[x][y] = GameField.CellStatus.FILLED;
                shot = true;
            }
        }

        return new int[]{x, y};
    }

    private boolean checkFinishOfGame(int compNumHitCells, int humanNumHitCells) {
        if (humanNumHitCells == 20) {
            System.out.println("Computer is winner! Don't be upset, you are great too!");
            return true;
        } else if (compNumHitCells == 20) {
            System.out.println("You are winner! Congratulations!");
            return true;
        }
        return false;
    }

    private boolean changeCellStatus(int x, int y, Player player) {
        boolean shotOnTarget = false;
        if (player.getField().cells[x][y] == GameField.CellStatus.FREE) {
            player.getField().cells[x][y] = GameField.CellStatus.FAULT;
            shotOnTarget = false;
        } else if (player.getField().cells[x][y] == GameField.CellStatus.SHIP) {
            player.getField().cells[x][y] = GameField.CellStatus.HIT;
            shotOnTarget = true;
            player.increaseNumHitCells();
        }

        return shotOnTarget;
    }

    public static int[] readInput(Scanner sc) {

        int[] input = new int[2];
        boolean correctInput = false;

        boolean shot = false;
        while (!shot) {
            String str = sc.nextLine();
            correctInput = checkingCorrectInput(str);

            if (correctInput) {
                input[0] = convertX(str.substring(0,1));
                input[1] = Integer.parseInt(str.substring(1));

                if (additionalFieldForHuman.cells[input[0]][input[1]] == GameField.CellStatus.FREE) {
                    additionalFieldForHuman.cells[input[0]][input[1]] = GameField.CellStatus.FILLED;
                    shot = true;
                } else {
                    System.out.println("You've already shot this cage. Enter coordinate of free cell:");
                    shot = false;
                }
            } else System.out.println(ERROR_MESSAGE);
        }

        return input;
    }

    public static boolean checkingCorrectInput(String str) {
        int[] input = new int[2];
        boolean correctInput = false;
        if (str.length() < 2 || str.length() > 3) {
            return false;
        }

        if (str.substring(0,1).matches("[A-J]") && str.substring(1).matches("[0-9]{1,2}")) {
            try {
                input[1] = Integer.parseInt(str.substring(1));
                if (input[1] > 0 && input[1] < 11)
                    correctInput = true;
            } catch (NumberFormatException ex) {
                correctInput = false;
            }
        } else {
            correctInput = false;
        }

        return correctInput;
    }

    public static int convertX(String s) {
        switch (s) {
            case ("A"):
                return 1;
            case ("B"):
                return 2;
            case ("C"):
                return 3;
            case ("D"):
                return 4;
            case ("E"):
                return 5;
            case ("F"):
                return 6;
            case ("G"):
                return 7;
            case ("H"):
                return 8;
            case ("I"):
                return 9;
            case ("J"):
                return 10;
        }

        return 0;
    }
}
