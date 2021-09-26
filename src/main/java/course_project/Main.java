package course_project;

import course_project.Utils.ConsoleHandling.Printer;
import course_project.components.Field;

public class Main {
    public static void main(String[] args) {

        //new SeaBattle().play();

        Field f = new Field();
        new Printer().printHiddenField(f);
    }
}
