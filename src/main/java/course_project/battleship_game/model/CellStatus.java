package course_project.battleship_game.model;

public enum CellStatus {
    EMPTY("\uD83C\uDF0A"),
    SHIP("\uD83D\uDEA2"),
    HIT("\u274C"),
    SHIP_BORDER("\uD83C\uDF0A"),
    MISSED("\uD83D\uDD18");

    private final String character;

    CellStatus(String character) {
        this.character = character;
    }

    public String getCharacter() {
        return character;
    }
}