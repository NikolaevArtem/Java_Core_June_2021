package course_project.battleship_game.utils;

public class Constants {
    public static final int BOARD_SIZE = 10;
    public static final String DEFAULT_PLAYER_NAME = "Player";
    public static final String DEFAULT_COMPUTER_NAME = "Computer";
    public static final String WELCOME_MESSAGE = "Welcome to the Battleship game!\n";
    public static final String CHOOSE_GAME_MODE_MESSAGE = "Choose game mode:\n" +
            "0 - Computer vs Computer\n" +
            "1 - Computer vs Player\n" +
            "2 - Player vs Player\n";
    public static final String GET_PLAYER_NAME_MESSAGE = "Enter your name:\n";
    public static final String ROLLING_DICE_MESSAGE = "We are rolling dice to choose who will go first.\n";
    public static final String FLEETS_CREATED_MESSAGE = "\nFleets have been successfully created! Let's the battle begin!\n";
    public static final String CHOOSE_MODE_TO_CREATE_FLEET_MESSAGE = "\nChoose mode:\n" +
            "0 - place your ships randomly\n" +
            "1 - place your ships by yourself.\n";
    public static final String CHOOSE_SHIP_DIRECTION_MESSAGE = "Put 0 - for horizontal placement or 1 - for vertical placement\n";
    public static final String GET_CELL_COORDINATE_MESSAGE = "Type coordinate in format <A1> (Letters from A to J, numbers from 1 to 10)\n";
    public static final String EXCEPTION_MESSAGE = "Something went wrong. Please, restart the program.\n";
    public static final String ERROR_INPUT_MESSAGE = "Wrong input.\n";
    public static final String SAME_COORDINATE_ERROR_MESSAGE = "You have already done this move. Please try again!\n";
    public static final String PLAYER_BOARD_MESSAGE_FORMAT = "\nThis is %s's board\n";
    public static final String PLAYER_TURN_MESSAGE_FORMAT = "\nNow it is %s's turn\n";
    public static final String PLAYER_MOVE_MESSAGE_FORMAT = "%s made move on %s.\n";
    public static final String HIT_MESSAGE_FORMAT = "%s has just hit the ship of %s located on %s!\n";
    public static final String PLAYER_WINNER_MESSAGE_FORMAT = "\nCongratulations %s! You won the game!\n";
    public static final String MISSED_MESSAGE_FORMAT = "%s missed on %s.\n";
    public static final String CREATING_FLEET_MESSAGE_FORMAT = "\nCreating fleet for %s\n";
    public static final String FLEET_CREATED_MESSAGE_FORMAT = "The fleet for %s has been created!\n";
    public static final String CREATING_SHIP_MESSAGE_FORMAT = "Creating %s\n";
    public static final String SHIP_CREATED_MESSAGE_FORMAT = "%s successfully created %d %s(s).\n";
    public static final String REMAINING_AMOUNT_OF_TYPE_TO_CREATE = "Remaining amount of %ss is %d\n";

}
