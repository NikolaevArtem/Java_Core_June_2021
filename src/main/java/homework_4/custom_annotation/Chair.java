package homework_4.custom_annotation;

import java.time.DayOfWeek;

@ChairConstructorAnnotation(dayOfProducing = DayOfWeek.MONDAY)
public abstract class Chair {

    @Info
    public final int legs;
    @Info
    public final boolean hasBack;
    @Info
    public final String shape;
    @Info
    public final String[] materials;
    @Info
    public final DayOfWeek dayOfProducing;

    public Chair() {
        ChairConstructorAnnotation ca = this.getClass().getAnnotation(ChairConstructorAnnotation.class);
        this.legs = ca.legs();
        this.hasBack = ca.hasBack();
        this.materials = ca.materials();
        this.shape = ca.shape();
        this.dayOfProducing = ca.dayOfProducing();
    }
}
