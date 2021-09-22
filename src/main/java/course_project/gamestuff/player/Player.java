package course_project.gamestuff.player;

import course_project.gamestuff.field.Battlefield;

public class Player {

    private final boolean computer;
    private final String name;
    private final Battlefield battlefield;

    public Player(String name, boolean isComputer) {
        this.computer = isComputer;
        this.name = name;
        this.battlefield = new Battlefield();
    }

    public boolean isComputer() {
        return this.computer;
    }

    public String getName() {
        return this.name;
    }

    public Battlefield getField() {
        return this.battlefield;
    }

}
