package homework_4.singleton;

public class Singleton {
    private static Singleton INSTANCE;

    public static Singleton getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new Singleton();
        }
        return INSTANCE;
    }

    private Singleton() {
        System.out.println("Singleton created");
    }
}
