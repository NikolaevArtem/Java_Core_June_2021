package homework_4.custom_annotation;

import java.time.DayOfWeek;
import java.util.Arrays;

@ChairConstructor(dayOfProducing = DayOfWeek.MONDAY)
public abstract class Chair {

    final int legs;
    final boolean hasBack;
    final String shape;
    final String[] materials;
    final DayOfWeek dayOfProducing;

    public Chair() {
        ChairConstructor ca = this.getClass().getAnnotation(ChairConstructor.class);
        this.legs = ca.legs();
        this.hasBack = ca.hasBack();
        this.materials = ca.materials();
        this.shape = ca.shape();
        this.dayOfProducing = ca.dayOfProducing();
    }

    @Override
    public String toString() {
        return this.getClass().getSimpleName() + ": \n" +
                "legs = " + legs + ": \n" +
                "back is " + (hasBack ? "present" : "absent") + "\n" +
                "shape - " + shape + "\n" +
                "used materials: " + Arrays.toString(materials).replaceAll("[\\[\\]]", "") + "\n" +
                "day of producing: " + dayOfProducing + "\n";
    }
}
