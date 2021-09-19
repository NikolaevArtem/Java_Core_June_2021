package course_project.SeaBattle.services;

import base.UnitBase;
import course_project.SeaBattle.models.Player;
import course_project.SeaBattle.utility.FileOutputScoreUtil;
import course_project.SeaBattle.utility.SquareStatus;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Field;

import static org.junit.jupiter.api.Assertions.*;

class PlayerServiceTest extends UnitBase {

    @Test
    void givenPlayer_WhenFire_thenEnemyHaveHit() {

        Player player1 = new Player();
        Player player2 = new Player();

        GridService.createGrid(player1);
        GridService.createGrid(player2);

        player1.setEnemy(player2);
        player2.setEnemy(player1);

        setInput("g5");
        PlayerService.fire(player1);
        assertEquals(SquareStatus.MISSED, player2.getGrid().getSquare(6, 4).getSquareStatus());
        assertEquals(SquareStatus.OCEAN, player2.getGrid().getSquare(5, 4).getSquareStatus());
        assertEquals(SquareStatus.OCEAN, player2.getGrid().getSquare(7, 4).getSquareStatus());
        assertEquals(SquareStatus.OCEAN, player2.getGrid().getSquare(6, 3).getSquareStatus());
        assertEquals(SquareStatus.OCEAN, player2.getGrid().getSquare(6, 5).getSquareStatus());
    }

    @Test
    void givenWinner_whenGetScores_thenReceiveScores() {
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

        assertEquals(6, PlayerService.getScore());
    }

}