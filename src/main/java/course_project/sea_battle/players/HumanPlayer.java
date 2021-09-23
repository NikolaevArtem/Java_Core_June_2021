package course_project.sea_battle.players;

import course_project.sea_battle.input_readers.InputConsoleReader;
import course_project.sea_battle.input_readers.InputFileReader;
import course_project.sea_battle.playground.CellData;
import course_project.sea_battle.playground.Playground;
import course_project.sea_battle.ships.Ship;
import course_project.sea_battle.ships.ShipType;
import homework_2.WrongInputException;
import lombok.Getter;

import java.io.IOException;

@Getter
public class HumanPlayer extends Player {
    private Playground playground;

    public HumanPlayer(InputFileReader inputReader, InputConsoleReader inputConsoleReader) {
        super(inputReader, inputConsoleReader);
        this.playground = new Playground();
    }

    @Override
    public void setShips() throws IOException, WrongInputException {
        Ship[] ships = new Ship[Playground.getShipAmount()];

        for (int i = 0; i < Playground.getShipAmount(); i++) {
            ships[i] = new Ship(ShipType.values()[i], playground);
            new Helper().setShip(ships[i]);
        }
    }

    @Override
    public CellData makeMove() throws IOException, WrongInputException {
        return getInputConsoleReader().readShotData();
    }

    @Override
    public String toString() {
        return "YOU";
    }

    public String toStringWhose() {
        return "YOUR";
    }
}
