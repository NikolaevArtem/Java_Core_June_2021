package course_project.custom_exceptions;

public class InvalidShip extends Exception {

    public InvalidShip() {
        super("Invalid place for ship! It should be horizontal, vertical and solid structure");
    }
}
