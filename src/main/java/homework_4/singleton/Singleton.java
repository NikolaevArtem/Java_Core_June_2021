package homework_4.singleton;

public class Singleton {
    private static Singleton instance;
    private String someString;

    private Singleton(String someString) {
        this.someString = someString;
    }

    public static Singleton getInstance(String someString) {
        if (instance == null) {
            instance = new Singleton(someString);
        }
        return instance;
    }
}
