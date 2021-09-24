package course_project.seaBattle;

import java.util.Random;
import java.util.Scanner;

public class Field {
    public static final int SIZE = 10;
    public static char[][] player_field = new char[SIZE][SIZE];
    public static char[][] computer_field = new char[SIZE][SIZE];
    public static char[][] fake_field = new char[SIZE][SIZE];
    public static int playerShip = 20;
    public static int computerShip = 20;

    public static void printBattleField(char[][] field) {
        for (int i = 0; i < SIZE; i++) {
            if (i == 0) {
                for (int k = 0; k < SIZE; k++) {
                    System.out.print("\t" + k);
                }
                System.out.println();
            }
            System.out.print(i);
            for (int j = 0; j < SIZE; j++) {
                System.out.print("\t" + field[i][j]);
            }
            System.out.println();
        }
    }

    public static void printAllMaps(Player user, course_project.seaBattle.Computer computer) {
        System.out.print("\t=========" + user.getName() + "========");
        System.out.println("\t\t\t\t \t=======" + computer.getName() + "=======");
        System.out.print("  ");
        for (int i = 0; i < SIZE; i++) {
            System.out.print(i + "  ");
        }
        System.out.print("\t\t  ");
        for (int i = 0; i < SIZE; i++) {
            System.out.print(i + "  ");
        }

        System.out.print("\n");
        for (int i = 0; i < 10; i++) {
            System.out.print(i + " ");
            for (int j = 0; j < 10; j++) {
                System.out.print(player_field[i][j] + "  ");
            }
            System.out.print("\t\t");
            System.out.print(i + " ");
            for (int k = 0; k < 10; k++) {
                System.out.print(computer_field[i][k] + "  ");
            }
            System.out.print("\n");
        }
    }
    public static void playerShoot(Scanner scanner, char[][] field) {
        while (true) {
            try {
                System.out.println("Print the coordinate x");
                int x = scanner.nextInt();
                System.out.println("Print the coordinate y");
                int y = scanner.nextInt();
                if (field[x][y] == 'X') {
                    System.out.println("GOAL");
                    System.out.println("Nice shot");
                    field[x][y] = '@';
                    fake_field[x][y] = '@';
                    computerShip--;
                    printBattleField(fake_field);
                    if (computerShip == 0) {
                        return;
                    }
                } else {
                    System.out.println("You missed");
                    field[x][y] = '-';
                    fake_field[x][y] = '-';
                    printBattleField(fake_field);
                    return;
                }
            } catch (ArrayIndexOutOfBoundsException e) {
                System.out.println("You can use number from 0 to 9");
                break;
            } catch (Exception e) {
                throw new RuntimeException("Error, you must use only number");
            }
        }
    }
    public static void computerShoot(char[][] field, Random random) {
        while (true) {
            int x = random.nextInt(10);
            int y = random.nextInt(10);
            if (field[x][y] == 'X') {
                System.out.println("Computer shot your ship");
                field[x][y] = '@';
                playerShip--;
                printBattleField(player_field);
                if (playerShip == 0) {
                    return;
                }
            } else if (field[x][y] == '@' || field[x][y] == '-') {

            } else {
                System.out.println("Computer missed");
                field[x][y] = '-';
                printBattleField(player_field);
                return;
            }
        }
    }
}
