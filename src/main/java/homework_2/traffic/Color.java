package homework_2.traffic;

public enum Color {
    GREEN(0, 35),
    YELLOW,
    RED(40, 55);

    private int start;
    private int end;

    Color() {
    }

    Color(int start, int end) {
        this.start = start;
        this.end = end;
    }

    public static Color check(int sec) {
        if (sec >= GREEN.start && sec < GREEN.end) {
            return GREEN;
        } else if (sec >= RED.start && sec < RED.end) {
            return RED;
        } else {
            return YELLOW;
        }
    }
}
