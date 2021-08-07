package homework_4.singleton;

import java.util.Random;

public class Singleton {

    private static Singleton singleton = null;

    private Singleton() {

    }

    public static Singleton getInstance() {
        if (singleton == null) {
            singleton = new Singleton();
        }
        return singleton;
    }

    public Integer getRandom() {
        return new Random().nextInt();
    }
}
