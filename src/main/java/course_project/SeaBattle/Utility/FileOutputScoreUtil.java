package course_project.SeaBattle.Utility;

import course_project.SeaBattle.Services.PlayerService;

import java.io.FileNotFoundException;
import java.io.PrintWriter;

public class FileOutputScoreUtil {

    public static void saveScore() {
        String playerScore = PlayerService.getWinner().getName() + " - "+ PlayerService.getScore();
        try (PrintWriter out = new PrintWriter("ScoresSeaBattle.txt")) {
            out.println(playerScore);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}
