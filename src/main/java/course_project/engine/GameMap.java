package course_project.engine;

import course_project.ships.*;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;

public class GameMap {

    private Scanner input = new Scanner(System.in);
    private ArrayList<Ship> ships = new ArrayList<>();

    // Colours for background
    public static final String ANSI_BLUE_BACKGROUND = "\u001B[44m";
    public static final String YELLOW_BACKGROUND_BRIGHT = "\033[0;103m";
    public static final String BLACK_BACKGROUND_BRIGHT = "\033[0;100m";
    public static final String GREEN_BACKGROUND_BRIGHT = "\033[0;102m";
    public static final String PURPLE_BACKGROUND_BRIGHT = "\033[0;105m";
    public static final String CYAN_BACKGROUND_BRIGHT = "\033[0;106m";
    public static final String RED_BACKGROUND_BRIGHT = "\033[0;101m";

    //Colours for text
    public static final String ANSI_BLACK = "\u001B[30m";
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_BLUE = "\u001B[34m";
    public static final String WHITE_BOLD = "\033[1;37m";
    public static final String BLACK_BOLD = "\033[1;30m";

    // Reset colour
    public static final String ANSI_RESET = "\u001B[0m";

    public GameMap() {
    }

    public void printEmptyMap(String[][] map) {

        System.out.println(ANSI_BLUE_BACKGROUND + ANSI_BLACK +
                "                      OCEAN MAP                      " + ANSI_RESET);

        for (int line = 1; line < map.length; line++) {
            System.out.print(ANSI_BLUE + "_____" + ANSI_RESET);
        }

        for (int y = 1; y < map.length; y++) {
            for (int x = 1; x < map.length; x++) {
                map[x][y] = " ";
            }
        }

        System.out.println();
        for (int column = 1; column < map.length; column++) {
            String square = "";
            for (int row = 1; row < map.length; row++) {
                square += " [" + map[row][column] + "] ";
            }
            System.out.print(ANSI_BLUE + square + ANSI_RESET);
            System.out.println(ANSI_RED + "|" + column + "Y" + "|" + ANSI_RESET);
        }

        for (int line = 1; line < map.length; line++) {
            System.out.print(ANSI_BLUE + "_____" + ANSI_RESET);
        }

        System.out.println();
        System.out.print(" ");

        for (int k = 1; k < map.length; k++) {
            System.out.print(ANSI_RED + "" + k + "X" + " | " + ANSI_RESET);
        }

        System.out.println("\n" + "\n" +
                YELLOW_BACKGROUND_BRIGHT + WHITE_BOLD + "S: SUBMARINE (1) " + ANSI_RESET + " " +
                BLACK_BACKGROUND_BRIGHT + WHITE_BOLD + "D: DESTROYER (1) " + ANSI_RESET + " " +
                GREEN_BACKGROUND_BRIGHT + BLACK_BOLD + "C: CRUISER (1) " + ANSI_RESET + " " +
                PURPLE_BACKGROUND_BRIGHT + WHITE_BOLD + "B: BATTLESHIP (1) " + ANSI_RESET + " " +
                CYAN_BACKGROUND_BRIGHT + WHITE_BOLD + "c: CARRIER (2) " + ANSI_RESET
        );
        System.out.println("\n");
    }

