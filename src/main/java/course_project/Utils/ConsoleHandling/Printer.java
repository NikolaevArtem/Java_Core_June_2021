package course_project.Utils.ConsoleHandling;

import ConsoleColors.ConsoleColors;
import course_project.components.Field;
import course_project.components.Ship;
import course_project.enums.ShipType;

public class Printer {


    public void printGreeting() {
        String GREETING = "Welcome to Sea Battle, stranger!";
        System.out.println(GREETING);
    }

    public void printAskHowFill() {
        String ASK_HOW_TO_FILL = "How Would you like to place your ships? " +
                "Please, enter \" anything \" to place them manually or just press enter to place them automatically \n" +
                ConsoleColors.RED + "Bear in mind, that any input will be counted like manual mode!" + ConsoleColors.RESET ;
        System.out.println(ASK_HOW_TO_FILL);
    }

    public void printHeader() {
        String HEADER = "    A  B  C  D  E  F  G  H  I  J ";

        System.out.println(HEADER);
    }

    public void printYouMiss() {
        String YOU_MISS = "Oh no, you missed  :(";
        System.out.println(YOU_MISS);
    }

    public void printPCMiss() {
        String AI_MISSED = "Computer missed, thank goodness!";
        System.out.println(AI_MISSED);
    }

    public void printYouHit() {
        String YOU_HIT = "What a shoot, you hit it!";
        System.out.println(YOU_HIT);
    }

    public void printYouWasHit() {
        String YOU_WAS_HIT = "Uh, oh, your ship is falling apart!";
        System.out.println(YOU_WAS_HIT);
    }

    public void printDestroyed(Ship ship) {
        String DESTROYED = "Ship " + ship.getType() + " at " + ship.getCoordinates() + " is destroyed, did you see that explosion? Huge, ain't it?";
        System.out.println(DESTROYED);
    }

    public void printWin() {
        String WON = "Oh yes, you are a winner! Never doubt it.";
        System.out.println(WON);
    }

    public void printLose() {
        String LOSE = "What a shame, you lose!";
        System.out.println(LOSE);
    }

    public void printShoot() {
        String SHOOT = "Piu piu piu";
        System.out.println(SHOOT);
    }

    public void askShipHead() {
        String ASK_PLACE_SHIP_HEAD = "Insert ship head coordinates, insert column and row, like A1 or c4";
        System.out.println(ASK_PLACE_SHIP_HEAD);
    }

    public void printAskDestination() {
        String ASK_DESTINATION = "Which side would you like a Ship to be turned? Enter \"up\" , \"down\", \"left\" or \"right\"";
        System.out.println(ASK_DESTINATION);
    }

    public void printAskContinue() {
        String ASK_CONTINUE = "How about one more game?" + "Please, enter \" anything \" to play one more time or just press enter to exit \n" +
                ConsoleColors.RED + "Bear in mind, that any input will be counted like continue mode!" + ConsoleColors.RESET;
        System.out.println(ASK_CONTINUE);
    }

    public void printGoodbye() {
        String SAY_GOODBYE = "Thanks for a playing and have a nice day!";
        System.out.println(SAY_GOODBYE);
    }

    public void printSep() {
        String SEPARATOR = "---------------------------------";
        System.out.println(SEPARATOR);
    }

    public void printInputError() {
        String INPUT_ERROR_MESSAGE = "Something is wrong with input, try again";
        System.out.println(INPUT_ERROR_MESSAGE);
    }

    public void printPlacing(ShipType type) {
        String PLACING = "Now Placing : ";
        System.out.println(PLACING + type.getType());
    }

    public void printPlaced(ShipType type) {
        String PLACED = "Correctly placed : ";
        System.out.println(PLACED + type.getType());
    }
    public void compMoves() {
        String COMP_MOVES = "Now is a computer move: ";
        System.out.println(COMP_MOVES);
    }
    public void playerMoves() {
        String PLAYER_MOVES = "Now is your move: ";
        System.out.println(PLAYER_MOVES);
    }

    public void askWhereToShoot() {
        String ASK_WHERE_TO_SHOOT = "Insert shot coordinates, insert column and row, like A1 or c4";
        System.out.println(ASK_WHERE_TO_SHOOT);
    }

    public void printOpenField(Field field) {
        printHeader();
        int[][] rawMatrix = field.getField();
        int [][] toPrint = turnMatrix(rawMatrix);

        int rowNumber = 1;
        for (int[] row : toPrint
        ) {
            if (rowNumber < 10) {
                System.out.print(rowNumber + "  ");
            }
            else {
                System.out.print(rowNumber + " ");
            }
            for (int i : row
            ) {
                if (i == 0) {
                    i += 126;
                }
                System.out.print(" " + (char) i + " ");
            }
            System.out.println();
            ++rowNumber;
        }
    }

    public void printHiddenField(Field field) {
        printHeader();
        int[][] rawMatrix = field.getField();
        int [][] toPrint = turnMatrix(rawMatrix);
        int rowNumber = 1;
        for (int[] row : toPrint
        ) {
            if (rowNumber < 10) {
                System.out.print(rowNumber + "  ");
            }
            else {
                System.out.print(rowNumber + " ");
            }
            for (int i : row
            ) {
                if (i == 0 || i == '#') {
                    i = 126;
                }

                System.out.print(" " + (char) i + " ");
            }
            System.out.println();
            ++rowNumber;
        }
    }
    private int[][] turnMatrix(int[][] rawMatrix) {
        int[][]result = new int[10][10];
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                result[i][j] = rawMatrix[j][i];
            }
        }
        return result;
    }
}
