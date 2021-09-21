package couse_project;

public class Ship {
    private final int size;
    private final int x;
    private final int y;
    private final boolean rotate;

    public Ship(int size, int x, int y, boolean rotate) {
        this.size = size;
        this.x = x;
        this.y = y;
        this.rotate = rotate;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public int getSize() {
        return size;
    }

    public boolean isRotate() {
        return rotate;
    }

    @Override
    public String toString() {
        return "Ship{" +
                "size=" + size +
                ", x=" + x +
                ", y=" + y +
                ", rotate=" + rotate +
                '}';
    }
}