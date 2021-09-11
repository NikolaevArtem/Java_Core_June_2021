package homework_3.library;

import java.util.Calendar;
import java.util.GregorianCalendar;

public class Main {
    public static void main(String[] args) {
        LibraryCard lc;

        try {
            lc = LibraryCard.initializeNewLibraryCard(new Author(" ", "France", "19"),
                    "Les Misérables",
                    new GregorianCalendar(2020, Calendar.JANUARY, 1),
                    1248,
                    null);
        } catch (IllegalArgumentException e) {
            System.out.println("Error! No author, title, year of publishing or number of pages!");
            return;
        }
        System.out.println(lc);
    }
}
