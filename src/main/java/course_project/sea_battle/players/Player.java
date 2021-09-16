package course_project.sea_battle.players;

import course_project.sea_battle.playground.CellData;
import course_project.sea_battle.ships.Ship;
import course_project.sea_battle.utils.ShotResultCode;
import course_project.sea_battle.input_readers.InputReader;
import course_project.sea_battle.playground.Playground;
import course_project.sea_battle.playground.PlaygroundCell;
import homework_2.WrongInputException;
import lombok.Getter;


import java.io.IOException;

@Getter
public abstract class Player {
    private Playground playground;
    private InputReader inputReader;

    public Player(InputReader inputReader) {
        this.inputReader = inputReader;
    }

    public abstract void setShips() throws IOException, WrongInputException;

    abstract CellData makeMove();

    abstract ShotResultCode checkOwnField(CellData cellData);

    class Helper {

        void setShip(Ship ship) throws IOException, WrongInputException {
            for (int i = 0; i < ship.getShipType().getLength(); i++) {
                CellData data = inputReader.readShotData();
                //TODO: check if the cells are together
                PlaygroundCell currentCell = getPlayground().getCell(data);
                currentCell.setOccupied(true);
                currentCell.setShip(ship);
            }
        }
    }
}
