package homework_3;

import java.util.ArrayList;
/*
Class must be declared as final;
All members must be private;
There are no setters;
Getters must return copies of mutable objects;
Parameterized constructor must perform Deep Copy.
 */

public final class ImmutableClass {
    private final int age;
    private final String name;
    private final ArrayList<String> hobbies;

    public int getAge() {
        return age;
    }

    public String getName() {
        return name;
    }

    public ArrayList<String> getHobbies() {
        return (ArrayList<String>) hobbies.clone();
    }

    public ImmutableClass(int age, String name, ArrayList<String> listHobbies) {
        ArrayList<String> tempList = new ArrayList<>(listHobbies);
        this.age = age;
        this.name = name;
        this.hobbies = tempList;
    }

    public static void main(String[] args) {
        ArrayList<String> listHobbies = new ArrayList<>();
        listHobbies.add("dances");
        listHobbies.add("travel");

        int age = 27;
        String name = "Tom";
        ImmutableClass immutableClass = new ImmutableClass(age, name, listHobbies);

        System.out.println(immutableClass.getAge());
        System.out.println(immutableClass.getName());
        System.out.println(immutableClass.getHobbies());
    }
}

