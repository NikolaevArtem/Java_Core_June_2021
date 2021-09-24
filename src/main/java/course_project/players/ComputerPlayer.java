package course_project.players;

import course_project.engine.GameMap;
import course_project.ships.ShipSize;
import course_project.ships.ShipType;
import course_project.engine.SquareState;

import java.util.Random;
import java.util.Scanner;

public class ComputerPlayer extends Player {

    private static final String RED_BACKGROUND_BRIGHT = "\033[0;101m";
    private static final String ANSI_BLUE = "\u001B[34m";
    private static final String BLACK_BACKGROUND_BRIGHT = "\033[0;100m";
    private static final String ANSI_WHITE_BACKGROUND = "\u001B[47m";

    private static final String ANSI_RESET = "\u001B[0m";

    private GameMap gameMap = new GameMap();

    private String[][] battleMap1 = new String[11][11];
    private String[][] battleMapAI = new String[11][11];
    private String[][] emptyMap = new String[11][11];

    private Scanner input = new Scanner(System.in);

    public ComputerPlayer() {
        super("Computer");
    }

    public void shootAI(String[][] playerOneMap, String[][] computerMap, String player1, String AI) {

        System.out.println(player1 + " , let's get started! ");
        gameMap.printEmptyMap(emptyMap);

        String hitBarPlayer1 = "";
        String hitBarAI = "";
        String winBar = "********************";

        int hitsPlayer1 = 0;
        int hitsAI = 0;

        Random random = new Random();

        int countPlayer = 0;
        int countAI = 0;

        for (int y = 1; y < battleMap1.length; y++) {
            for (int x = 1; x < battleMap1.length; x++) {
                battleMap1[x][y] = SquareState.NONE.getSquareSymbol();
            }
        }

        for (int y = 1; y < battleMapAI.length; y++) {
            for (int x = 1; x < battleMapAI.length; x++) {
                battleMapAI[x][y] = SquareState.NONE.getSquareSymbol();
            }
        }

        do {
            String ships[] = {"S", "D", "C", "B", "c"};

            System.out.println("Your turn to shoot, " + player1 + "!");
            System.out.println("Enter X-coordinate: ");
            int xShoot = input.nextInt();
            System.out.println("Enter Y-coordinate: ");
            int yShoot = input.nextInt();

            while (xShoot < 1 || xShoot > 10 || yShoot < 1 || yShoot > 10) {
                System.out.println("Incorrect choice! ");
                System.out.println("Enter X-coordinate: ");
                xShoot = input.nextInt();
                System.out.println("Enter Y-coordinate: ");
                yShoot = input.nextInt();
            }

            for (int i = 0; i < ships.length; i++) {

                if (computerMap[xShoot][yShoot].contains(ships[i])) {

                    if (battleMapAI[xShoot][yShoot].contains(SquareState.HIT.getSquareSymbol())) {
                        System.out.println("You've already hit this cell. " + "\n");
                    } else {
                        System.out.println("HIT! " + "\n");

                        battleMapAI[xShoot][yShoot] = RED_BACKGROUND_BRIGHT + SquareState.HIT.getSquareSymbol() + ANSI_RESET + ANSI_BLUE;
                        hitBarPlayer1 += SquareState.HIT.getSquareSymbol();
                        hitsPlayer1++;
                    }
                }
            }

            if (computerMap[xShoot][yShoot].contains(SquareState.NONE.getSquareSymbol())) {
                System.out.println("MISS!");
                battleMapAI[xShoot][yShoot] = BLACK_BACKGROUND_BRIGHT + SquareState.MISS.getSquareSymbol() + ANSI_RESET + ANSI_BLUE;
            }

            System.out.println("MAP OF PLAYER " + AI);
            gameMap.printBattle(battleMapAI, xShoot, yShoot, "battle");
            if (hitsPlayer1 == 20) {
                System.out.println(player1 + " WINS! GAME OVER FOR: " + AI);
                break;
            }

            int xShootAI = random.nextInt(10 - 1) + 1;
            int yShootAI = random.nextInt(10 - 1) + 1;

            for (int i = 0; i < ships.length; i++) {
                if (playerOneMap[xShootAI][yShootAI].contains(ships[i])) {
                    if (battleMap1[xShoot][yShoot].contains(SquareState.HIT.getSquareSymbol())) {
                        System.out.println("You've already hit this cell. " + "\n");
                    } else {
                        System.out.println("HIT! " + "\n");
                        battleMap1[xShoot][yShoot] = RED_BACKGROUND_BRIGHT + SquareState.HIT.getSquareSymbol() + ANSI_RESET + ANSI_BLUE;
                        hitBarPlayer1 += SquareState.HIT.getSquareSymbol();
                        hitsAI++;
                    }
                }
            }

            if (playerOneMap[xShootAI][yShootAI].contains(SquareState.NONE.getSquareSymbol())) {
                System.out.println("MISS!");
                battleMap1[xShootAI][yShootAI] = BLACK_BACKGROUND_BRIGHT + SquareState.MISS.getSquareSymbol() + ANSI_RESET + ANSI_BLUE;
            }

            System.out.println("MAP OF PLAYER " + player1);
            gameMap.printBattle(battleMap1, xShootAI, yShootAI, "battle");

            if (hitsAI == 20) {
                System.out.println(AI + " WINS! GAME OVER FOR: " + player1);
                break;
            }

            System.out.println("Number of hits for " + player1 + " is: " + hitsPlayer1);
            System.out.println(ANSI_WHITE_BACKGROUND + winBar + ANSI_RESET);
            System.out.println(RED_BACKGROUND_BRIGHT + hitBarPlayer1 + ANSI_RESET);
            System.out.println("Number of hits for " + AI + " is: " + hitsAI);
            System.out.println(ANSI_WHITE_BACKGROUND + winBar + ANSI_RESET);
            System.out.println(RED_BACKGROUND_BRIGHT + hitBarAI + ANSI_RESET);

        }
        while (true);
    }

