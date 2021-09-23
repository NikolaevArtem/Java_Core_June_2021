package course_project.sea_battle.service;

import course_project.sea_battle.model.Player;
import course_project.sea_battle.service.inputs.InputReader;
import lombok.SneakyThrows;

import static course_project.sea_battle.utils.Constants.*;

public class GameModeAndNameSetter {
    private final InputReader inputReader;

    private int gameMode;

    public GameModeAndNameSetter(InputReader inputReader) {
        this.inputReader = inputReader;
    }

    @SneakyThrows
    public void setNames(Player player1, Player player2) {

        defineGameMode();

        System.out.println(PL1);
        String player1Name = inputReader.readLine();
        player1.setName(player1Name);
        System.out.println("Hello, " + player1Name + "!");

        if (gameMode == 1) {
            System.out.println(PL2);
            String player2Name = inputReader.readLine();
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
            String gameModeInput = inputReader.readLine();
            if (gameModeInput.matches("[1]|[2]")) {
                gameMode = Integer.parseInt(gameModeInput);
                break;
            }
        }
    }

}
