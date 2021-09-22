package course_project.dialogue;

import course_project.logic.GameLogic;
import course_project.player.Player;
import course_project.ships.Ship;

import java.util.Scanner;

import static course_project.board.Battlefield.generateRandomPlacesForShips;
import static course_project.board.Battlefield.addShipsOneByOne;

@SuppressWarnings("java:S1118")
public class Menu {

    private static final String START_MESSAGE = "\n\t\t\t\t\tWelcome to Sea Battle mini-game. \n\t\t\t\tFirst of all, you should select game mode:";
    private static final String WRONG_INPUT = "Please, enter a valid coordinates.";
    private static final Scanner scanner = new Scanner(System.in);

    private static Player player;
    private static Player enemy;

    public static void showGreetings() {
        System.out.println(START_MESSAGE);
    }

    public static void showMainMenu() {
        System.out.println("\t\t\t\t- 1. Human vs Computer" +
                "\t\t- 2. Human vs Human" +
                "\n\t\t\t\t- 3. Computer vs Computer" +
                "\t- 4. Exit");
        String mode = getInput();
        switch (mode) {
            case "1":
                startHumanVSComputer();
                break;
            case "2":
                startHumanVSHuman();
                break;
            case "3":
                startComputerVSComputer();
                break;
            case "4":
                exit();
                break;
            default:
                System.out.println(WRONG_INPUT);
                showMainMenu();
        }
    }

    private static void startHumanVSComputer() {
        player = new Player(getInputName(), false);
        enemy = new Player("Artem Nikolaev", true);
        showPlayerMenu(player);
        generateRandomPlacesForShips(enemy);
        GameLogic game = new GameLogic(player, enemy);
        game.run();
    }

    private static void startHumanVSHuman() {
        player = new Player(getInputName(), false);
        enemy = new Player(getInputName(), false);
        showPlayerMenu(player);
        showPlayerMenu(enemy);
        GameLogic game = new GameLogic(player, enemy);
        game.run();
    }

    private static void startComputerVSComputer() {
        player = new Player("Computer 1", true);
        enemy = new Player("Computer 2", true);
        generateRandomPlacesForShips(player);
        generateRandomPlacesForShips(enemy);
        GameLogic game = new GameLogic(player, enemy);
        game.run();
    }

    private static String getInputName() {
        System.out.println("\t\tPlease, provide your name, it can contain only English letters in any case:");
        String name;
        while (true) {
            name = getInputNameS();
            if (name.matches("^[a-zA-Z ]{2,}$")) {
                return name;
            } else {
                System.out.println("The name is incorrect, it can contain only English letters in any case");
            }
        }
    }

    private static void showPlayerMenu(Player currentPlayer) {
        System.out.println("\tThe next step is to choose the type of ship placement. " + currentPlayer.getName() + ", please, select your choice:" +
                "\n\t\t\t\t\t- 1 Add ships on the field manually" +
                "\n\t\t\t\t\t- 2 Auto adding ships");
        String input = getInput();
        switch (input) {
            case "1":
                addShipsOneByOne(currentPlayer);
                currentPlayer.getField().printField();
                System.out.println("Battlefield was successfully filled. \n");
                break;
            case "2":
                generateRandomPlacesForShips(currentPlayer);
                currentPlayer.getField().printField();
                System.out.println("Battlefield was successfully filled. \n");
                break;
            default:
                System.out.println(WRONG_INPUT);
                showPlayerMenu(currentPlayer);
        }
    }

    public static void showHelp() {
        System.out.println("\tIn order to manually place the ship on the field, you need specify the correct coordinates, for example, g4 or B3 v. " +
                "\n\t\t\t\t\t\tBy default, the direction is set to horizontal." +
                "\n\t\t\t\t\tIf you want to rotate ship, add 'v' letter after coordinates." +
                "\n\t\t\t\t\tIf you want to leave the game at any time, enter 'exit'");
    }

    public static void showCoordinatesHelp(){
        System.out.println("In order to select which cell you want to hit, you need specify the correct coordinates, for example, a5 or H6\n");
    }

    public static String getPlayerMotionInput() {
        while (true) {
            String input = getInput();
            if ("exit".equals(input)) {
                exit();
            } else if (input.matches("^[a-j]([1-9]|10)$")) {
                return input;
            } else {
                System.out.println(WRONG_INPUT);
            }

        }
    }

    public static String getInputPosition() {
        while (true) {
            String input = getInput();
            if ("exit".equals(input)) {
                exit();
            } else if (input.matches("^[a-j]([1-9]|10)$") || input.matches("^[a-j]([1-9]|10)\\s[v]$")) {
                return input;
            } else {
                System.out.println(WRONG_INPUT);
            }
        }
    }

    private static String getInput() {
        return scanner.nextLine().trim().toLowerCase();
    }

    private static String getInputNameS() {
        return scanner.nextLine().trim();
    }


    public static void destroyTrigger(String enemy, String currentPlayer, Ship ship, int x, int y) {
        System.out.println(currentPlayer + " hit " + enemy + "'s ship at coordinates " + Character.toUpperCase((char) (y + 97)) + "" + (x + 1) + " and destroy " + ship.getName() + ".");
    }

    public static void showWinScreen(Player currentPlayer, Player opponent) {
        System.out.println("\n" + currentPlayer.getName() + ", congratulations, you won the game.");
        showCongratulationsPicture();
        System.out.println("\n" + opponent.getName() + ", better luck next time.\n");

        currentPlayer.getField().showTwoFields(currentPlayer, opponent);
        System.out.println("This is the end of the game. Thank you for participating and see you soon.");
        exit();
    }

    private static void exit() {
        scanner.close();
        Runtime.getRuntime().exit(0);
    }

    private static void showCongratulationsPicture() {
        System.out.println("                                   .''.       \n" +
                "       .''.      .        *''*    :_\\/_:     . \n" +
                "      :_\\/_:   _\\(/_  .:.*_\\/_*   : /\\ :  .'.:.'.\n" +
                "  .''.: /\\ :   ./)\\   ':'* /\\ * :  '..'.  -=:o:=-\n" +
                " :_\\/_:'.:::.    ' *''*    * '.\\'/.' _\\(/_'.':'.'\n" +
                " : /\\ : :::::     *_\\/_*     -= o =-  /)\\    '  *\n" +
                "  '..'  ':::'     * /\\ *     .'/.\\'.   '\n" +
                "      *            *..*         :\n" +
                "       *\n" +
                "        *");
    }

    public static void showLogo(){
        System.out.println("                                     |__\n" +
                "                                     |\\/\n" +
                "                                     ---\n" +
                "                                     / | [\n" +
                "                              !      | |||\n" +
                "                            _/|     _/|-++'\n" +
                "                        +  +--|    |--|--|_ |-\n" +
                "                     { /|__|  |/\\__|  |--- |||__/\n" +
                "                    +---------------___[}-_===_.'____               ||\n" +
                "                ____`-' ||___-{]_| _[}-  |     |_[___\\==--          \\/   _\n" +
                " __..._____--==/___]_|__|_____________________________[___\\==--___,-----'  |\n" +
                "|                                                            Ilia.Prokofev./\n" +
                " \\_______________________________________________________________________|");
    }

}
