package homework_4.singleton;

public class Singleton {
    private static Singleton instance = null;

    private Singleton(){}

    /*
     * Reason to do double check and make second check synchronized:
     * most of the time instance won't be null,
     * so there's no need to restrict threads access to the first if-clause.
     * If there is a real suspicion that instance might be null, then
     * we double check in sync block
     */
    public static Singleton getInstance() {
        if (instance == null) {
            synchronized (Singleton.class) {
                    if (instance == null) {
                        instance = new Singleton();
                    }
            }
        }
        return instance;
    }
}
