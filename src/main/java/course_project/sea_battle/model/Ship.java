package course_project.sea_battle.model;

public class Ship implements Ships {

    private boolean orientation;
    int[] startPosition;
    int size;

    public Ship(boolean orientation, int[] startPosition, int size) {
        this.orientation = orientation;
        this.startPosition = startPosition;
        this.size = size;
    }

    @Override
    public int[] getPosition() {
        return startPosition;
    }

    @Override
    public boolean getOrientation() {
        return orientation;
    }

    @Override
    public int getSize() {
        return size;
    }
}
