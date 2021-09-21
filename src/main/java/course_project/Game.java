package course_project;

import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.Stream;

class Game {

    private final Scanner reader;
    private final SeaBattleMap[] battleMaps = new SeaBattleMap[2];
    private final String mapsSpacing = "     ";

    private SeaBattleMap activeBattleMap;
    private String activePlayer;

    private GameStatus status;
    private String currentInput;

    Game() {
        reader = new Scanner(new InputStreamReader(System.in));
    }

    void run() {
        System.out.println("Welcome to SEA BATTLE console game!");
        System.out.println("Follow instructions to play the game or type \"exit\" anytyme to terminate program");
        try {
            start();
            runBattle();
        } finally {
            reader.close();
        }
    }

    private void start() {
        status = GameStatus.SettingShips;
        setBattleMaps();
        setShips();
    }

    private void runBattle() {
        status = GameStatus.Battle;

        activeBattleMap = battleMaps[1];
        activePlayer = battleMaps[0].getPlayerName();

        mainLoop:
        while (true) {
            for (int i = 0, j = 1; i < 2; i++, j--) {
                while (true) {
                    printBattleMaps();
                    if (readShootCommand())
                        if (!activeBattleMap.shoot(new Point(currentInput))) {
                            break;
                        }
                    if (activeBattleMap.getShips().size() == 0) {
                        System.out.printf("%s wins! Congrats!", activePlayer);
                        System.out.println();
                        break mainLoop;
                    }
                }
                activeBattleMap = battleMaps[i];
                activePlayer = battleMaps[j].getPlayerName();
            }
        }
    }

    private void setBattleMaps() {
        for (int i = 0; i < 2; i++) {
            battleMaps[i] = new SeaBattleMap(10, "Player " + (i + 1));
        }
    }

    private boolean readShootCommand() {
        System.out.printf("%s make a shoot (e.g. A1 or E9): ", activePlayer);
        currentInput = reader.nextLine();
        if (currentInput.equals("exit")) {
            throw new RuntimeException("Terminated by user");
        }
        String shootValidationPattern = "[A-J]([1-9]{1}|10)$";
        if (!currentInput.matches(shootValidationPattern)) {
            printErrorMessage("Wrong shoot command!");
            return false;
        }
        return true;
    }

    private void printBattleMap(SeaBattleMap battleMap) {
        System.out.println(
                battleMap.getView(status).stream().collect(Collectors.joining(System.lineSeparator()))
        );
    }

    private void printBattleMaps() {
        ArrayList<String> view1 = battleMaps[0].getView(status);
        ArrayList<String> view2 = battleMaps[1].getView(status);

        System.out.println(
                Stream.iterate(0, i -> i + 1)
                        .limit(view1.size())
                        .map(i -> view1.get(i).concat(mapsSpacing).concat(view2.get(i)))
                        .collect(Collectors.joining(System.lineSeparator()))
        );
    }

    private void setShips() {
        for (SeaBattleMap battleMap : battleMaps) {
            activeBattleMap = battleMap;
            while (true) {
                if (setNSizeShip(4))
                    break;
            }
            while (true) {
                if (setNSizeShip(3))
                    break;
            }
            while (true) {
                if (setNSizeShip(2))
                    break;
            }
            while (true) {
                if (setNSizeShip(1))
                    break;
            }
        }
    }

    private boolean setNSizeShip(int size) {
        int shipsCount = 5 - size - activeBattleMap.getNSizedShipsCount(size);
        for (int i = 0; i < shipsCount; i++) {
            printBattleMap(activeBattleMap);
            System.out.printf("%s, enter position and location type (R = right, D = down) " +
                    "to set %s-size ship (e.g. A1 R or A1 D): ", activeBattleMap.getPlayerName(), size);
            String input = reader.nextLine();
            if (input.equals("exit")) {
                throw new RuntimeException("Terminated by user");
            }
            String setShipsValidationPattern = "[A-J]([1-9]{1}|10)\\s([RD])$";
            if (!input.matches(setShipsValidationPattern)) {
                printErrorMessage("Wrong ship position command!");
                return false;
            }

            String[] inputParts = input.split("\\s");

            ShipLocationType shipLocationType = ShipLocationType.TO_RIGHT;
            if (inputParts[1].equals("D")) {
                shipLocationType = ShipLocationType.TO_DOWN;
            }
            try {
                activeBattleMap.addShip(new Point(inputParts[0]), size, shipLocationType);
            } catch (IllegalArgumentException e) {
                printErrorMessage(e.getMessage());
                return false;
            }

        }
        return true;
    }

    private void printErrorMessage(String message) {
        final String ANSI_RED = "\u001B[31m";
        final String ANSI_BLACK = "\u001B[0m";
        System.out.println(ANSI_RED + message + ANSI_BLACK);
    }

}
