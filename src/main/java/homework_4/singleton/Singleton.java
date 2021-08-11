package homework_4.singleton;

public class Singleton {

    private static Singleton INSTANCE;
    private static String nameOfInstance;

    private Singleton(String nameOfInstance) {
        Singleton.nameOfInstance = nameOfInstance;
    }

    public static Singleton getInstance(String nameOfInstance) {
        if (INSTANCE == null) {
            INSTANCE = new Singleton(nameOfInstance);
        }
        return INSTANCE;
    }

    public String getNameOfInstance() {
        return nameOfInstance;
    }
}