    private void AIRandomCoordinatesToMap(String map[][], int size, ShipType shipType) {

        Random random = new Random();
        try {
            int randomX = random.nextInt(10 - 1) + 1;
            int randomY = random.nextInt(10 - 1) + 1;

            while (randomY < 1 || randomY > 8 && shipType.equals(ShipType.SUBMARINE)) {
                randomY = random.nextInt(10 - 1) + 1;
            }

            while (randomY < 1 || randomY > 9 && shipType.equals(ShipType.DESTROYER)) {
                randomY = random.nextInt(10 - 1) + 1;
            }

            while (randomY < 1 || randomY > 7 && shipType.equals(ShipType.CRUISER)) {
                randomY = random.nextInt(10 - 1) + 1;
            }

            while (randomY < 1 || randomY > 6 && shipType.equals(ShipType.BATTLESHIP)) {
                randomY = random.nextInt(10 - 1) + 1;
            }

            while (randomY < 1 || randomY > 8 && shipType.equals(ShipType.CARRIER1)) {
                randomY = random.nextInt(10 - 1) + 1;
            }

            while (randomY < 1 || randomY > 8 && shipType.equals(ShipType.CARRIER2)) {
                randomY = random.nextInt(10 - 1) + 1;
            }

            while (!map[randomX][randomY].equals(" ")) {
                for (int i = 0; i < size; i++) {
                    for (int y = randomY; y <= randomY; y++) {
                        y += i;
                        for (int x = randomX; x <= randomX; x++) {
                            if (!map[randomX][randomY].equals(" ")) {
                                randomX = random.nextInt(10 - 1) + 1;
                                randomY = random.nextInt(10 - 1) + 1;
                            } else {
                                break;
                            }
                        }
                    }
                }
            }

            for (int i = 0; i < size; i++) {
                for (int y = randomY; y <= randomY; y++) {
                    y += i;
                    for (int x = randomX; x <= randomX; x++) {

                        switch (shipType) {
                            case SUBMARINE:
                                map[x][y] = YELLOW_BACKGROUND_BRIGHT + WHITE_BOLD + ShipType.SUBMARINE.getShipType() + ANSI_RESET + ANSI_BLUE;
                                Submarine submarine = new Submarine(x, y);
                                ships.add(submarine);
                                break;
                            case DESTROYER:
                                map[x][y] = BLACK_BACKGROUND_BRIGHT + WHITE_BOLD + ShipType.DESTROYER.getShipType() + ANSI_RESET + ANSI_BLUE;
                                Destroyer destroyer = new Destroyer(x, y);
                                ships.add(destroyer);
                                break;
                            case CRUISER:
                                map[x][y] = GREEN_BACKGROUND_BRIGHT + BLACK_BOLD + ShipType.CRUISER.getShipType() + ANSI_RESET + ANSI_BLUE;
                                Cruiser cruiser = new Cruiser(x, y);
                                ships.add(cruiser);
                                break;
                            case BATTLESHIP:
                                map[x][y] = PURPLE_BACKGROUND_BRIGHT + WHITE_BOLD + ShipType.BATTLESHIP.getShipType() + ANSI_RESET + ANSI_BLUE;
                                BattleShip battleShip = new BattleShip(x, y);
                                ships.add(battleShip);
                                break;
                            case CARRIER1:
                                map[x][y] = CYAN_BACKGROUND_BRIGHT + WHITE_BOLD + ShipType.CARRIER1.getShipType() + ANSI_RESET + ANSI_BLUE;
                                Carrier carrier1 = new Carrier(x, y);
                                ships.add(carrier1);
                                break;
                            case CARRIER2:
                                map[x][y] = CYAN_BACKGROUND_BRIGHT + WHITE_BOLD + ShipType.CARRIER2.getShipType() + ANSI_RESET + ANSI_BLUE;
                                Carrier carrier2 = new Carrier(x, y);
                                ships.add(carrier2);
                                break;
                            default:
                                System.out.println("Incorrect");
                                break;
                        }
                    }
                }
            }

        }
        catch(Exception e){
            System.out.println("Something went wrong. ");
        }
    }

