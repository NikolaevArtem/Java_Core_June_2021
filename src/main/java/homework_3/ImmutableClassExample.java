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
    private final HashMap<String, String> testMap;

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public HashMap<String, String> getTestMap() {
        return new HashMap<>(testMap);
    }

    public ImmutableClassExample(int id, String name, HashMap<String, String> testMap) {
        this.id = id;
        this.name = name;
        this.testMap = new HashMap<>(testMap);
    }

    public ImmutableClassExample(int id, String name){
        this.id = id;
        this.name = name;
        this.testMap = new HashMap<>();
    }

    public ImmutableClassExample(int id){
        this.id = id;
        this.name = "some name";
        this.testMap = new HashMap<>();
    }

    public ImmutableClassExample(){
        this.id = -1;
        this.name = "name";
        this.testMap = new HashMap<>();
    }
}
