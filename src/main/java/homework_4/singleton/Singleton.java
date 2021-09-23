package homework_4.singleton;

public class Singleton {
    private static Singleton instance;
    private int x;
    public String value;

    private Singleton(String value) {
        x = 0;
        this.value = value;
    }

    public static Singleton getInstance(String value) {
        if (instance == null) {
            instance = new Singleton(value);
        }
        return instance;
    }

    public void Set(int newX) {
        x = newX;
    }

    public void Print() {
        System.out.println("x = " + x);
    }
}
