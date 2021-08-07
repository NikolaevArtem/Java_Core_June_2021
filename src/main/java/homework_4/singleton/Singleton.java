package homework_4.singleton;

public final class Singleton {

    private static Singleton instance;
    private final int id;
    private final String name;

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    private Singleton(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public static Singleton getInstance() {
        if (instance == null) {
            instance = new Singleton (1, "Chel");
        }
        return instance;
    }
}
