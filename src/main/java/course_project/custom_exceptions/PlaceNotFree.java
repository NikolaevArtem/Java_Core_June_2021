package course_project.custom_exceptions;

public class PlaceNotFree extends Exception {

    public PlaceNotFree() {
        super("Invalid place for ship: this place is already occupied by another ship or another ship is too close");
    }
}
