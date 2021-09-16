package course_project.sea_battle.players;

import course_project.sea_battle.input_readers.InputFileReader;
import course_project.sea_battle.playground.CellData;
import course_project.sea_battle.playground.Playground;
import course_project.sea_battle.ships.Ship;
import course_project.sea_battle.ships.ShipType;
import homework_2.WrongInputException;
import lombok.Getter;

import java.io.IOException;

@Getter
public class ComputerPlayer extends Player {

    private final Playground playground;

    public ComputerPlayer(InputFileReader inputReader) {
        super(inputReader);
        this.playground = new Playground();
    }

    @Override
    public void setShips() throws IOException, WrongInputException {
        final int SHIP_AMOUNT = 5;
        Ship[] ships = new Ship[SHIP_AMOUNT];

        for (int i = 0; i < SHIP_AMOUNT; i++) {
            ships[i] = new Ship(ShipType.values()[i], playground);
            new Helper().setShip(ships[i]);
        }
    }

    @Override
    public CellData makeMove() {
        // TODO: might be some more complex logic
        // check if it is hit or missed at least
        CellData cellData = CellData.generateCellData();
        return cellData;
//        return RandomGenerator.getRandomCellData();
    }

    @Override
    public String toString() {
        return "COMPUTER";
    }

    public String toStringWhose() {
        return "COMPUTER'S";
    }
}
