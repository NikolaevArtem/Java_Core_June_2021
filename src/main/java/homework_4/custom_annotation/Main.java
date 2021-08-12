package homework_4.custom_annotation;

import java.time.DayOfWeek;

public class Main {


    private static class CheapChair extends Chair { }

    @ChairConstructorAnnotation(shape = "circle",
            materials = {"wood", "cotton", "pad", "plastic"},
            hasBack = true,
            dayOfProducing = DayOfWeek.THURSDAY)
    private static class SoftChair extends Chair { }


    private static class Cat {
        @Info
        public int age;
        @Info
        public String name;
        @Info
        public String[] toys;

        public Cat(int age, String name) {
            this.age = age;
            this.name = name;
        }

    }

    public static void main(String[] args) {
        Chair c = new CheapChair();
        Chair sc = new SoftChair();
        InfoProcessor ip = new InfoProcessor();
        ip.printInfo(c);
        ip.printInfo(sc);

        Cat cat = new Cat(10, "Bobby");
        ip.printInfo(cat);

    }
}
