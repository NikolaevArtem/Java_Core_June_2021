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
    private final InputFileReader inputFileReader;

    public Game() throws FileNotFoundException {
        this.inputConsoleReader = new InputConsoleReader();
        this.inputFileReader = new InputFileReader();

        this.player = new HumanPlayer(inputConsoleReader);
        this.computer = new ComputerPlayer(inputFileReader);
    }

    public void play() {
        System.out.println("Hi there, ready to play?");
        Player winner;

        try {
            Gameplay gameplay = new Gameplay(player, computer);
            gameplay.setShips();

            gameplay.printPlaygrounds();

            winner = gameplay.getWinner();
            gameplay.printCongratsToWinner(winner);

        } catch (IOException e) {
            e.printStackTrace();
        } catch (WrongInputException e) {
            System.out.println(e.getMessage());
        } catch (InterruptedException e) {
            //TODO: exception handling (everywhere)
            e.printStackTrace();
        } finally {
            try {
                inputConsoleReader.close();
                inputFileReader.close();
            } catch (IOException e) {
                System.out.println("IO Exception");
            }
        }
    }
}
