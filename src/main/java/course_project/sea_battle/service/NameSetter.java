package course_project.sea_battle.service;

import course_project.sea_battle.model.Player;

import java.util.Scanner;

public class NameSetter {

    private NameSetter() {
    }

    public static void setNames(Player player1, Player player2){
        Scanner scanner = new Scanner(System.in);

        System.out.println("Player 1, please, input your name");
        String player1Name = scanner.nextLine();
        player1.setName(player1Name);
        System.out.println("Hello, " + player1Name + "!");

        System.out.println("Player 2, please, input your name");
        String player2Name = scanner.nextLine();
        player2.setName(player2Name);
        System.out.println("Hello, " + player2Name + "!");

        System.out.println("Press ENTER to start the game");
        String str = scanner.nextLine();
    }
}
