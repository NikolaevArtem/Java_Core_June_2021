package course_project.sea_battle.controller.impl;

import course_project.sea_battle.controller.*;
import course_project.sea_battle.model.CellStatus;
import course_project.sea_battle.model.Game;
import course_project.sea_battle.model.GamePlayer;

public final class GameControllerImpl implements GameController{
    private final PlayerController playerController = PlayerControllerImpl.getInstance();
    private final IOController ioController = IOControllerImpl.getInstance();
    private final FieldFillController manualFieldFillService = ManualFieldFillController.getInstance();
    private final FieldFillController randomFieldFillController = RandomFieldFillController.getInstance();
    private final FieldController fieldController = FieldControllerImpl.getInstance();
    private final FireController fireController = FireControllerImpl.getInstance();
    private final ShipController shipController = ShipControllerImpl.getInstance();

    private GameControllerImpl() {}

    public Game start() {
        Game game = new Game();
        addPlayers(game);
        setShips(game.getPlayer1());
        ioController.dialog("Позовите Следующего");
        ioController.clr();
        setShips(game.getPlayer2());
        ioController.dialog("Да начнется битва");
        ioController.clr();

        doGame(game);
        ioController.close();
        return game;
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

    private void setShips(GamePlayer player) {
        ioController.print(player.getName() + ", установите корабли!");
        boolean nextStep = false;
        while (!nextStep) {
            String answerP1 = ioController.dialog("Заполнить рандомно?(y/n):");
            if (answerP1.trim().toLowerCase().matches("y")) {
                randomFieldFillController.setShips(player.getFieldPlayer());
                nextStep = true;
            } else if (answerP1.trim().toLowerCase().matches("n")) {
                manualFieldFillService.setShips(player.getFieldPlayer());
                nextStep = true;
            } else {
                ioController.print("Попробуйте еще раз");
            }
        }
    }

    private void doGame(Game game){
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

            ioController.clr();
            if (!turnResult(playerAtk, playerDef)) {
                isPlayer1Move = !isPlayer1Move;
            }
            isGameOver = !shipController.isAnyShipAlive(playerDef.getFieldPlayer());
        }
        ioController.print(playerAtk.getName() + " Выйграл!");
        ioController.print(playerDef.getName() + " Проиграл!");
        fieldController.drawFields(playerAtk.getFieldPlayer(), playerAtk.getRadarPlayer(),
                playerDef.getFieldPlayer(), playerDef.getRadarPlayer());
        game.setPlayerWin(playerAtk);
    }

    private boolean turnResult(GamePlayer playerAtk, GamePlayer playerDef) {
        ioController.dialog(playerAtk.getName() + ", Ваш ход!");
        fieldController.drawFields(playerAtk.getFieldPlayer(), playerAtk.getRadarPlayer());
        String coordinate;
        do coordinate = ioController.dialog("Координаты:");
        while (!fireController.checkFire(playerAtk.getRadarPlayer(), coordinate));
        CellStatus cellStatus = fireController.fire(playerDef.getFieldPlayer(),
                playerAtk.getRadarPlayer(),
                coordinate);
        fieldController.drawFields(playerAtk.getFieldPlayer(), playerAtk.getRadarPlayer());
        if (cellStatus != CellStatus.HIT) {
            ioController.dialog("Мимо!");
            ioController.clr();
            return false;
        } else {
            ioController.dialog("Попали!");
            return true;
        }
    }

    public static GameControllerImpl getInstance() {
        return GameControllerImpl.Holder.INSTANCE;
    }

    private static class Holder {
        static final GameControllerImpl INSTANCE = new GameControllerImpl();
    }
}
