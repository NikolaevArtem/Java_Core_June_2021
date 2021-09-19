package course_project.SeaBattle.utility;

import course_project.SeaBattle.service.PlayerService;

import java.io.*;

public class FileOutputScoreUtil {

    public static void saveScore() {

        String filePath = "src/main/resources/ScoresSeaBattle.txt";
        String playerScore = PlayerService.getWinner().getName() + " - " + PlayerService.getScore() + "\n";

        try {
            FileWriter writer = new FileWriter(filePath, true);
            BufferedWriter bufferWriter = new BufferedWriter(writer);
            bufferWriter.write(playerScore);
            bufferWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
