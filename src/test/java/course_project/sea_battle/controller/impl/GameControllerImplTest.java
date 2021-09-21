package course_project.sea_battle.controller.impl;

import course_project.sea_battle.controller.*;
import course_project.sea_battle.model.CellStatus;
import course_project.sea_battle.model.Field;
import course_project.sea_battle.model.Game;
import course_project.sea_battle.model.GamePlayer;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

class GameControllerImplTest {
    GameController gameController = GameControllerImpl.getInstance();
    IOControllerImpl ioController = IOControllerImpl.getInstance();
    FieldFillController randomFieldFillController = ManualFieldFillController.getInstance();
    final String firstPlayerName = "First player";
    final String secondPlayerName = "Second player";

    @BeforeEach
    void set() {
        // Это не тест, а скорее игра в игру по сценарию.
        // В игре каждый игрок ставит по 2 коробля (1 и 2 клетки)
        // сделано от безисходности, так как не знаю как еще написать тут что то.
        // но можно проверить


        final String input = "" +
                firstPlayerName + "\n" +  //вводится имя 1го
                secondPlayerName + "\n" + //вводится имя 2го
                "n\n" + "a1\n" + "v\n" + "c1\n" + "v\n" +   // говорим что руками поставим корабли и ставим a1 и с1 оба вертикально
                "\n" +  // передаем ход
                "n\n" + "d1\n" + "G\n" + "g1\n" + "G\n" +   // выставляем так же корабли
                "\n" +  // начинаем игру
                "\n" + "a1\n" + "\n" +  // принимаем ход, делаем выстрел мимо, передаем ход
                "\n" + "a1\n" + "\n" + "\n" + "a2\n" + "\n" + "\n" + "c1\n" + "\n"; // делаем 3 выстрела, и выигрываем

        ioController.setScanner(new Scanner(input));

        randomFieldFillController.setGameSetupHolder(() -> {
            Map<Integer, Integer> map = new TreeMap<>(Comparator.reverseOrder());
            map.put(1, 1);
            map.put(2, 1);
            return map;
        });
    }

    @Test
    void TestWinner() {
        Game game = gameController.start();

        GamePlayer playerWin = game.getPlayerWin();

        Field fieldPlayer = playerWin.getFieldPlayer();
        Field radarPlayer = playerWin.getRadarPlayer();

        assertEquals(firstPlayerName, game.getPlayer1().getName());
        assertEquals(secondPlayerName, game.getPlayer2().getName());
        assertEquals(secondPlayerName, game.getPlayerWin().getName());

        assertTrue(ShipControllerImpl.getInstance().isAnyShipAlive(fieldPlayer));

        assertEquals(3,
                Arrays.stream(radarPlayer.getCells())
                        .flatMap(Arrays::stream)
                        .filter(x -> x.equals(CellStatus.HIT))
                        .count());
    }
}