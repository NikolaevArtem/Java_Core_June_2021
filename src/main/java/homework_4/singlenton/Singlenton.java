package homework_4.singlenton;

public final class Singlenton {
    private static Singlenton instance;

    private Singlenton(){}

    public static Singlenton getInstance(){
        if(instance == null)
            instance = new Singlenton();
        return instance;
    }

}
