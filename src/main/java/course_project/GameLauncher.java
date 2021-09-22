package course_project;

import course_project.sea_battle.Game;
import homework_2.WrongInputException;

import java.io.IOException;

public class GameLauncher {

    void launch() {
        try {
            new Game().play();
        } catch (InterruptedException | IOException | WrongInputException e) {
            System.out.println(e.getMessage());
        }
    }
}
