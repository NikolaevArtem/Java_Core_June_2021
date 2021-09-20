package course_project.sea_battle.view;

import java.util.Scanner;
import java.util.stream.Stream;

public class BigSpace {
    private static final String FINISH = "Press ENTER to finish your move";

    private BigSpace() {
    }

    public static void bigSpace() {
        System.out.println(FINISH);
        String str = new Scanner(System.in).nextLine();

        Stream.generate(() -> ".")
                .limit(5)
                .forEach(System.out::println);
    }

}
