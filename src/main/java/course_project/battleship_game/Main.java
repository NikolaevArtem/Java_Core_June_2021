package course_project.battleship_game;

import course_project.battleship_game.controller.GameController;
import course_project.battleship_game.controller.GameControllerImpl;

public class Main {

    public static void main(String[] args) {
        GameController controller = new GameControllerImpl();
        controller.run();
    }
}