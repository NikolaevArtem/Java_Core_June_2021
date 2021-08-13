package homework_4.singleton;

import lombok.Data;
import java.util.Random;


@Data
public class Singleton {
    private static volatile Singleton instance;
    private int age;
    private String name;

    public void run() {
        Singleton singleGameHero2 = Singleton.getInstance("Ilya");

        System.out.println(this.hashCode() + ", age: " + this.getAge() + ", name: " + this.getName());
        System.out.println(singleGameHero2.hashCode() + ", age: " + singleGameHero2.getAge() + ", name: " + singleGameHero2.getName());
    }

    private Singleton() {}

    private Singleton(String name) {
        this.name = name;
        this.age = new Random().nextInt(17) + 34;
    }

    public static Singleton getInstance(String name) {
        Singleton localGameHero = instance;

        if (localGameHero == null) {
            synchronized (Singleton.class) {
                localGameHero = instance;
                if (localGameHero == null) {
                    instance = localGameHero = new Singleton(name);
                }
            }
        }
        return localGameHero;
    }
}

