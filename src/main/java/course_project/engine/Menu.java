package course_project.engine;

import course_project.engine.BattleShipGame;
import course_project.players.ComputerPlayer;
import course_project.players.HumanPlayer;
import course_project.utils.FontColors;
import lombok.Data;

import java.util.InputMismatchException;
import java.util.Scanner;

@Data
public class Menu {

    private String[][] playerOneMap = new String[11][11];
    private String[][] playerTwoMap = new String[11][11];
    private String[][] computerMap = new String[11][11];
    private Scanner input = new Scanner(System.in);
    private boolean gameStillRunning;

    public boolean isGameStillRunning() {
        return gameStillRunning;
    }

    public void chooseGameOptions() {

        try {
            do {
                FontColors logo = new FontColors();
                logo.menuLogo();

                System.out.println("Welcome to Sea Battle! Please select mode using key 1, 2 or 3. Press <ENTER>");
                System.out.println("1. Player VS Player (PvP)");
                System.out.println("2. Player VS Computer (PvE)");
                System.out.println("3. Quit");
                int userChoice = input.nextInt();


                Scanner inputFromUser = new Scanner(System.in);

                switch (userChoice) {
                    case 1:
                        System.out.println("You have chosen 'Player VS Player' (PvP)" + "\n");

                        //Welcoming players and let them enter their name
                        System.out.println("Player 1, please type in your name");
                        String playerOneName = inputFromUser.nextLine();
                        HumanPlayer player1 = new HumanPlayer(playerOneName); // playerOneName is the input from user.
                        System.out.println("Welcome," + " " + player1.getName() + "!" + "\n");

                        System.out.println("Player 2, please type in your name");
                        String playerTwoName = inputFromUser.nextLine();
                        HumanPlayer player2 = new HumanPlayer(playerTwoName);
                        System.out.println("Welcome," + " " + player2.getName() + "!" + "\n");


                        // Let player 1 and player 2 place their ships
                        System.out.println(player1.getName() + "," + " " + "please place your ships (6) as shown below");
                        player1.placeShips(playerOneMap, player1.getName());

                        System.out.println(player2.getName() + "," + " " + "please place your ships (6) as shown below");
                        player2.placeShips(playerTwoMap, player2.getName());


                        // Let player ONE shoot first, then let each player take turn on shooting.
                        player1.shoot(playerOneMap, playerTwoMap, player1.getName(), player2.getName());

                        break;

                    case 2:
                        System.out.println("You have chosen 'Player VS Computer' (PvE)" + "\n \n" + "Please enter your name:");

                        String humanName = inputFromUser.nextLine();
                        HumanPlayer humanPlayer = new HumanPlayer(humanName);
                        System.out.println("Welcome," + " " + humanPlayer.getName() + "!");

                        // Name of Computer will include automatically via Computer-Class
                        ComputerPlayer computerPlayer = new ComputerPlayer();
                        System.out.println("You'll be playing against the" + " " + computerPlayer.getName() + "\n");

                        System.out.println(humanPlayer.getName() + "," + " " + "please place your ships (6) as shown below");
                        humanPlayer.placeShips(playerOneMap, humanPlayer.getName());

                        computerPlayer.AIDeployShips(computerMap);

                        computerPlayer.shootAI(computerMap, playerOneMap, humanPlayer.getName(), computerPlayer.getName());

                        break;


                    case 3:
                        System.out.println("You will now Quit Sea Wars");
                        System.exit(0); // Shuts down program
                    default:
                        throw new IllegalStateException("Unexpected value: " + userChoice);
                }

            } while (gameStillRunning = true);
        } catch (InputMismatchException e) {
            e.getMessage();
            System.out.println("Invalid choice. Please select 1, 2 or 3.");
            BattleShipGame bA = new BattleShipGame();
        }
    }
}