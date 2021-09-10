package homework_6.map_problems_generator;

import java.util.*;

public class MapProblemsGenerator {
    public void run() {

        HashMap<CollisionClass, String> collisionMap = new HashMap<>();

        collisionMap.put(new CollisionClass(new GregorianCalendar(1905, 1,2)), "Ayn Rand");
        collisionMap.put(new CollisionClass(new GregorianCalendar(1905, 8,18)), "Greta Garbo");
        collisionMap.put(new CollisionClass(new GregorianCalendar(1905, 11,30)), "Daniil Harms");

        System.out.println("The same year of birth -> the same hashcode -> the same bucket:");
        collisionMap.forEach((key, value) -> System.out.println("hashcode " + key.hashCode() + ": " + key + ", " + value));
        System.out.println();

        HashMap<MutableClass, String> mutableMap = new HashMap<>();

        MutableClass aynRandDateOfBirth = new MutableClass(new GregorianCalendar(1905, 1,2));
        MutableClass gretaGarboDateOfBirth = new MutableClass(new GregorianCalendar(1905, 8,18));
        MutableClass daniilHarmsDateOfBirth = new MutableClass(new GregorianCalendar(1905, 11,30));

        mutableMap.put(aynRandDateOfBirth, "Ayn Rand");
        mutableMap.put(gretaGarboDateOfBirth, "Greta Garbo");
        mutableMap.put(daniilHarmsDateOfBirth, "Daniil Harms");
        mutableMap.forEach((key, value) -> System.out.println("hashcode " + key.hashCode() + ": " + key.toString() + ", " + value));

        System.out.println("Each time new hashcode of the same element -> each time new bucket for element searching:");
        System.out.println("Ayn Rand searching: " + mutableMap.get(aynRandDateOfBirth));
        System.out.println("Greta Garbo searching: " + mutableMap.get(gretaGarboDateOfBirth));
        System.out.println("Daniil Harms searching: " + mutableMap.get(daniilHarmsDateOfBirth));
    }
}

