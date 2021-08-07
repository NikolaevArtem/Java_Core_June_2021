package homework_4.singleton;

public class Main {
    public static void main(String[] args) {
    Singleton singleton = Singleton.getInstance ();
    Singleton singleton2 = Singleton.getInstance ();
        System.out.println (singleton.getName () + " " + singleton.getId ());
        System.out.println (singleton2.getName () + " " + singleton2.getId ());
    }
}
