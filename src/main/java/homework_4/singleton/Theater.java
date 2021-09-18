package homework_4.singleton;

public class Theater {

    private static Theater instance;
    private final boolean[][] seats;

    private Theater() {
        seats = new boolean[21][11];
    }

    public static Theater getInstance() {
        if (instance == null) {
            instance = new Theater();
        }
        return instance;
    }

    public boolean bookSeat(int row, int seat) {
        if ((row < 1) || (row > 20) || (seat < 1) || (seat > 10)) {
            System.out.println("Invalid seat value");
            return false;
        }
        if (!seats[row][seat]) {
            seats[row][seat] = true;
            return true;
        } else {
            return false;
        }
    }
}
