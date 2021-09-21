package homework_4.singleton;

import java.util.UUID;

//has serialization and thread-safety guaranteed by the enum implementation itself
public enum EnumDatabaseConnection {

    INSTANCE;

    private UUID sessionID;

    EnumDatabaseConnection() {
        this.sessionID = UUID.randomUUID(); //should be received from db
        String message = String.format("Database connection instantiated with uuid %s", sessionID);
        System.out.println(message);
    }

    //Double-checked locking design pattern to avoid several instantiations in multithreading
    public EnumDatabaseConnection getInstance() {
        return INSTANCE;
    }



}
