package course_project.sea_battle.controller.impl;

import course_project.sea_battle.controller.FieldController;
import course_project.sea_battle.controller.PlayerController;
import course_project.sea_battle.model.GamePlayer;

public final class PlayerControllerImpl implements PlayerController {
    private final FieldController fieldController = FieldControllerImpl.getInstance();
    private PlayerControllerImpl() {}

    @Override
    public GamePlayer instance(String name) {
        GamePlayer player = new GamePlayer(name);
        player.setFieldPlayer(fieldController.instance());
        player.setRadarPlayer(fieldController.instance());
        return player;
    }

    public static PlayerControllerImpl getInstance() {
        return PlayerControllerImpl.Holder.INSTANCE;
    }

    private static class Holder {
        static final PlayerControllerImpl INSTANCE = new PlayerControllerImpl();
    }
}
