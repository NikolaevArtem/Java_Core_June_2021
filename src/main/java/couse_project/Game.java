package couse_project;

import java.io.IOException;

public class Game {
    Player playerOne;
    RandomIntelligence playerTwo;

    public Game(Player playerOne, RandomIntelligence playerTwo) {
        this.playerOne = playerOne;
        this.playerTwo = playerTwo;
    }

    public void startGame() throws IOException, InterruptedException {
        Displayer displayer = new Displayer();
        while (true) {
            displayer.clearScreen();
            displayer.displayMap(playerOne.getMap());
            displayer.displayRadar(playerOne.getRadar());
            if (playerOne.shoot()) {
                System.out.println("Отлично! Сделайте еще один ход:");
                continue;
            }

            while (true) {
                if (playerTwo.shoot()) {
                    System.out.println("Наш корабль попал под обстрел!");
                } else {
                    break;
                }
            }
        }
    }
}
