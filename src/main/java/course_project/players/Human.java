package course_project.players;

import course_project.field_components.Coordinate;
import course_project.input_readers.InputReader;

public class Human extends Player {

    private InputReader reader;

    public Human(InputReader reader) {
        this.reader = reader;
    }

    @Override
    public Coordinate move() {
        System.out.print("Your turn. Input coordinate: ");
        while (true) {
            Coordinate shot = Coordinate.get(reader.takeInput());
            if (shot != null) {
                return shot;
            } else {
                System.out.println("Invalid input. Try again.");
            }
        }
    }

}