    private void addCoordinateToMap(String map[][], int size, ShipType shipType) {

        try {
            System.out.println("Add X-coordinate for your " + shipType + " with size " + size);
            int xInput = input.nextInt();

            System.out.println("Add Y-coordinate for your " + shipType + " with size " + size);
            int yInput = input.nextInt();

            while (xInput < 1 || xInput > 10) {
                System.out.println("Please Enter Valid X- Coordinate");
                xInput = input.nextInt();
            }

            while (yInput < 1 || yInput > 8 && shipType.equals(ShipType.SUBMARINE)) {
                System.out.println("Please Enter Valid Y-Coordinate");
                yInput = input.nextInt();
            }

            while (yInput < 1 || yInput > 9 && shipType.equals(ShipType.DESTROYER)) {
                System.out.println("Please Enter Valid Y-Coordinate");
                yInput = input.nextInt();
            }

            while (yInput < 1 || yInput > 7 && shipType.equals(ShipType.CRUISER)) {
                System.out.println("Please Enter Valid Y-Coordinate");
                yInput = input.nextInt();
            }

            while (yInput < 1 || yInput > 6 && shipType.equals(ShipType.BATTLESHIP)) {
                System.out.println("Please Enter Valid Y-Coordinate");
                yInput = input.nextInt();
            }

            while (yInput < 1 || yInput > 8 && shipType.equals(ShipType.CARRIER1)) {
                System.out.println("Please Enter Valid Y-Coordinate");
                yInput = input.nextInt();
            }

            while (yInput < 1 || yInput > 8 && shipType.equals(ShipType.CARRIER2)) {
                System.out.println("Please Enter Valid Y-Coordinate");
                yInput = input.nextInt();
            }

            while (!map[xInput][yInput].equals(" ")) {
                for (int i = 0; i < size; i++){
                    for (int y = yInput; y <= yInput; y++) {
                        y += i;
                        for (int x = xInput; x <= xInput; x++) {
                            if (map[x][y] != " ") {
                                System.out.println("You can't place a boat on another boat!");
                                System.out.println("Add X-coordinate for your " + shipType + " with size " + size);
                                xInput = input.nextInt();

                                System.out.println("Add Y-coordinate for your " + shipType + " with size " + size);
                                yInput = input.nextInt();
                            } else {
                                break;
                            }
                        }
                    }
                }
            }

            for (int i = 0; i < size; i++) {
                for (int y = yInput; y <= yInput; y++) {
                    y += i;
                    for (int x = xInput; x <= xInput; x++) {

                        switch (shipType) {
                            case SUBMARINE:
                                map[x][y] = YELLOW_BACKGROUND_BRIGHT + WHITE_BOLD + ShipType.SUBMARINE.getShipType() + ANSI_RESET + ANSI_BLUE;
                                Submarine submarinePlayer = new Submarine(x, y);
                                ships.add(submarinePlayer);
                                if(i==1){
                                    System.out.println(submarinePlayer.toString());
                                }
                                break;
                            case DESTROYER:
                                map[x][y] = BLACK_BACKGROUND_BRIGHT + WHITE_BOLD + ShipType.DESTROYER.getShipType() + ANSI_RESET + ANSI_BLUE;
                                Destroyer destroyerPlayer = new Destroyer(x, y);
                                ships.add(destroyerPlayer);
                                if(i==1){
                                    System.out.println(destroyerPlayer.toString());
                                }
                                break;
                            case CRUISER:
                                map[x][y] = GREEN_BACKGROUND_BRIGHT + BLACK_BOLD + ShipType.CRUISER.getShipType() + ANSI_RESET + ANSI_BLUE;
                                Cruiser cruiserPlayer = new Cruiser(x, y);
                                ships.add(cruiserPlayer);
                                if(i==1){
                                    System.out.println(cruiserPlayer.toString());
                                }
                                break;
                            case BATTLESHIP:
                                map[x][y] = PURPLE_BACKGROUND_BRIGHT + WHITE_BOLD + ShipType.BATTLESHIP.getShipType() + ANSI_RESET + ANSI_BLUE;
                                BattleShip battleShipPlayer = new BattleShip(x, y);
                                ships.add(battleShipPlayer);
                                if(i==1){
                                    System.out.println(battleShipPlayer.toString());
                                }
                                break;
                            case CARRIER1:
                                map[x][y] = CYAN_BACKGROUND_BRIGHT + WHITE_BOLD + ShipType.CARRIER1.getShipType() + ANSI_RESET + ANSI_BLUE;
                                Carrier carrier1Player = new Carrier(x, y);
                                ships.add(carrier1Player);
                                if(i==1){
                                    System.out.println(carrier1Player.toString());
                                }
                                break;
                            case CARRIER2:
                                map[x][y] = CYAN_BACKGROUND_BRIGHT + WHITE_BOLD + ShipType.CARRIER2.getShipType() + ANSI_RESET + ANSI_BLUE;
                                Carrier carrier2Player = new Carrier(x, y);
                                ships.add(carrier2Player);
                                if(i==1){
                                    System.out.println(carrier2Player.toString());
                                }
                                break;
                            default:
                                System.out.println("Incorrect");
                                break;
                        }
                    }
                }
            }
        } catch (InputMismatchException e) {
            e.getMessage();
        }
    }


