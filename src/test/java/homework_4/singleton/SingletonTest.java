package homework_4.singleton;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class SingletonTest {

    @Test
    void testSingleton() {
        Singleton singleGameHero = Singleton.getInstance("Dobrynya");
        Singleton singleGameHero2 = Singleton.getInstance("Ilya");

        Assertions.assertEquals(singleGameHero.getName(), singleGameHero2.getName());
        Assertions.assertEquals(singleGameHero.getAge(), singleGameHero2.getAge());
        Assertions.assertSame(singleGameHero, singleGameHero2);
    }

    @Test
    void testWithChangingSingleton() {
        Singleton singleGameHero = Singleton.getInstance("Dobrynya");
        Singleton singleGameHero2 = Singleton.getInstance("Ilya");

        singleGameHero.setAge(20);
        singleGameHero2.setAge(30);
        singleGameHero.setName("Alosha");
        singleGameHero.setName("Svyatogog");

        Assertions.assertEquals(singleGameHero.getName(), singleGameHero2.getName());
        Assertions.assertEquals(singleGameHero.getAge(), singleGameHero2.getAge());
        Assertions.assertSame(singleGameHero, singleGameHero2);
    }
}