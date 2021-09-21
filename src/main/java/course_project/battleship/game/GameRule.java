package course_project.battleship.game;


import course_project.battleship.player.Player;
import course_project.battleship.utils.Position;

public class GameRule {
    private final static int WIN_STREAK = 20;

    public static boolean isWinCondition(Player player) {
        int counter = 0;
        for (int i = 0; i < player.getMonitorField().getField().length; i++) {
            for (int j = 0; j < player.getMonitorField().getField().length; j++) {
                if (player.getMonitorField().getField()[i][j].getState() == Position.State.HIT) {
                    counter++;
                }
            }
        }
        return counter >= WIN_STREAK;
    }
}
