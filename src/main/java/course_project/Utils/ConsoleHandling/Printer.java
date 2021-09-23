package course_project.Utils.ConsoleHandling;

import course_project.components.Field;
import course_project.enums.ShipType;

public class Printer {

    public void printGreeting() {
        String GREETING = "Welcome to Sea Battle, stranger!";
        System.out.println(GREETING);
    }

    public void printAskHowFill() {
        String ASK_HOW_TO_FILL = "How Would you like to place your ships? " +
                "Please, enter \" man \" to place them manually or just press enter to place them automatically";
        System.out.println(ASK_HOW_TO_FILL);
    }

    public void printHeader() {
        String HEADER = "    A  B  C  D  E  F  G  H  I  J ";

        System.out.println(HEADER);
    }

    public void printYuoMiss() {
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

    public void printDestroyed() {
        String DESTROYED = "Ship destroyed, did you that explosion? Huge, ain't it?";
        System.out.println(DESTROYED);
    }

    public void printWin() {
        String WON = "Oh yes, you is a winner! Never doubt it.";
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
        String ASK_PLACE_SHIP_HEAD = "Insert ship head coordinates, use header letter and a row number, like A 1 or c 4";
        System.out.println(ASK_PLACE_SHIP_HEAD);
    }

    public void printAskDestination() {
        String ASK_DESTINATION = "Which side would you like a Ship to be turned? Enter \"up\" , \"down\", \"left\" or \"right\"";
        System.out.println(ASK_DESTINATION);
    }

    public void printAskContinue() {
        String ASK_CONTINUE = "How about one more game?";
        System.out.println(ASK_CONTINUE);
    }

    public void printGoodbye() {
        String SAY_GOODBYE = "Thanks for a playing and have a nice day!";
        System.out.println(SAY_GOODBYE);
    }

    public void printSep() {
        String SEPARATOR = "-----------------------------";
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

    public void printYouField(Field field) {
        printHeader();
        int[][] toPrint = field.getField();
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

    public void printEnemyField(Field field) {
        printHeader();
        int[][] toPrint = field.getField();
        for (int[] row : toPrint
        ) {
            for (int i : row
            ) {
                if (i == 0 || i == '#') {
                    i = 126;
                }

                System.out.print(" " + (char) i + " ");
            }
            System.out.println();
        }
    }

}
