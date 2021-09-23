package course_project.sea_battle;

import course_project.sea_battle.input_readers.InputConsoleReader;
import course_project.sea_battle.input_readers.InputFileReader;
import course_project.sea_battle.players.ComputerPlayer;
import course_project.sea_battle.players.HumanPlayer;
import course_project.sea_battle.players.Player;
import homework_2.WrongInputException;

import java.io.FileNotFoundException;
import java.io.IOException;

public class Game {
    private final Player player;
    private final Player computer;

    private final InputConsoleReader inputConsoleReader;
    private final InputFileReader inputFileReaderComp;
    private final InputFileReader inputFileReaderPlayer;

    public Game() throws FileNotFoundException {
        this.inputConsoleReader = new InputConsoleReader();
        try {
            this.inputFileReaderComp = new InputFileReader("computer_ships_sets");
            this.inputFileReaderPlayer = new InputFileReader("computer_ships_sets");
        } catch (FileNotFoundException e) {
            throw new FileNotFoundException("Input files might be damaged. Please look at resources folder");
        }

        this.player = new HumanPlayer(inputFileReaderPlayer, inputConsoleReader);
        this.computer = new ComputerPlayer(inputFileReaderComp);
    }

    public void play() throws InterruptedException, IOException, WrongInputException {
        System.out.println("Hi there, ready to play?");
        Player winner;

        try {
            Gameplay gameplay = new Gameplay(player, computer);
            gameplay.setShips();

//            gameplay.printPlaygrounds();

            winner = gameplay.getWinner();
            gameplay.printCongratsToWinner(winner);

        } catch (IOException e) {
            throw new IOException("Please check input files in resources folder", e);
        } catch (InterruptedException e) {
            throw new InterruptedException("Couldn't simulate computer thinking, it got interrupted");
        } finally {
            try {
                inputConsoleReader.close();
                inputFileReaderComp.close();
                inputFileReaderPlayer.close();
            } catch (IOException e) {
                throw new IOException("Couldn't manage to close resources", e);
            }
        }
    }
}
