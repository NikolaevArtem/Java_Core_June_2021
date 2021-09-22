package course_project.sea_battle.model;

public class GamePlayer extends BasePlayer{
    private Field fieldPlayer;
    private Field radarPlayer;

    public GamePlayer(String name) {
        super(name);
    }

    public Field getFieldPlayer() {
        return fieldPlayer;
    }

    public void setFieldPlayer(Field fieldPlayer) {
        this.fieldPlayer = fieldPlayer;
    }

    public Field getRadarPlayer() {
        return radarPlayer;
    }

    public void setRadarPlayer(Field radarPlayer) {
        this.radarPlayer = radarPlayer;
    }
}
