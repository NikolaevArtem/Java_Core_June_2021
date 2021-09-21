package course_project.sea_battle.service.inputs;

import java.util.Scanner;

public abstract class InputReader {
    protected Scanner scanner;

    public String readLine() {
        return scanner.nextLine();
    }

    public Scanner getScanner() {
        return scanner;
    }
}
