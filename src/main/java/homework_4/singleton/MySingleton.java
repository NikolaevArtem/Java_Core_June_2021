package homework_4.singleton;

public class MySingleton {
    private static MySingleton mySingleton;

    private String singletonName;

    private MySingleton(String singletonName) {
        this.singletonName = singletonName;
    }

    public static MySingleton getInstance(String singletonName) {
        if (mySingleton == null) {
            mySingleton = new MySingleton(singletonName);
        }
        return mySingleton;
    }
}
