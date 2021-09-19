package course_project.SeaBattle.utility;

import course_project.SeaBattle.model.Player;
import course_project.SeaBattle.service.PlayerService;
import org.junit.jupiter.api.Test;

import java.io.*;
import java.lang.reflect.Field;
import java.util.stream.Collectors;

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
            line  =  bufferedReader.lines().collect(Collectors.joining());
        } catch (IOException e) {
            e.printStackTrace();
        }

        assertTrue(line.contains("Winner2021 - 6"));

    }
}