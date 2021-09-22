package course_project.sea_battle.service;

import course_project.sea_battle.model.Player;
import course_project.sea_battle.service.inputs.InputShipReader;
import lombok.SneakyThrows;

public class NameSetter {
    private final InputShipReader inputShipReader;

    public NameSetter(InputShipReader inputShipReader) {
        this.inputShipReader = inputShipReader;
    }

    @SneakyThrows
    public void setNames(Player player1, Player player2) {
        System.out.println("Player 1, please, input your name:");
        String player1Name = inputShipReader.readLine();
        player1.setName(player1Name);
        System.out.println("Hello, " + player1Name + "!");

        System.out.println("Player 2, please, input your name:");
        String player2Name = inputShipReader.readLine();
        player2.setName(player2Name);
        System.out.println("Hello, " + player2Name + "!");

    }

}
