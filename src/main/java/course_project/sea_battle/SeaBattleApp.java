package course_project.sea_battle;

import course_project.sea_battle.controller.impl.GameControllerImpl;

public class SeaBattleApp {
    public static void main(String[] args) {
        GameControllerImpl.getInstance().start();
    }
}
