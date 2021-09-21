package course_project.player;

import course_project.board.Battlefield;

public class Player {

    private final boolean isComputer;
    private final String name;
    private final Battlefield battlefield;

    public Player(String name, boolean isComputer) {
        this.isComputer = isComputer;
        this.name = name;
        this.battlefield = new Battlefield();
    }

    public boolean isComputer() {
        return this.isComputer;
    }

    public String getName() {
        return this.name;
    }

    public Battlefield getField() {
        return this.battlefield;
    }
}
