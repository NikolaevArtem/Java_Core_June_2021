package course_project.sea_battle;

import course_project.sea_battle.conroller.SeaBattle;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        SeaBattle game = new SeaBattle();
        game.run();
    }
}
