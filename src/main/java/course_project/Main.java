package course_project;

public class Main {

    public static void main(String[] args) {
        new SeaBattle().run(args.length > 0 && "testMode".equals(args[0]));
    }

}
