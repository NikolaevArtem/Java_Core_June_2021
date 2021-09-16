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
    private Player player;
    private Player computer;
    private InputConsoleReader inputConsoleReader;
    private InputFileReader inputFileReader;

    public Game() throws FileNotFoundException {
        this.inputConsoleReader = new InputConsoleReader();
        this.inputFileReader = new InputFileReader();

        this.player = new HumanPlayer(inputConsoleReader);
        this.computer = new ComputerPlayer(inputFileReader);
    }

    public void play() {
        System.out.println("Hi there, ready to play?");

        try {
            setShips();
            printPlaygrounds();

        } catch (IOException e) {
            e.printStackTrace();
        } catch (WrongInputException e) {
            System.out.println(e.getMessage());
        } catch (InterruptedException e) {
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

    private void setShips() throws IOException, WrongInputException, InterruptedException {
        System.out.println(player.getPlayground().toStringMine());
        player.setShips();

        System.out.println("Setting ships for computer...\n");
        computer.setShips();

        //imitating AI thinking while setting ships
        Thread.sleep(2000);
    }

    private void printPlaygrounds() {
        System.out.println("Computers playground:");
        System.out.println(computer.getPlayground().toStringOthers());
        System.out.println("Your playground:");
        System.out.println(player.getPlayground().toStringMine());
    }
}
