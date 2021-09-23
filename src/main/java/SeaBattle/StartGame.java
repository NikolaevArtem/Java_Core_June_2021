package SeaBattle;

import java.util.Scanner;

import static SeaBattle.InputValidator.isInvalidInputData;
import static SeaBattle.WinnerChecker.isWinnerExist;

public class StartGame {

    private static final String LETTERS = "ABCDEFGHIJ";
    static final int COUNT = 70;
    static int currentCountOfShots = 0;

    public void startGame() {
        System.out.println("Game on! \n You should shoot all ships in " + COUNT + " rounds");
        GenerateShips test = new GenerateShips();
        char[][] board = test.createBoardWithShips();

        while(true) {
            PrintArray.printBoard(board);

            Scanner in = new Scanner(System.in);
            try {
                String playerChoice = in.next();

                int col = LETTERS.indexOf(playerChoice.toUpperCase().charAt(0));
                int row = Integer.parseInt(playerChoice.substring(1)) - 1;

                if(isInvalidInputData(col, row, board)) {
                    continue;
                }
                currentCountOfShots++;

                if(isWinnerExist(board, currentCountOfShots)) {
                    return;
                }

            } catch(NumberFormatException e) {
                System.out.println("Invalid input, please enter in format e.g. 'A5'");
                in.next();
            }
        }
    }
}
