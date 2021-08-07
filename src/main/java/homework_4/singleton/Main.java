package homework_4.singleton;

public class Main {

    public static void main(String[] args) {
        Singleton singleton = Singleton.getInstance();
        Singleton singleton1 = Singleton.getInstance();
        if (singleton == singleton1) {
            System.out.println("yes");
        }
    }
}