    public void AIDeployShips(String playerMap[][]) {

        int submarineSize = ShipSize.SUBMARINE.getSize();
        int destroyerSize = ShipSize.DESTROYER.getSize();
        int cruiserSize = ShipSize.CRUISER.getSize();
        int battleshipSize = ShipSize.BATTLESHIP.getSize();
        int carrier1Size = ShipSize.CARRIER1.getSize();
        int carrier2Size = ShipSize.CARRIER2.getSize();

        ShipType submarine = ShipType.SUBMARINE;
        ShipType destroyer = ShipType.DESTROYER;
        ShipType cruiser = ShipType.CRUISER;
        ShipType battleship = ShipType.BATTLESHIP;
        ShipType carrier1 = ShipType.CARRIER1;
        ShipType carrier2 = ShipType.CARRIER2;

        ShipType[] shipNames = {submarine, destroyer, cruiser, battleship, carrier1, carrier2};
        gameMap.printEmptyMap(playerMap);

        for (int i = 0; i < shipNames.length; i++) {
            int[] coordinates;

            switch (shipNames[i]) {
                case SUBMARINE:
                    gameMap.printAIMapShips(playerMap, submarineSize, submarine);
                    break;
                case DESTROYER:
                    gameMap.printAIMapShips(playerMap, destroyerSize, destroyer);
                    break;
                case CRUISER:
                    gameMap.printAIMapShips(playerMap, cruiserSize, cruiser);
                    break;
                case BATTLESHIP:
                    gameMap.printAIMapShips(playerMap, battleshipSize, battleship);
                    break;
                case CARRIER1:
                    gameMap.printAIMapShips(playerMap, carrier1Size, carrier1);
                    break;
                case CARRIER2:
                    gameMap.printAIMapShips(playerMap, carrier2Size, carrier2);
                    break;
                default:
                    System.out.println("Incorrect");
                    break;
            }
        }
    }

}