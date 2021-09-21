package course_project.battleship.game;

public class GameMode {
    private Mode mode;

    public GameMode() {
    }

    public enum Mode {
        PVP,
        PVE
    }

    public Mode getMode() {
        return mode;
    }

    public void setMode(Mode mode) {
        this.mode = mode;
    }
}
