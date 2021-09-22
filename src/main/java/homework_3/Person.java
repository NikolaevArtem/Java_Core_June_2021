package homework_3;

import java.util.ArrayList;
import java.util.List;
/*
Class must be declared as final;
All members must be private;
There are no setters;
Getters must return copies of mutable objects;
Parameterized constructor must perform Deep Copy.
 */

public final class Person {
    private final int age;
    private final String name;
    private final ArrayList<String> hobbies;

    public int getAge() {
        return age;
    }

    public String getName() {
        return name;
    }

    public List<String> getHobbies() {
        if (hobbies != null){
            return new ArrayList<>(hobbies);
        }
        return new ArrayList<>();
    }

    public Person(int age, String name, List<String> listHobbies) {
        this.age = age;
        this.name = name;
        this.hobbies = new ArrayList<>(listHobbies);
    }

    public Person(int age, String name) {
        this.hobbies = null;
        this.age = age;
        this.name = name;
    }

    public Person addNewHobby (String hobby){
        List<String> updatedHobbyList = getHobbies();
        updatedHobbyList.add(hobby);
        return new Person(age, name, updatedHobbyList);
    }

    public static void main(String[] args) {
        ArrayList<String> listHobbies = new ArrayList<>();
        listHobbies.add("Dancing");
        listHobbies.add("Travelling");

        Person me = new Person(27, "Tom", listHobbies);
        System.out.println("Me before changes = " + me);

        me = me.addNewHobby("Painting");
        System.out.println("Me after changes = " + me);
    }

    @Override
    public String toString() {
        return "Person{" +
                "age=" + age +
                ", name='" + name + '\'' +
                ", hobbies=" + hobbies +
                '}';
    }

}

