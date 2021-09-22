package course_project.util;

import course_project.parts.Bot;
import course_project.parts.Player;

public class Game {
    Player player;
    Bot bot;

    public Game(Player player, Bot bot) {
        this.player = player;
        this.bot = bot;
    }

    public void startGame() {
        PrinterOfMap printerOfMap = new PrinterOfMap();
        boolean myWinnerFlag = false;
        boolean enemyWinnerFlag = false;
        while (!myWinnerFlag && !enemyWinnerFlag) {
            System.out.println("-----Союзное поле-----");
            printerOfMap.printPlayerField(player.getMyField());
            System.out.println("----Поле противника----");
            printerOfMap.printBotField(player.getEnemyField());
            System.out.println("Наш ход:");
            if (player.shoot()) {
                System.out.println("Попадание во вражеский корабль!");
                myWinnerFlag = player.isWinner();
                continue;
            } else {
                System.out.println("Промах!");
            }
            System.out.println("\nХод противника:");
            while (true) {
                if (bot.shoot()) {
                    System.out.println("Противник попал в союзный корабль!");
                } else {
                    System.out.println("Противник промахнулся!");
                    break;
                }
                enemyWinnerFlag = bot.isWinner();
                if (enemyWinnerFlag) break;
            }
        }
        endOfGame(myWinnerFlag, enemyWinnerFlag);

    }

    private void endOfGame(boolean my, boolean bot) {
        if (my && bot) {
            System.out.println("-*-*-*-*-*-*-*-*-*-\nНичего, " + player.getName() + ", ничья - тоже результат.\n-*-*-*-*-*-*-*-*-*-");
        } else if (my) {
            System.out.println("-*-*-*-*-*-*-*-*-*-\n" + player.getName() + ", Поздравлю с победой!\n-*-*-*-*-*-*-*-*-*-");
        } else if (bot) {
            System.out.println("-*-*-*-*-*-*-*-*-*-\nНе расстраивайся, " + player.getName() + ", в следующий раз обязательно победишь!\n-*-*-*-*-*-*-*-*-*-");
        }
    }
}
