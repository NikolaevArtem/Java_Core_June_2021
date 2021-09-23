package homework_4.singleton;

public class Main {

    public static void main(String[] args) {
        Singleton singleton = Singleton.getInstance();
        Singleton secondSingleton = Singleton.getInstance();

        System.out.println(singleton == secondSingleton);
    }
}
