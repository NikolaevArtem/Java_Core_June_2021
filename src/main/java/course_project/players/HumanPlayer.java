package course_project.players;

import course_project.engine.GameMap;
import course_project.engine.SquareState;
import course_project.ships.ShipSize;
import course_project.ships.ShipType;

import java.util.Scanner;

public class HumanPlayer extends Player {

    private static final String RED_BACKGROUND_BRIGHT = "\033[0;101m";
    private static final String ANSI_WHITE_BACKGROUND = "\u001B[47m";
    private static final String BLACK_BACKGROUND_BRIGHT = "\033[0;100m";
    private static final String ANSI_BLUE = "\u001B[34m";
    private static final String ANSI_RESET = "\u001B[0m";
    private Scanner input = new Scanner(System.in);
    private GameMap gameMap = new GameMap();
    private String[][] battleMap1 = new String[11][11];
    private String[][] battleMap2 = new String[11][11];
    private String[][] emptyMap = new String[11][11];

    public HumanPlayer(String name) {
        super(name);
    }

    public void shoot(String[][] playerOneMap, String[][] playerTwoMap, String player1, String player2){

        System.out.println(player1 +  " get ready to battle! ");
        gameMap.printEmptyMap(emptyMap);
        String hitBarPlayer1 = "";
        String hitBarPlayer2 = "";
        String winBar = "********************";

        int hitsPlayer1 = 0;
        int hitsPlayer2 = 0;

        int countPlayer1 = 0;
        int countPlayer2 = 0;

        for (int y = 1; y < battleMap2.length; y++) {
            for (int x = 1; x < battleMap2.length; x++) {
                battleMap2[x][y] = SquareState.NONE.getSquareSymbol();
            }
        }

        for (int y = 1; y < battleMap1.length; y++) {
            for (int x = 1; x < battleMap1.length; x++) {
                battleMap1[x][y] = SquareState.NONE.getSquareSymbol();
            }
        }

        do {
            String[] ships = {"S", "D", "C", "B", "c"};
            System.out.println("Your turn to shoot, " + player1 + "!");
            System.out.println("Shoot! Enter X-coordinate: ");
            int xShoot = input.nextInt();
            System.out.println("Shoot! Enter Y-coordinate: ");
            int yShoot = input.nextInt();

            while(xShoot <1 || xShoot>10 || yShoot<1 || yShoot>10){
                System.out.println("Invalid choice! ");
                System.out.println("Shoot! Enter X-coordinate: ");
                xShoot = input.nextInt();
                System.out.println("Shoot! Enter Y-coordinate: ");
                yShoot = input.nextInt();
            }

            for (int i = 0; i < ships.length; i++) {
                if (playerTwoMap[xShoot][yShoot].contains(ships[i])) {
                    if(battleMap2[xShoot][yShoot].contains(SquareState.HIT.getSquareSymbol())){
                        System.out.println("You have hit this cell. " + "\n");
                    }
                    else{
                        System.out.println("HIT! " + "\n");
                        countPlayer1++;
                        if(countPlayer1 == ShipSize.SUBMARINE.getSize() && playerOneMap[xShoot][yShoot].contains(ShipType.SUBMARINE.getShipType())){
                            System.out.println("YOU SUNK THE " + ShipType.SUBMARINE + "!");
                            countPlayer1 = 0;
                        }
                        if(countPlayer1 == ShipSize.DESTROYER.getSize() && playerOneMap[xShoot][yShoot].contains(ShipType.DESTROYER.getShipType())){
                            System.out.println("YOU SUNK THE " + ShipType.DESTROYER + "!");
                            countPlayer1 = 0;
                        }
                        if(countPlayer1 == ShipSize.CRUISER.getSize() && playerOneMap[xShoot][yShoot].contains(ShipType.CRUISER.getShipType())){
                            System.out.println("YOU SUNK THE " + ShipType.CRUISER + "!");
                            countPlayer1 = 0;
                        }
                        if(countPlayer1 == ShipSize.BATTLESHIP.getSize() && playerOneMap[xShoot][yShoot].contains(ShipType.BATTLESHIP.getShipType())){
                            System.out.println("YOU SUNK THE " + ShipType.BATTLESHIP + "!");
                            countPlayer1 = 0;
                        }
                        if(countPlayer1 == ShipSize.CARRIER1.getSize() && playerOneMap[xShoot][yShoot].contains(ShipType.CARRIER1.getShipType())){
                            System.out.println("YOU SUNK THE " + ShipType.CARRIER1 + "!");
                            countPlayer1 = 0;
                        }
                        if(countPlayer1 == ShipSize.CARRIER2.getSize() && playerOneMap[xShoot][yShoot].contains(ShipType.CARRIER2.getShipType())){
                            System.out.println("YOU SUNK THE " + ShipType.CARRIER2 + "!");
                            countPlayer1 = 0;
                        }

                        battleMap2[xShoot][yShoot] = RED_BACKGROUND_BRIGHT + SquareState.HIT.getSquareSymbol() + ANSI_RESET + ANSI_BLUE;
                        hitBarPlayer1 += SquareState.HIT.getSquareSymbol();
                        hitsPlayer1++;
                    }
                }
            }

            if(playerTwoMap[xShoot][yShoot].contains(SquareState.NONE.getSquareSymbol())) {
                System.out.println("MISS! " + "\n");
                battleMap2[xShoot][yShoot] = BLACK_BACKGROUND_BRIGHT + SquareState.MISS.getSquareSymbol() + ANSI_RESET + ANSI_BLUE;
            }

            System.out.println("MAP OF PLAYER " + player2);
            gameMap.printBattle(battleMap2, xShoot, yShoot, "battle");
            if (hitsPlayer1 == 20) {
                System.out.println(player1 + " WINS! GAME OVER FOR: " + player2);
                break;
            }

            System.out.println("Your turn to shoot, " + player2 + "!");
            System.out.println("Shoot! Enter X-coordinate: ");
            xShoot = input.nextInt();
            System.out.println("Shoot! Enter Y-coordinate: ");
            yShoot = input.nextInt();

            while(xShoot <1 || xShoot>10 || yShoot<1 || yShoot>10){
                System.out.println("Incorrect choice");
                System.out.println("Shoot! Enter X-coordinate: ");
                xShoot = input.nextInt();
                System.out.println("Shoot! Enter Y-coordinate: ");
                yShoot = input.nextInt();
            }

            for (int i = 0; i < ships.length; i++) {
                if (playerOneMap[xShoot][yShoot].contains(ships[i])) {

                    if(battleMap1[xShoot][yShoot].contains(SquareState.HIT.getSquareSymbol())){
                        System.out.println("You have hit this cell. " + "\n");
                    }
                    else{
                        System.out.println("HIT! " + "\n");
                        countPlayer2++;
                        if(countPlayer2 == ShipSize.SUBMARINE.getSize() && playerOneMap[xShoot][yShoot].contains(ShipType.SUBMARINE.getShipType())){
                            System.out.println("YOU SUNK THE " + ShipType.SUBMARINE + "!");
                            countPlayer2 = 0;
                        }
                        if(countPlayer2 == ShipSize.DESTROYER.getSize() && playerOneMap[xShoot][yShoot].contains(ShipType.DESTROYER.getShipType())){
                            System.out.println("YOU SUNK THE " + ShipType.DESTROYER + "!");
                            countPlayer2 = 0;
                        }
                        if(countPlayer2 == ShipSize.CRUISER.getSize() && playerOneMap[xShoot][yShoot].contains(ShipType.CRUISER.getShipType())){
                            System.out.println("YOU SUNK THE " + ShipType.CRUISER + "!");
                            countPlayer2 = 0;
                        }
                        if(countPlayer2 == ShipSize.BATTLESHIP.getSize() && playerOneMap[xShoot][yShoot].contains(ShipType.BATTLESHIP.getShipType())){
                            System.out.println("YOU SUNK THE " + ShipType.BATTLESHIP + "!");
                            countPlayer2 = 0;
                        }
                        if(countPlayer2 == ShipSize.CARRIER1.getSize() && playerOneMap[xShoot][yShoot].contains(ShipType.CARRIER1.getShipType())){
                            System.out.println("YOU SUNK THE " + ShipType.CARRIER1 + "!");
                            countPlayer2 = 0;
                        }
                        if(countPlayer2 == ShipSize.CARRIER2.getSize() && playerOneMap[xShoot][yShoot].contains(ShipType.CARRIER2.getShipType())){
                            System.out.println("YOU SUNK THE " + ShipType.CARRIER2 + "!");
                            countPlayer2 = 0;
                        }

                        battleMap1[xShoot][yShoot] = RED_BACKGROUND_BRIGHT + SquareState.HIT.getSquareSymbol() + ANSI_RESET + ANSI_BLUE;
                        hitBarPlayer2 += SquareState.HIT.getSquareSymbol();
                        hitsPlayer2++;
                    }
                }
            }

            if(playerOneMap[xShoot][yShoot].contains(SquareState.NONE.getSquareSymbol())) {
                System.out.println("MISS! " + "\n");
                battleMap1[xShoot][yShoot] = BLACK_BACKGROUND_BRIGHT + SquareState.MISS.getSquareSymbol() + ANSI_RESET + ANSI_BLUE;
            }

            System.out.println("MAP OF PLAYER " + player1);
            gameMap.printBattle(battleMap1, xShoot, yShoot, "battle");

            if (hitsPlayer2 == 20) {
                System.out.println(player2 + " WINS! GAME OVER FOR: " + player1);
                break;
            }

            System.out.println("Number of hits for " + player1 + " is: " + hitsPlayer1);
            System.out.println(ANSI_WHITE_BACKGROUND + winBar + ANSI_RESET);
            System.out.println(RED_BACKGROUND_BRIGHT + hitBarPlayer1 + ANSI_RESET);
            System.out.println("Number of hits for " + player2 + " is: " + hitsPlayer2);
            System.out.println(ANSI_WHITE_BACKGROUND + winBar + ANSI_RESET);
            System.out.println(RED_BACKGROUND_BRIGHT + hitBarPlayer2 + ANSI_RESET);

        }while(true);
    }


    public void placeShips(String[][] playerMap, String playerName) {
        int submarineSize = 3;
        int destroyerSize = 2;
        int cruiserSize = 4;
        int battleshipSize = 5;
        int carrier1Size = 3;
        int carrier2Size = 3;

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
                    gameMap.printPlayerMapShips(playerMap, submarineSize, submarine);
                    break;
                case DESTROYER:
                    gameMap.printPlayerMapShips(playerMap, destroyerSize, destroyer);
                    break;
                case CRUISER:
                    gameMap.printPlayerMapShips(playerMap, cruiserSize, cruiser);
                    break;
                case BATTLESHIP:
                    gameMap.printPlayerMapShips(playerMap, battleshipSize, battleship);
                    break;
                case CARRIER1:
                    gameMap.printPlayerMapShips(playerMap, carrier1Size, carrier1);
                    break;
                case CARRIER2:
                    gameMap.printPlayerMapShips(playerMap, carrier2Size, carrier2);
                    break;
                default:
                    System.out.println("Incorrect");
                    break;
            }
        }
    }
}
