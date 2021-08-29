package homework_6.mapProblemsGenerator;

import java.util.HashMap;
import java.util.Map;

public class MapProblemsGenerator {

    public void runCatIssue() {
        createCatsMapWithCollisionsInHashCode();
    }

    public void runDogIssue() {
        createDogsMapWithLoosingDogs();
    }

    private void createCatsMapWithCollisionsInHashCode() {
        Map<Cat, String> map = new HashMap<>();
        Cat cat1 = new Cat(3);
        Cat cat2 = new Cat(5);
        map.put(cat1, "Snezhok");
        map.put(cat2, "Kris");
        catInfo(cat1, cat2);
    }

    private static void catInfo(Cat cat1, Cat cat2) {
        System.out.println("cat1.equals(cat2): " + cat1.equals(cat2));
        System.out.println("cat1.hashCode() == cat2.hashCode(): " + (cat1.hashCode() == cat2.hashCode()));
    }

    private void createDogsMapWithLoosingDogs() {
        Map<Dog, String> map = new HashMap<>();
        Dog dog = new Dog(3);
        map.put(dog, "Lapka");
        dogInfo(dog, map);
        dogGrows(dog);
        dogInfo(dog, map);
    }

    private void dogGrows(Dog dog) {
        System.out.println("dog grows...");
        dog.setAge(dog.getAge() + 1);
    }

    private static void dogInfo(Dog dog, Map<Dog, String> map) {
        System.out.println("map.containsKey(dog) = " + map.containsKey(dog));
    }

}
