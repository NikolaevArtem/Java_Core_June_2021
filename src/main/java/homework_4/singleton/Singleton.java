package homework_4.singleton;

class Singleton {
    private static volatile Singleton instance = null;
    private Singleton(){
    }
    public static Singleton getInstance() {
        //Double checked locking for correct operation in multithreaded applications
        if (instance == null) {
            synchronized (Singleton.class) {
                if (instance == null) {
                    instance = new Singleton();
                }
            }
        }
        return instance;
    }
}
