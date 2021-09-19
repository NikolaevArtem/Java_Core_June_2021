package course_project.services;

import course_project.ship.abstracts.SinglePartShip;

import java.util.List;
import java.util.Map;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class FieldPrinter {

    private static final int FIELD_CAPACITY = 10;
    protected static final String ANSI_RESET = "\033[0m";
    protected static final String ANSI_GREEN = "\u001B[32m";
    protected static final String ANSI_CYAN = "\u001B[36m";

    private FieldPrinter() {
        throw new IllegalStateException("Utility class");
    }

    public static void printFieldForInit(Stream<SinglePartShip> attacker) {
        int[][] attackerField = new int[FIELD_CAPACITY][FIELD_CAPACITY];
        attacker.forEach(elem -> add(attackerField, elem, 1));
        printTableHeader();
        System.out.println();
        for (int i = 0; i < FIELD_CAPACITY; i++) {
            printLineTable(i, attackerField);
            System.out.println();
        }
    }

    public static void printFiled(Stream<SinglePartShip> attacker, Map<Boolean, List<SinglePartShip>> opponent) {
        int[][] attackerField = new int[FIELD_CAPACITY][FIELD_CAPACITY];
        int[][] opponentField = new int[FIELD_CAPACITY][FIELD_CAPACITY];
        attacker.forEach(elem -> add(attackerField, elem, 1));
        opponent.entrySet().forEach(elem -> add(opponentField, elem));

        System.out.printf("%-51s", "your field");
        System.out.println("opponent field");

        printTableHeader();
        System.out.printf("%4s", " | ");
        printTableHeader();
        System.out.println();

        for (int i = 0; i < FIELD_CAPACITY; i++) {
            printLineTable(i, attackerField);
            System.out.printf("%4s", " | ");
            printLineOpponentTable(i, opponentField);
            System.out.println();
        }
    }

    private static void printTableHeader() {
        System.out.printf("%4s", "");
        IntStream.range(0, FIELD_CAPACITY).forEach(i -> System.out.printf("%4s", (char) (65 + i)));
    }

    private static void printLineTable(int i, int[][] field) {
        System.out.printf("%4s", i + 1);
        for (int j = 0; j < FIELD_CAPACITY; j++) {
            if (field[i][j] == 1) {
                System.out.printf("%13s", ANSI_GREEN + "x" + ANSI_RESET);
            } else {
                System.out.printf("%4s", ".");
            }
        }
    }

    private static void printLineOpponentTable(int i, int[][] field) {
        System.out.printf("%4s", i + 1);
        for (int j = 0; j < FIELD_CAPACITY; j++) {
            if (field[i][j] == 1) {
                System.out.printf("%13s", ANSI_GREEN + "x" + ANSI_RESET);
            } else if (field[i][j] == -1) {
                System.out.printf("%13s", ANSI_CYAN + "o" + ANSI_RESET);
            } else {
                System.out.printf("%4s", "?");
            }
        }
    }

    private static void add(int[][] field, SinglePartShip partShip, int value) {
        field[partShip.getY() - 1][partShip.getX() - 1] = value;
    }

    private static void add(int[][] field, Map.Entry<Boolean, List<SinglePartShip>> partShip) {
        if (partShip.getKey()) {
            partShip.getValue().forEach(elem -> add(field, elem, 1));
        } else {
            partShip.getValue().forEach(elem -> add(field, elem, -1));
        }
    }
}