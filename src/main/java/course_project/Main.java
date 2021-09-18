package course_project;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class Main {
    private static final List<String> fillingFields = Arrays.asList(
            " ", "A1", "A5", "A3", "A7",
            "J1 I1", "C7 C6", "C1 C2",
            "J10 H10", "H7 J7", "F1 F4",

            " ", "A1", "A5", "A3", "A7",
            "J1 I1", "C7 C6", "C1 C2",
            "J10 H10", "H7 J7", "F1 F4",

            " ",
            "F1", "F2", "F3", "F4", " ", " ",
            "E1", " ", " ",
            "J10", "I10", "H10", " ", " ",
            "E2", " ", " ",
            "J7", "I7", "H7", " ", " ",
            "E3", " ", " ",
            "J1", "I1", " ", " ",
            "E4", " ", " ",
            "C7", "C6", " ", " ",
            "E5", " ", " ",
            "C1", "C2", " ", " ",
            "E6", " ", " ",
            "A7", " ", " ",
            "E7", " ", " ",
            "A5", " ", " ",
            "E8", " ", " ",
            "A3", " ", " ",
            "E9", " ", " ",

            "A1"
    );

    public static void main(String[] args) {
        SeaBattle sb = new SeaBattle();
        Iterator<String> iterator = fillingFields.iterator();

//        sb.setReader(() -> iterator.next());
        sb.run();
    }
}
