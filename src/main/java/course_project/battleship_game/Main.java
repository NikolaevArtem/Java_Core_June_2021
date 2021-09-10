package course_project.battleship_game;

import course_project.battleship_game.model.Game;
import course_project.battleship_game.model.GameImpl;

public class Main {

    public static void main(String[] args) {
        Game game = new GameImpl();
        game.run();
    }
}