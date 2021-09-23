package couse_project;

import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException, InterruptedException {
        SeaMap mapOne = new SeaMap();
        SeaMap mapTwo = new SeaMap();

        Player playerOne = new Player("Lera", mapOne, mapTwo);
        RandomIntelligence playerTwo = new RandomIntelligence(mapTwo, mapOne);

        Game gameSession = new Game(playerOne, playerTwo);
        gameSession.startGame();
    }
}
