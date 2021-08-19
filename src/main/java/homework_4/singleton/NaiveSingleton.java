package homework_4.singleton;

public final class NaiveSingleton {

    //A private constructor
    //A static field containing its only instance
    //A static factory method for obtaining the instance
    //Note that it can be problematic in multithreading scenarios.
    private static NaiveSingleton INSTANCE;

    private NaiveSingleton() {
    }

    public static NaiveSingleton getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new NaiveSingleton();
        }

        return INSTANCE;
    }

}
