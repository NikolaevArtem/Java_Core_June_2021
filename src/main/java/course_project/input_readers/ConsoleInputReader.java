package course_project.input_readers;

import java.util.Scanner;

public class ConsoleInputReader implements InputReader {
    private final Scanner scanner = new Scanner(System.in);

    @Override
    public String takeInput() {
        return scanner.nextLine();
    }
}
