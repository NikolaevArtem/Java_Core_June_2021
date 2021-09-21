package homework_4.singleton;

import java.util.UUID;

public class DatabaseConnection {

    private String userName;
    private UUID sessionID;

    private static DatabaseConnection instance;

    //Private constructor to avoid instantiation
    private DatabaseConnection(String userName) {
        this.userName = userName;
        this.sessionID = UUID.randomUUID(); //should be received from db
        String message = String.format("Database connection instantiated for user %s  with uuid %s", userName, sessionID);
        System.out.println(message);
    }

    //Double-checked locking design pattern to avoid several instantiations in multithreading
    public static DatabaseConnection getInstance(String userName) {
        if (instance == null) {
            synchronized (DatabaseConnection.class) {
                if (instance == null) {
                instance = new DatabaseConnection(userName);
                }
            }
        }
        return instance;
    }

}
