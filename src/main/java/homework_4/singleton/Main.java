package homework_4.singleton;

public class Main {
    public static void main(String[] args) {
        Singleton firstInstance = Singleton.getInstance();
        System.out.println(firstInstance.getClass().getSimpleName());
        Singleton secondInstance = Singleton.getInstance();
        System.out.println(firstInstance == secondInstance);
    }
}
