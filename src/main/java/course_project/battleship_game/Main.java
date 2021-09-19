package course_project.battleship_game;

import course_project.battleship_game.controller.GameController;

public class Main {

    public static void main(String[] args) {
        GameController controller = new GameController();
        controller.run();
    }
}