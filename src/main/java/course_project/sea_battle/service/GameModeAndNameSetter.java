package course_project.sea_battle.service;

import course_project.sea_battle.model.Player;
import course_project.sea_battle.service.inputs.InputShipReader;
import lombok.SneakyThrows;

public class GameModeAndNameSetter {
    private final InputShipReader inputShipReader;
    private static final String SHOOSEGAMEMODE = "Please, choose game mode:\n1: player vs player\n2: player vs computer";
    private static final String PL1 = "Player 1, please, input your name:";
    private static final String PL2 = "Player 2, please, input your name:";
    private int gameMode;

    public GameModeAndNameSetter(InputShipReader inputShipReader) {
        this.inputShipReader = inputShipReader;
    }

    @SneakyThrows
    public void setNames(Player player1, Player player2) {

        defineGameMode();

        System.out.println(PL1);
        String player1Name = inputShipReader.readLine();
        player1.setName(player1Name);
        System.out.println("Hello, " + player1Name + "!");

        if (gameMode == 1) {
            System.out.println(PL2);
            String player2Name = inputShipReader.readLine();
            player2.setName(player2Name);
            System.out.println("Hello, " + player2Name + "!");
        } else if (gameMode == 2) {
            player2.setName("Computer");
            player2.setComputer(true);
        }
    }

    private void defineGameMode() {
        while (true) {
            System.out.println(SHOOSEGAMEMODE);
            String gameModeInput = inputShipReader.readLine();
            if (gameModeInput.matches("[1]|[2]")) {
                gameMode = Integer.parseInt(gameModeInput);
                break;
            }
        }
    }

}
