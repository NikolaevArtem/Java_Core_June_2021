package homework_2.utils;

public enum Applications {
    PYRAMID_PRINTER(1),
    TRAFFIC_LIGHT(2);

    private int num;

    Applications(int num) {
        this.num = num;
    }

    @Override
    public String toString() {
        return this.name() +
                " №  \t" + num;
    }
}
