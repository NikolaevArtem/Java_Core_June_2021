package course_project.sea_battle.players;

import course_project.sea_battle.input_readers.InputConsoleReader;
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

    public HumanPlayer(InputConsoleReader inputReader) {
        super(inputReader);
        this.playground = new Playground();
    }

    @Override
    public void setShips() throws IOException, WrongInputException {
        Ship[] ships = new Ship[Playground.getShipAmount()];

        for (int i = 0; i < Playground.getShipAmount(); i++) {
            ships[i] = new Ship(ShipType.values()[i], playground);
            System.out.println("Let's set " + ships[i].getShipType().name() + " (" + ships[i].getShipType().getLength() + " cells):");
            System.out.println("e.g. A-1");
            new Helper().setShip(ships[i]);
            System.out.println("Ship " + ships[i].getShipType().name() + " set successfully!");
            System.out.println(playground.toStringMine());
        }
    }

    @Override
    public CellData makeMove() throws IOException, WrongInputException {
        return getInputReader().readShotData();
    }

    @Override
    public String toString() {
        return "YOU";
    }

    public String toStringWhose() {
        return "YOUR";
    }
}
