package course_project.sea_battle.players;

import course_project.sea_battle.input_readers.InputConsoleReader;
import course_project.sea_battle.playground.CellData;
import course_project.sea_battle.playground.Playground;
import course_project.sea_battle.ships.Ship;
import course_project.sea_battle.ships.ShipType;
import course_project.sea_battle.utils.ShotResultCode;
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
        final int SHIP_AMOUNT = 5;
        Ship[] ships = new Ship[SHIP_AMOUNT];

        for (int i = 0; i < SHIP_AMOUNT; i++) {
            ships[i] = new Ship(ShipType.values()[i]);
            System.out.println("Let's set " + ships[i].getShipType().name() + " (" + ships[i].getShipType().getLength() + " cells):");
            new Helper().setShip(ships[i]);
            System.out.println("Ship " + ships[i].getShipType().name() + " set successfully!");
            System.out.println(playground.toStringMine());
        }
    }

    @Override
    CellData makeMove() {
        //read the console
        //..

        //return ShotData
        return new CellData('A', 4);
    }

    @Override
    ShotResultCode checkOwnField(CellData cellData) {
        //somehow use playground
        //..

        return ShotResultCode.MISS;
    }
}
