package homework_4.singleton;

public enum EnumSingleton {

    //This approach has serialization and thread-safety guaranteed by the enum implementation itself,
    // which ensures internally that only the single instance is available,
    // correcting the problems pointed out in the class-based implementation.

    INSTANCE;

    EnumSingleton() {
    }

    public static EnumSingleton getInstance() {
        return INSTANCE;
    }

}
