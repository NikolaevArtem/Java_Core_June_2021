package homework_4.singleton;

/*
    Singleton provides access to CustomFileReader methods through GUI.
    It's the only one instance of GUI able to run (thread-safe).
 */


public class Main {
    public static void main(String[] args) {
        SingletonMenu.getInstance();
    }
}
