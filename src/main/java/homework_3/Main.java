package homework_3;

import homework_3.immutable_class.Planet;

public class Main {

    public static void main(String[] args) {
        Planet planet1 = new Planet("7890");
        System.out.println(planet1);
        Planet planet2 = planet1.setSpeed(34);
        System.out.println(planet2);

    }
}
