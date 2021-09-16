package course_project.sea_battle.input_readers;

import course_project.sea_battle.playground.CellData;
import homework_2.WrongInputException;

import java.io.*;

public class InputConsoleReader extends InputReader {
    private BufferedReader br;

    public InputConsoleReader() throws FileNotFoundException {
        super("Can't parse input. Please, follow the format: [char A-J]-[integer 1-10]");

        // temporary reading user ships set from file (for quick debugging and testing)
//        br = new BufferedReader(new FileReader(new File("src/main/resources/course_project/sea_battle.txt")));
        br = new BufferedReader(new InputStreamReader(System.in));
    }

    @Override
    public CellData readShotData() throws WrongInputException, IOException {
        String input = br.readLine();
        return parseInput(input);
    }

    @Override
    public void close() throws IOException {
        br.close();
    }
}
