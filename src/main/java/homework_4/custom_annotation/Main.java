package homework_4.custom_annotation;

public class Main {
    public static void main(String[] args) {
        Guitar guitar1 = new Guitar();
        System.out.println(guitar1);
        Guitar guitar2 = new Guitar("Mh-250", "ESP-LTD", 2004, 719);
        System.out.println(guitar2);
    }
}
