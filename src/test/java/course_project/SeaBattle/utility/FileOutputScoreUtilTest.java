package course_project.SeaBattle.utility;

import course_project.SeaBattle.models.Player;
import course_project.SeaBattle.services.InitialGameService;
import course_project.SeaBattle.services.PlayerService;
import org.junit.jupiter.api.Test;

import java.io.*;
import java.lang.reflect.Field;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class FileOutputScoreUtilTest {

    @Test
    void givenScores_whenSaveScores_thenCreateFile() {
        Player winner = new Player();
        winner.setName("Winner2021");
        winner.setRemainingAliveSquares(5);

        try {
            Field field = PlayerService.class.getDeclaredField("winnerPlayer");
            field.setAccessible(true);
            field.set(null, winner);

        } catch (NoSuchFieldException | IllegalAccessException e) {
            e.printStackTrace();
        }

        FileOutputScoreUtil.saveScore();

        String filePath = "src/main/resources/ScoresSeaBattle.txt";
        File file = new File(filePath);
        assertTrue(!file.isDirectory() && file.canRead());

        String line = "";
        try (FileReader fileReader = new FileReader(file)) {
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            line = bufferedReader.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }

        assertEquals("Winner2021 - 6", line);

    }
}