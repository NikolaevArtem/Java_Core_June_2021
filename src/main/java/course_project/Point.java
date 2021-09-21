package course_project;

import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

class Point {

    private final int x;
    private final int y;
    private MapPointType type;

    Point(String consoleInput) {

        int y = IntStream.iterate(65, i -> i+1)
                .limit(10)
                .mapToObj(i -> String.valueOf((char) i))
                .collect(Collectors.toList())
                .indexOf(consoleInput.substring(0,1));
        this.x = Integer.parseInt(consoleInput.substring(1))-1;
        this.y = y;
    }

    Point(int x, int y, MapPointType type) {
        this.x = x;
        this.y = y;
        this.type = type;
    }

    int getX() {
        return x;
    }

    int getY() {
        return y;
    }

    void setType(MapPointType type) {
        this.type = type;
    }

    MapPointType getType() {
        return type;
    }

    String getView(GameStatus status) {
        if (status == GameStatus.Battle) {
            return getBattleView();
        }
        else {
            return getSettingShipsView();
        }
    }

    private String getSettingShipsView() {
        if (getType() == MapPointType.Ship) {
            return "\u25B2" + " ";
        }
        return "  ";
    }

    private String getBattleView() {
        switch (getType()
        ) {
            case FiredShip: return "\u2713" + " ";
            case Fired: return "\u00D7" + " ";
            default: return "  ";
        }
    }


    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Point point = (Point) o;
        return x == point.x && y == point.y;
    }

    @Override
    public int hashCode() {
        return Objects.hash(x, y);
    }
}
