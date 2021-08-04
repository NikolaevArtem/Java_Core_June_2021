package homework_4.Singleton;

public class MySingleton {
    private static MySingleton singleton;

    private MySingleton() {

    }

    public synchronized static MySingleton getInstance() {
        if (singleton == null) {
            singleton = new MySingleton();
        }
        return singleton;
    }

}