    public void printPlayerMapShips (String[][] map, int size, ShipType shipType){

        addCoordinateToMap(map, size, shipType);
        System.out.println(ANSI_BLUE_BACKGROUND + ANSI_BLACK +
                "                      OCEAN MAP                      " + ANSI_RESET);

        for (int line = 1; line <= map.length; line++) {
            System.out.print(ANSI_BLUE + "_____" + ANSI_RESET);
        }

        System.out.println();

        for (int column = 1; column < map.length; column++) {
            String square = "";
            for (int row = 1; row < map.length; row++) {
                square += " [" + map[row][column] + "] ";
            }

            System.out.print(ANSI_BLUE + square + ANSI_RESET);
            System.out.println(ANSI_RED + "|" + column + "Y" + "|" + ANSI_RESET);
        }

        for (int line = 1; line <= map.length; line++) {
            System.out.print(ANSI_BLUE + "_____" + ANSI_RESET);
        }

        System.out.println();
        System.out.print(" ");

        for (int k = 1; k < map.length; k++) {
            System.out.print(ANSI_RED + "" + k + "X" + " | " + ANSI_RESET);
        }

        System.out.println("\n" + "\n" +
                YELLOW_BACKGROUND_BRIGHT + WHITE_BOLD + "S: SUBMARINE (1) " + ANSI_RESET + " " +
                BLACK_BACKGROUND_BRIGHT + WHITE_BOLD + "D: DESTROYER (1) " + ANSI_RESET + " " +
                GREEN_BACKGROUND_BRIGHT + BLACK_BOLD + "C: CRUISER (1) " + ANSI_RESET + " " +
                PURPLE_BACKGROUND_BRIGHT + WHITE_BOLD + "B: BATTLESHIP (1) " + ANSI_RESET + " " +
                CYAN_BACKGROUND_BRIGHT + WHITE_BOLD + "c: CARRIER (2) " + ANSI_RESET
        );

        System.out.println("\n");
    }

    public void printAIMapShips (String map[][],int size, ShipType shipType){

        AIRandomCoordinatesToMap(map, size, shipType);

        System.out.println(ANSI_BLUE_BACKGROUND + ANSI_BLACK +
                "                      OCEAN MAP                      " + ANSI_RESET);

        for (int line = 1; line <= map.length; line++) {
            System.out.print(ANSI_BLUE + "_____" + ANSI_RESET);
        }

        System.out.println();
        for (int column = 1; column < map.length; column++) {
            String square = "";
            for (int row = 1; row < map.length; row++) {
                square += " [" + map[row][column] + "] ";
            }

            System.out.print(ANSI_BLUE + square + ANSI_RESET);
            System.out.println(ANSI_RED + "|" + column + "Y" + "|" + ANSI_RESET);
        }

        for (int line = 1; line <= map.length; line++) {
            System.out.print(ANSI_BLUE + "_____" + ANSI_RESET);
        }

        System.out.println();
        System.out.print(" ");

            for (int k = 1; k < map.length; k++) {
                System.out.print(ANSI_RED + "" + k + "X" + " | " + ANSI_RESET);
            }

        System.out.println("\n" + "\n" +
                YELLOW_BACKGROUND_BRIGHT + WHITE_BOLD + "S: SUBMARINE (1) " + ANSI_RESET + " " +
                BLACK_BACKGROUND_BRIGHT + WHITE_BOLD + "D: DESTROYER (1) " + ANSI_RESET + " " +
                GREEN_BACKGROUND_BRIGHT + BLACK_BOLD + "C: CRUISER (1) " + ANSI_RESET + " " +
                PURPLE_BACKGROUND_BRIGHT + WHITE_BOLD + "B: BATTLESHIP (1) " + ANSI_RESET + " " +
                CYAN_BACKGROUND_BRIGHT + WHITE_BOLD + "c: CARRIER (2) " + ANSI_RESET
        );
        System.out.println("\n");
    }

    public void printBattle (String[][] map, int x, int y, String battle){

        System.out.println(ANSI_BLUE_BACKGROUND + ANSI_BLACK +
                "                      OCEAN MAP                      " + ANSI_RESET);

        for (int line = 1; line <= map.length; line++) {
            System.out.print(ANSI_BLUE + "_____" + ANSI_RESET);
        }
        System.out.println();

        for (int column = 1; column < map.length; column++) {
            String square = "";
            for (int row = 1; row < map.length; row++) {
                square += " [" + map[row][column] + "] ";
            }
            System.out.print(ANSI_BLUE + square + ANSI_RESET);
            System.out.println(ANSI_RED + "|" + column + "Y" + "|" + ANSI_RESET);
        }

        for (int line = 1; line <= map.length; line++) {
            System.out.print(ANSI_BLUE + "_____" + ANSI_RESET);
        }
        System.out.println();
        System.out.print(" ");

        for (int k = 1; k < map.length; k++) {
            System.out.print(ANSI_RED + "" + k + "X" + " | " + ANSI_RESET);
        }

        System.out.println("\n" + "\n" +
                RED_BACKGROUND_BRIGHT + WHITE_BOLD + "HIT (*) " + ANSI_RESET + " " +
                BLACK_BACKGROUND_BRIGHT + WHITE_BOLD + "MISS (X) " + ANSI_RESET + " "
        );
        System.out.println("\n");
    }

}