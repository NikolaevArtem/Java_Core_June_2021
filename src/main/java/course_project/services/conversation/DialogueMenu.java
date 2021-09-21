package course_project.services.conversation;

import course_project.gamestuff.field.Field;
import course_project.gamestuff.player.Player;
import course_project.gamestuff.ships.Ship;
import course_project.services.logic.GameLogic;
import homework_4.custom_file_reader.CustomFileReader;

import java.util.Scanner;

import static course_project.gamestuff.field.Battlefield.addShipsAuto;
import static course_project.gamestuff.field.Battlefield.addShipsManually;
import static course_project.gamestuff.field.Field.FIELD_SIZE;
import static course_project.gamestuff.field.Field.LOWERCASE_A;

/**
 * Ultimate class for communication over the app;
 * it's using functional style, just because it's no reason to use extra memory for storing object,
 * and no even reason to create object of such type except it'd implement command pattern -
 * but it's completely different way to communicate over app.
 */
public class DialogueMenu {

    private static final String INCORRECT_INPUT_MESSAGE = "Please, input correct variant";
    private static final String FILLED_FIELD_MESSAGE = "Done! Battlefield is filled ;)";
    private static final String WELCOME_MESSAGE = "Welcome to Sea Battle Console v0.1!";
    private static final String QUIT = "quit";
    private static final String FIRST_SYMBOL_POSITION_REGEX;
    private static final String DIRECTION_REGEX = "^[v|h]$";
    private static final String NAME_REGEX = "^[a-zA-Z]{2,}$";
    private static final Scanner scanner = new Scanner(System.in);

    static {
        FIRST_SYMBOL_POSITION_REGEX = "^[" + Field.LOWERCASE_A + "-" + (char) (LOWERCASE_A + FIELD_SIZE) + "]$";
    }

    private static Player player;
    private static Player enemy;

    private DialogueMenu() {
    }

    public static void printGreetings() {
        System.out.println(WELCOME_MESSAGE);
    }

    public static void printMainMenu() {
        System.out.print(
                "[1] Start game Human vs Computer\n" +
                        "[2] Start game Human vs Human\n" +
                        "[3] Start game Computer vs Computer\n" +
                        "[4] Print rules\n" +
                        "[5] Quit the game\n"
        );
        String input = getInput();
        switch (input) {
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
                printRules();
                printMainMenu();
                break;
            case "5":
                terminate();
                break;
            default:
                System.out.println(INCORRECT_INPUT_MESSAGE);
                printMainMenu(); // recursion, wow!
        }
    }

    private static void printRules() {
        new CustomFileReader("./src/main/resources/sea_battle/", "rules.txt")
                .run2();
    }

    private static void startComputerVSComputer() {
        player = new Player("CPU0", true);
        enemy = new Player("CPU1", true);
        addShipsAuto(player);
        addShipsAuto(enemy);
        new GameLogic(player, enemy).run();
    }

    @SuppressWarnings("java:S2142") // like senior developer! yah?
    private static void startHumanVSHuman() {
        player = new Player(getInputName(), false);
        enemy = new Player(getInputName(), false);
        printPlayerMenu(player);
        try {
            printInviteOpponentMessage(enemy);
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        printPlayerMenu(enemy);
        new GameLogic(player, enemy).run();
    }

    private static void startHumanVSComputer() {
        player = new Player(getInputName(), false);
        enemy = new Player("Mozilla", true);
        printPlayerMenu(player);
        addShipsAuto(enemy);
        new GameLogic(player, enemy).run();
    }

    private static String getInputName() {
        System.out.println("My name is SeaBattle, and yours?");
        while (true) {
            String name = scanner.nextLine().trim();
            if (name.matches(NAME_REGEX)) {
                return name;
            } else {
                System.out.println("Ha-ha, it's impossible to have such name!\n" +
                        "It should consists of at least 2 latin symbols and no numbers and spaces, ok?");
            }
        }
    }

    public static void printInviteOpponentMessage(Player opponent) {
        System.out.println(opponent.getName() + "'s turn!");
    }

    private static void printPlayerMenu(Player currentPlayer) {
        System.out.print("Menu for " + currentPlayer.getName() + ":" + "\n" +
                "[1] Add ships on the field manually\n" +
                "[2] Auto adding ships\n");
        String input = getInput();
        switch (input) {
            case "1":
                addShipsManually(currentPlayer);
                currentPlayer.getField().printField();
                System.out.println(FILLED_FIELD_MESSAGE + "\n");
                break;
            case "2":
                addShipsAuto(currentPlayer);
                currentPlayer.getField().printField();
                System.out.println(FILLED_FIELD_MESSAGE + "\n");
                break;
            default:
                System.out.println(INCORRECT_INPUT_MESSAGE);
                printPlayerMenu(currentPlayer); // recursion again, ok!?
        }
    }

    public static String getPlayerMotionInput() {
        while (true) {
            String input = getInput();
            if (QUIT.equals(input)) {
                terminate();
            } else if (isPositionValid(input)) {
                return input;
            } else {
                System.out.println(INCORRECT_INPUT_MESSAGE);
            }
        }
    }

    public static void printPlayerShipPlacingHelp() {
        System.out.println("To place ship just input position from" + "'a1' to " +
                ((char) (LOWERCASE_A + FIELD_SIZE - 1)) + FIELD_SIZE +
                "(horizontal direction is default)" +
                "\nIf you want to set ship vertically type e.g. 'a1 v' or horizontal 'b2 h'" +
                "\nInput 'quit' to exit the game.");
    }

    public static String getShipPlacingInput() {
        while (true) {
            String input = getInput();
            if (QUIT.equals(input)) {
                terminate();
            } else {
                String[] strings = input.split(" ");
                if ((strings.length == 1 && isPositionValid(input)) ||
                        (strings.length == 2 && isPositionValid(strings[0]) && strings[1].matches(DIRECTION_REGEX))) {
                    return input;
                } else {
                    System.out.println(INCORRECT_INPUT_MESSAGE);
                }
            }
        }
    }

    private static boolean isPositionValid(String str) {
        return String.valueOf(str.charAt(0)).matches(FIRST_SYMBOL_POSITION_REGEX) &&
                str.substring(1).matches("\\d+") &&
                Integer.parseInt(str.substring(1)) >= 1 &&
                Integer.parseInt(str.substring(1)) <= FIELD_SIZE;
    }

    public static void printSetPositionMessage(String name, int size) {
        System.out.print("Set position for " + name + " size of " + size + ": ");
    }

    private static String getInput() {
        return scanner.nextLine().trim().toLowerCase();
    }

    public static void printShipDestroyedMessage(String opponentsName, Ship ship) {
        System.out.println("Nice! " + opponentsName + "'s " + ship.getName() + " is destroyed!");
    }

    public static void printShipHitMessage(String currentPlayerName, String opponentsName) {
        System.out.println(currentPlayerName + " hit " + opponentsName + "'s ship!");
    }

    public static void printMiss() {
        System.out.println("MISS!");
    }

    public static void printShipsLeftMessage(int countOfShipsLeft) {
        System.out.println(countOfShipsLeft + " ships left");
    }

    public static void printSamePositionMessage() {
        System.out.println("You've already hit at this position! Try another one: ");
    }

    public static void printCongratulationsAndQuit(Player currentPlayer, Player opponent) {
        System.out.println(currentPlayer.getName() + " WON THE GAME !!!" +
                "\n" + opponent.getName() + " lose.");
        terminate();
    }

    private static void terminate() {
        scanner.close();
        Runtime.getRuntime().exit(0); // James Gosling approved!
    }

}
