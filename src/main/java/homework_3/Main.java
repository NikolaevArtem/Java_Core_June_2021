package homework_3;

public class Main {

    public static void main(String[] args) {
        Engine engine = new Engine();

        System.out.println(engine);

        engine.getSpec().add("add new line");

        System.out.println(engine);
    }

}
