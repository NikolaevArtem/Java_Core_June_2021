package course_project.custom_exceptions;

public class CoordinatesNumber extends Exception{

    public CoordinatesNumber() {
        super("Number of coordinates don't fit ship length");
    }
}
