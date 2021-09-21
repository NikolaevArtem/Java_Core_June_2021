package course_project.sea_battle;

import course_project.sea_battle.controller.impl.GameControllerImpl;
import course_project.sea_battle.controller.impl.IOControllerImpl;

public class SeaBattleApp {
    public static void main(String[] args) {
        try {
            GameControllerImpl.getInstance().start();
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            IOControllerImpl.getInstance().close();
        }
    }
}
