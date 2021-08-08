package homework_4.singleton;

public class Main {
    public static void main(String[] args) {
        Singleton object1 = Singleton.getInstance();
        if (object1 != null) {
            object1.Set(100);
            object1.Print();
        } else {
            System.out.println("object 1 is null");
        }

        Singleton object2 = Singleton.getInstance();
        if (object2 != null) {
            object2.Set(999);
            object2.Print();
        } else {
            System.out.println("object 2 is null");
        }
    }
}
