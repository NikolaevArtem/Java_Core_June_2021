package course_project.objects;

public class Move {

    private final int x;
    private final int y;

    public Move(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public Move(String move) {
        x = move.charAt(0) - 65;
        y = Integer.parseInt(move.substring(1)) - 1;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    @Override
    public String toString() {
        return (char) (x + 65) + "" + (y + 1);
    }
}
