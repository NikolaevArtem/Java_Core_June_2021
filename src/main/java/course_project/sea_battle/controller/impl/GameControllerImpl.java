package course_project.sea_battle.controller.impl;

import course_project.sea_battle.controller.*;
import course_project.sea_battle.model.Game;
import course_project.sea_battle.model.GamePlayer;

public final class GameControllerImpl implements GameController{
    private final PlayerController playerController = PlayerControllerImpl.getInstance();
    private final IOController ioController = IOControllerImpl.getInstance();
    private final GameSetupsController gameSetupsController = GameSetupsController.getInstance();
    private final FieldController fieldController = FieldControllerImpl.getInstance();
    private final FireController fireController = FireControllerImpl.getInstance();
    private final ShipController shipController = ShipControllerImpl.getInstance();

    private GameControllerImpl() {}

    public void start() {
        Game game = new Game();
        addPlayers(game);
        ioController.print(game.getPlayer1().getName() + ", установите корабли!");
        gameSetupsController.setShips(game.getPlayer1().getFieldPlayer());
        ioController.print(game.getPlayer2().getName() + ", ваша очередь установить корабли!");
        gameSetupsController.setShips(game.getPlayer2().getFieldPlayer());
        ioController.print("Да начнется битва");

        doGame(game, 2000);
    }

    private void addPlayers(Game game) {
        String name1;
        String name2;
        do {
            name1 = ioController.dialog("Введите имя первого игрока:");
        } while (name1.isEmpty());
        game.setPlayer1(playerController.instance(name1));
        do {
            name2 = ioController.dialog("Введите имя второго игрока:");
        } while (name2.isEmpty());
        game.setPlayer2(playerController.instance(name2));
    }

    private void doGame(Game game, long nanoSec){
        boolean isPlayer1Move = true;
        boolean isGameOver = false;

        GamePlayer playerAtk = game.getPlayer1();
        GamePlayer playerDef = game.getPlayer2();

        while (!isGameOver) {

            if (isPlayer1Move) {
                playerAtk = game.getPlayer1();
                playerDef = game.getPlayer2();
            } else {
                playerAtk = game.getPlayer2();
                playerDef = game.getPlayer1();
            }

            ioController.print(playerAtk.getName() + ", Ваш ход!");
            fieldController.drawFields(playerAtk.getFieldPlayer(), playerAtk.getRadarPlayer());
            String coordinate;
            do coordinate = ioController.dialog("Координаты:");
            while (!fireController.fire(playerDef.getFieldPlayer(),
                    playerAtk.getRadarPlayer(),
                    coordinate));
            fieldController.drawFields(playerAtk.getFieldPlayer(), playerAtk.getRadarPlayer());
            isPlayer1Move = !isPlayer1Move;
            isGameOver = !shipController.isAnyShipAlive(playerDef.getFieldPlayer());
            try {
                Thread.sleep(nanoSec);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        ioController.print(playerAtk.getName() + " Выйграл!");
        ioController.print(playerDef.getName() + " Проиграл!");
        fieldController.drawFields(playerAtk.getFieldPlayer(), playerAtk.getRadarPlayer(),
                playerDef.getFieldPlayer(), playerDef.getRadarPlayer());
    }

    public static GameControllerImpl getInstance() {
        return GameControllerImpl.Holder.INSTANCE;
    }

    private static class Holder {
        static final GameControllerImpl INSTANCE = new GameControllerImpl();
    }
}
