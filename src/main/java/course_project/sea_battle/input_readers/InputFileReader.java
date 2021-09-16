package course_project.sea_battle.input_readers;

import course_project.sea_battle.playground.CellData;
import course_project.sea_battle.utils.RandomGenerator;
import homework_2.WrongInputException;

import java.io.*;

public class InputFileReader extends InputReader {
    private final int NUMBER_OF_COMPUTER_SHIPS_SETS = 3;
    private final BufferedReader br;

    public InputFileReader() throws FileNotFoundException {
        super("Can't set computers ships. Check resource folder for sets text files.");
        br = new BufferedReader(new FileReader("src/main/resources/course_project/computer_ships_sets/" + getFileName()));
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

    private String getFileName() {
        return "set" + RandomGenerator.getRandomInRange(1, NUMBER_OF_COMPUTER_SHIPS_SETS) + ".txt";
    }
}
