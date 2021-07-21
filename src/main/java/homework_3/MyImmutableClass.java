package homework_3;

import java.time.LocalDate;

public final class MyImmutableClass {
    private final String myName;
    private final int myAge;
    private final LocalDate myBirthday;

    public MyImmutableClass(String myName) {
        this.myName = myName;
        this.myAge = LocalDate.now().getYear();
        this.myBirthday = LocalDate.now();
    }

    public MyImmutableClass(String myName, int myAge) {
        this.myName = myName;
        this.myAge = myAge;
        this.myBirthday = LocalDate.now();
    }

    public MyImmutableClass(String myName, int myAge, LocalDate myBirthday) {
        this.myName = myName;
        this.myAge = myAge;
        this.myBirthday = myBirthday;
    }

    public String getMyName() {
        return myName;
    }

    public int getMyAge() {
        return myAge;
    }

    public LocalDate getMyBirthday() {
        return myBirthday;
    }

    public MyImmutableClass myClone(MyImmutableClass myOldImmutableClass, String myNewName) {
        return new MyImmutableClass(myNewName, myOldImmutableClass.getMyAge(), myOldImmutableClass.getMyBirthday());
    }

    public MyImmutableClass myClone(MyImmutableClass myOldImmutableClass, int myNewAge) {
        return new MyImmutableClass(myOldImmutableClass.getMyName(), myNewAge, myOldImmutableClass.getMyBirthday());
    }

    public MyImmutableClass myClone(MyImmutableClass myOldImmutableClass, LocalDate myNewBirthday) {
        return new MyImmutableClass(myOldImmutableClass.getMyName(), myOldImmutableClass.getMyAge(), myNewBirthday);
    }

    public MyImmutableClass myClone(String myNewName, int myNewAge, LocalDate myNewBirthday) {
        return new MyImmutableClass(myNewName, myNewAge, myNewBirthday);
    }
}
