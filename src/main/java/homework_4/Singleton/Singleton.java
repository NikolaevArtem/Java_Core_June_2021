package homework_4.Singleton;

//Basic Singleton

public class Singleton {
    private static Singleton uniqueInstance;

    private Singleton() {
    }

    public static Singleton getInstance() {
        if (uniqueInstance == null) {
            uniqueInstance = new Singleton();
        }
        return uniqueInstance;
    }
}

//Thread safe realization of Singleton

class SingletonThreadSafe {
    private static volatile SingletonThreadSafe uniqueInstance;

    private SingletonThreadSafe() {
    }

    public static SingletonThreadSafe getInstance() {
        if (uniqueInstance == null) {
            synchronized (SingletonThreadSafe.class) {
                uniqueInstance = new SingletonThreadSafe();
            }
        }
        return uniqueInstance;
    }
}
