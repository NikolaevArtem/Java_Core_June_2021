package homework_3;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;

/*
The class and his fields must have a final modifier
The class don't must have setters
Fields must have a private modifier
The constructor should do defensive copy for reference object
Defensive copy to reference object should be for getters
 */
public final class MyImmutableClass {
    private final String myName;
    private final int myAge;
    private final Map<String, String> myPassword;

    public MyImmutableClass(String myName) {
        this.myName = myName;
        this.myAge = LocalDate.now().getYear();
        Map<String, String> map = new HashMap<>();
        map.put("epam", "12345");
        map.put("ok.com", "qwerty");
        this.myPassword = map;
    }

    public MyImmutableClass(String myName, int myAge) {
        this.myName = myName;
        this.myAge = myAge;
        Map<String, String> map = new HashMap<>();
        map.put("epam", "12345");
        map.put("ok.com", "qwerty");
        this.myPassword = map;
    }

    public MyImmutableClass(String myName, int myAge, Map<String, String> myPassword) {
        this.myName = myName;
        this.myAge = myAge;
        this.myPassword = new HashMap<>(myPassword);
    }

    public String getMyName() {
        return myName;
    }

    public int getMyAge() {
        return myAge;
    }

    public Map<String, String> getMyPassword() {
        return new HashMap<>(myPassword);
    }

    public MyImmutableClass getNewMyImmutableClass(MyImmutableClass myOldImmutableClass, String myNewName) {
        return new MyImmutableClass(myNewName, myOldImmutableClass.getMyAge(), myOldImmutableClass.getMyPassword());
    }

    public MyImmutableClass getNewMyImmutableClass(MyImmutableClass myOldImmutableClass, int myNewAge) {
        return new MyImmutableClass(myOldImmutableClass.getMyName(), myNewAge, myOldImmutableClass.getMyPassword());
    }

    public MyImmutableClass getNewMyImmutableClass(MyImmutableClass myOldImmutableClass, Map<String, String> myNewPassword) {
        return new MyImmutableClass(myOldImmutableClass.getMyName(), myOldImmutableClass.getMyAge(), myNewPassword);
    }

    public MyImmutableClass getNewMyImmutableClass(String myNewName, int myNewAge, Map<String, String> myNewPassword) {
        return new MyImmutableClass(myNewName, myNewAge, myNewPassword);
    }
}
