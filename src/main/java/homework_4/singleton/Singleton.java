package homework_4.singleton;

public class Singleton {
    private static Singleton instance = null;
    private int x;

    private Singleton() {
        x = 0;
    }

    public static Singleton getInstance() {
        if (instance == null) {
            instance = new Singleton();
            return instance;
        } else {
            return null;
        }

    }

    public void Set(int newX) {
        x = newX;
    }

    public void Print() {
        System.out.println("x = " + x);
    }
}
