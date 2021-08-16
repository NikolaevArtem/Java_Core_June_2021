package homework_4.singleton;

public class Singleton {

    private static volatile Singleton INSTANCE;
    private static String nameOfInstance;

    private Singleton(String nameOfInstance) {
        Singleton.nameOfInstance = nameOfInstance;
    }

    public static Singleton getInstance(String nameOfInstance) {
        Singleton local = INSTANCE;
        if (local == null) {
            synchronized (Singleton.class) {
                local = INSTANCE;
                if (local == null) {
                    INSTANCE = local = new Singleton(nameOfInstance);
                }
            }
        }
        return local;
    }

    public String getNameOfInstance() {
        return nameOfInstance;
    }
}
