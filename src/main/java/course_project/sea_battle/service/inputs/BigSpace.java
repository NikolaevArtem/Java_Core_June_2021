package course_project.sea_battle.service.inputs;

import java.util.Scanner;
import java.util.stream.Stream;

public class BigSpace extends InputReader {

    private static final String FINISH = "Press ENTER to finish your move";

    public BigSpace(Scanner scanner) {
        this.scanner = scanner;
    }

    public void printBigSpace() {
        System.out.println(FINISH);
        readLine();

        Stream.generate(() -> ".")
                .limit(5)
                .forEach(System.out::println);
    }

}
