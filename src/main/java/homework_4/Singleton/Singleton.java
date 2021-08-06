package homework_4.Singleton;

public final class Singleton {
    private static Singleton INSTANCE;
    public final String name;

    private Singleton(String name) {
     this.name = name;
    }

    public static Singleton getInstance(String str){
        if (INSTANCE == null){
            INSTANCE = new Singleton(str);
        }
        return INSTANCE;
    }
}
