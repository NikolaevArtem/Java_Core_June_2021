package homework_4.singleton;

public class Singleton {

    private static Singleton singletonInstance;
    private String state = "created";

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    private Singleton() {}

    public static Singleton getInstance() {
        if (singletonInstance == null) {
            singletonInstance = new Singleton();
        }
        return singletonInstance;
    }

}
