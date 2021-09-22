package course_project.services;

import course_project.services.conversation.DialogueMenu;

/**
 *  Start of SeaBattle game;
 */
public final class SeaBattle {

    private SeaBattle() {
    }

    private static class SeaBattleHelper {
        private static final SeaBattle INSTANCE = new SeaBattle();
    }

    public static SeaBattle getInstance() {
        return SeaBattleHelper.INSTANCE;
    }

    public void run() {
        DialogueMenu.printGreetings();
        DialogueMenu.printMainMenu();
    }

}
