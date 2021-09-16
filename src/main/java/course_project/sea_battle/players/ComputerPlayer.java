package course_project.sea_battle.players;

import course_project.sea_battle.input_readers.InputFileReader;
import course_project.sea_battle.playground.CellData;
import course_project.sea_battle.playground.Playground;
import course_project.sea_battle.ships.Ship;
import course_project.sea_battle.ships.ShipType;
import course_project.sea_battle.utils.ShotResultCode;
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
            ships[i] = new Ship(ShipType.values()[i]);
            new Helper().setShip(ships[i]);
        }
    }

    @Override
    CellData makeMove() {
        // somehow figure next move data
        // randomly or need to apply some algorithm
        //..

        return new CellData('J', 3);
    }

    @Override
    ShotResultCode checkOwnField(CellData cellData) {
        return ShotResultCode.MISS;
    }
}
