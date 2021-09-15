package course_project.battleship_game.utils;

import course_project.battleship_game.model.Cell;
import course_project.battleship_game.model.GameMode;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import static course_project.battleship_game.utils.Constants.CHOOSE_GAME_MODE_MESSAGE;
import static course_project.battleship_game.utils.Constants.CHOOSE_MODE_TO_CREATE_FLEET_MESSAGE;
import static course_project.battleship_game.utils.Constants.CHOOSE_SHIP_DIRECTION_MESSAGE;
import static course_project.battleship_game.utils.Constants.DEFAULT_PLAYER_NAME;
import static course_project.battleship_game.utils.Constants.ERROR_INPUT_MESSAGE;
import static course_project.battleship_game.utils.Constants.GET_CELL_COORDINATE_MESSAGE;
import static course_project.battleship_game.utils.Constants.GET_PLAYER_NAME_MESSAGE;
import static course_project.battleship_game.utils.PrintUtils.printMessage;

public class InputUtils {
    private static final BufferedReader READER = new BufferedReader(new InputStreamReader(System.in));

    public static String getPlayerName() {
        printMessage(GET_PLAYER_NAME_MESSAGE);
        String line = readLine();
        return line == null || line.isEmpty() ? DEFAULT_PLAYER_NAME : line;
    }

    public static GameMode getGameMode() {
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

    public static int getModeToCreateFleet() {
        printMessage(CHOOSE_MODE_TO_CREATE_FLEET_MESSAGE);
        return getZeroOrOne();
    }

    public static int getDirection() {
        printMessage(CHOOSE_SHIP_DIRECTION_MESSAGE);
        return getZeroOrOne();
    }

    public static Cell getCell() {
        printMessage(GET_CELL_COORDINATE_MESSAGE);
        String coordinate = readLine();
        while (!CoordinateValidator.isCoordinate(coordinate)) {
            printMessage(ERROR_INPUT_MESSAGE);
            coordinate = readLine();
        }
        int x = Integer.parseInt(coordinate.substring(1)) - 1;
        int y = ((int) coordinate.toUpperCase().charAt(0)) - 65;
        return new Cell(x, y);
    }

    private static String readLine() {
        try {
            return READER.readLine();
        } catch (IOException e) {
            return "";
        }
    }

    private static int getZeroOrOne() {
        String mode = readLine();
        while (true) {
            if (mode.equals("0") || mode.equals("1")) {
                return Integer.parseInt(mode);
            }
            printMessage(ERROR_INPUT_MESSAGE);
            mode = readLine();
        }
    }

}
