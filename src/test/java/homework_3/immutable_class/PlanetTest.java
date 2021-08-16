package homework_3.immutable_class;

import base.UnitBase;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;


public class PlanetTest extends UnitBase {

    @Test
    void givenNoFields_whenRun_thenGetObject(){
        Planet planet = new Planet();
        int age = planet.getAge();
        int speed = planet.getSpeed();
        String name = planet.getName();

        assertEquals(0, age);
        assertEquals(10000, speed);
        assertEquals(null, name);
    }

    @Test
    void givenFullFields_whenRun_thenGetObject(){

        Planet planet = new Planet(13,"zuza",74000);
        String name = planet.getName();
        int age = planet.getAge();
        int speed = planet.getSpeed();

        assertEquals(13, age);
        assertEquals(74000, speed);
        assertEquals("zuza", name);
    }

    @Test
    void givenNotFullFields_whenRun_thenGetObject(){
        Planet planet = new Planet("oliver");
        String name = planet.getName();

        assertEquals("oliver", name);
    }

    @Test
    void givenNewPlanet_whenRun_thenGetObject(){
        Planet planet = new Planet("Rin");
        Planet newPlanet = planet.setSpeed(67000);
        int age = planet.getAge();
        int speed = planet.getSpeed();
        String name = planet.getName();

        int n_age = newPlanet.getAge();
        int n_speed = newPlanet.getSpeed();
        String n_name = newPlanet.getName();

        assertEquals("Rin", name);
        assertEquals(0, age);
        assertEquals(10000, speed);

        assertEquals("Rin", n_name);
        assertEquals(67000, n_speed);
        assertEquals(0, n_age);

    }


}
