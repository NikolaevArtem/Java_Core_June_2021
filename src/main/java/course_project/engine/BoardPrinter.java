package course_project.engine;

import course_project.models.Player;
import course_project.models.Board;

import java.util.Locale;

public class BoardPrinter {

    public static void printMainBoard(Player player) {
        Board board = player.mainBoard();
        System.out.println(player.name() + ": MAIN BOARD");
        int rowNum = 1;
        String rowOffset;
        System.out.println("     " + board.getColNames().stream().reduce(((s, s2) -> s + "   " + s2)).orElse("").toUpperCase(Locale.ROOT));
        for (int row : board.getRowNames()) {
            rowOffset = (rowNum < 10) ? rowNum + "  |" : rowNum + " |";
            System.out.print(rowOffset);

            for (String cell : board.getBoard().get(row)) {
                System.out.print(" " + cell + " " + "|");
            }
            System.out.print("\n");
            rowNum++;
        }
    }

    public static void printBothBoards(Player player) {
        Board mainBoard = player.mainBoard();
        Board scanBoard = player.scanBoard();
        int rowNum = 1;
        String spaceBetween = "                ";
        String rowOffset;
        System.out.println(spaceBetween + player.name() + ": MAIN BOARD" + spaceBetween + spaceBetween + "  ENEMY TRACKING");
        // top
        System.out.print("     " + mainBoard.getColNames().stream().reduce(((s, s2) -> s + "   " + s2)).orElse("").toUpperCase(Locale.ROOT));
        System.out.print(spaceBetween);
        System.out.println("       " + scanBoard.getColNames().stream().reduce(((s, s2) -> s + "   " + s2)).orElse("").toUpperCase(Locale.ROOT));

        for (int row : mainBoard.getRowNames()) {
            rowOffset = (rowNum < 10) ? rowNum + "  |" : rowNum + " |";
            System.out.print(rowOffset);

            for (String cell : mainBoard.getBoard().get(row)) {
                System.out.print(" " + cell + " " + "|");
            }
            System.out.print(spaceBetween);
            System.out.print(rowOffset);
            for (String cell : scanBoard.getBoard().get(row)) {
                System.out.print(" " + cell + " " + "|");
            }

            System.out.print("\n");
            rowNum++;
        }
    }

}
