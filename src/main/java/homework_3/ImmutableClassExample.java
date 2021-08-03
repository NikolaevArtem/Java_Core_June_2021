package homework_3;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

// 1) The class must be declared as final so it can’t be extended.
// 2) All fields have to be private so that direct access is not allowed.
// 3) Setter methods for variables must not be provided.
// 4) All mutable fields must be final so that its value can be assigned only once.
// 5) All the fields must be initialized via a constructor performing deep copy.
// 6) Cloning of objects in the getter methods should be used to return a copy rather than returning the actual object reference.

public final class ImmutableClassExample {
    private final int id;
    private final String name;
    private final char[] password;
    private final HashMap<String, String> testMap;

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public HashMap<String, String> getTestMap() {
        return (HashMap<String, String>) testMap.clone();
    }

    public char[] getPassword() {
        return (char[]) password.clone();
    }

    public ImmutableClassExample() {
        this.id = 0;
        this.name = "User name";
        HashMap<String, String> tMap = new HashMap<>();
        tMap.put("key", "value");
        this.testMap = tMap;
        this.password = new char[]{'p', 'a', 's', 's', 'w', 'o', 'r', 'd'};
    }

    public ImmutableClassExample(int realId) {

        this.id = realId;
        this.name = "User name";
        HashMap<String, String> tMap = new HashMap<>();
        tMap.put("key", "value");
        this.testMap = tMap;
        this.password = new char[]{'p', 'a', 's', 's', 'w', 'o', 'r', 'd'};
    }

    public ImmutableClassExample(int realId, String realName) {
        this.id = realId;
        this.name = realName;
        HashMap<String, String> tMap = new HashMap<>();
        tMap.put("key", "value");
        this.testMap = tMap;
        this.password = new char[]{'p', 'a', 's', 's', 'w', 'o', 'r', 'd'};
    }

    public ImmutableClassExample(int realId, String realName, HashMap<String, String> realMap) {
        this.id = realId;
        this.name = realName;
        this.testMap = realMap;
        this.password = new char[]{'p', 'a', 's', 's', 'w', 'o', 'r', 'd'};
    }


    public ImmutableClassExample(int realId, String realName, HashMap<String, String> realMap, char[] realPassword) {
        this.id = realId;
        this.name = realName;
        this.testMap = realMap;
        this.password = realPassword;
    }
    public ImmutableClassExample getImmutableClassExample(ImmutableClassExample oldICE){
        return new ImmutableClassExample(oldICE.getId(), oldICE.getName(), oldICE.getTestMap(), getPassword());
    }
    public ImmutableClassExample getImmutableClassExample(ImmutableClassExample oldICE, int newId){
        return new ImmutableClassExample(newId, oldICE.getName(), oldICE.getTestMap(), oldICE.getPassword());
    }
    public ImmutableClassExample getImmutableClassExample(ImmutableClassExample oldICE, int newId, String newName){
        return new ImmutableClassExample(newId, newName, oldICE.getTestMap(), oldICE.getPassword());
    }
    public ImmutableClassExample getImmutableClassExample(ImmutableClassExample oldICE, int newId, String newName, HashMap<String,String> newMap){
        return new ImmutableClassExample(newId, newName, newMap, oldICE.getPassword());
    }
    public ImmutableClassExample getImmutableClassExample(ImmutableClassExample oldICE, int newId,String newName, HashMap<String,String> newMap, char[] newPassword){
        return new ImmutableClassExample(newId, newName, newMap, newPassword);
    }
}
