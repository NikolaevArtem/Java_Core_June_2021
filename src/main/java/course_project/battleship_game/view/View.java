package course_project.battleship_game.view;

import course_project.battleship_game.model.Cell;
import course_project.battleship_game.model.CellStatus;
import course_project.battleship_game.model.GameMode;
import course_project.battleship_game.model.Player;
import course_project.battleship_game.utils.Validator;

import java.util.Scanner;

import static course_project.battleship_game.utils.Constants.CHOOSE_GAME_MODE_MESSAGE;
import static course_project.battleship_game.utils.Constants.CHOOSE_MODE_TO_CREATE_FLEET_MESSAGE;
import static course_project.battleship_game.utils.Constants.CHOOSE_SHIP_DIRECTION_MESSAGE;
import static course_project.battleship_game.utils.Constants.DEFAULT_PLAYER_NAME;
import static course_project.battleship_game.utils.Constants.ERROR_INPUT_MESSAGE;
import static course_project.battleship_game.utils.Constants.GET_CELL_COORDINATE_MESSAGE;
import static course_project.battleship_game.utils.Constants.GET_PLAYER_NAME_MESSAGE;
import static course_project.battleship_game.utils.Constants.PLAYER_BOARD_MESSAGE_FORMAT;
import static java.lang.System.lineSeparator;

public class View {
    private static final Scanner scanner = new Scanner(System.in);

    public String getPlayerName() {
        printMessage(GET_PLAYER_NAME_MESSAGE);
        String line = readLine();
        return line == null || line.isEmpty() ? DEFAULT_PLAYER_NAME : line;
    }

    public GameMode getGameMode() {
        printMessage(CHOOSE_GAME_MODE_MESSAGE);
        String mode = readLine();
        while (true) {
            if (mode.equals("0")) {
                return GameMode.CVC;
            } else if (mode.equals("1")) {
                return GameMode.PVC;
            } else if (mode.equals("2")) {
                return GameMode.PVP;
            } else {
                printMessage(ERROR_INPUT_MESSAGE);
                mode = readLine();
            }
        }
    }

    public int getModeToCreateFleet() {
        printMessage(CHOOSE_MODE_TO_CREATE_FLEET_MESSAGE);
        return getZeroOrOne();
    }

    public int getDirection() {
        printMessage(CHOOSE_SHIP_DIRECTION_MESSAGE);
        return getZeroOrOne();
    }

    public Cell getCell() {
        printMessage(GET_CELL_COORDINATE_MESSAGE);
        String coordinate = readLine();
        while (!Validator.isCoordinate(coordinate)) {
            printMessage(ERROR_INPUT_MESSAGE);
            coordinate = readLine();
        }
        int x = Integer.parseInt(coordinate.substring(1)) - 1;
        int y = ((int) coordinate.toUpperCase().charAt(0)) - 65;
        return new Cell(x, y);
    }

    public void printBoardForPlayer(Player player, boolean isEnemy) {
        printMessage(String.format(PLAYER_BOARD_MESSAGE_FORMAT, player.getName()));
        printHeader();
        Cell[][] boardMatrix = player.getBoard().getBoardMatrix();
        for (int y = 0; y < boardMatrix.length; y++) {
            printMessage((char) (65 + y) + " ");
            for (int x = 0; x < boardMatrix.length; x++) {
                printCell(isEnemy, boardMatrix[y][x]);
            }
            printMessage(lineSeparator());
        }
    }

    public void printMessage(String message) {
        System.out.print(message);
    }

    private void printCell(boolean isEnemy, Cell cell) {
        if (isEnemy && cell.getCellStatus().equals(CellStatus.SHIP)) {
            printMessage(CellStatus.EMPTY.getCharacter());
        } else {
            printMessage(cell.getCellStatus().getCharacter());
        }
    }

    public String readLine() {
        return scanner.nextLine();
    }

    private int getZeroOrOne() {
        String mode = readLine();
        while (true) {
            if (mode.equals("0") || mode.equals("1")) {
                return Integer.parseInt(mode);
            }
            printMessage(ERROR_INPUT_MESSAGE);
            mode = readLine();
        }
    }

    private void printHeader() {
        printMessage("   ");
        for (int i = 1; i < 11; i++) {
            printMessage(i + " ");
        }
        printMessage(lineSeparator());
    }

}
