package course_project.sea_battle.players;

import course_project.sea_battle.input_readers.InputConsoleReader;
import course_project.sea_battle.input_readers.InputFileReader;
import course_project.sea_battle.playground.CellData;
import course_project.sea_battle.playground.CellStatus;
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
    private final InputReader inputReader;
    private final InputConsoleReader inputConsoleReader;

    public Player(InputReader inputReader) {
        this.inputReader = inputReader;
        this.inputConsoleReader = null;
    }

    public Player(InputFileReader inputFileReader, InputConsoleReader inputConsoleReader) {
        this.inputReader = inputFileReader;
        this.inputConsoleReader = inputConsoleReader;
    }

    public abstract void setShips() throws IOException, WrongInputException;

    public abstract CellData makeMove() throws IOException, WrongInputException;

    public ShotResultCode checkOwnField(CellData cellData) {
        PlaygroundCell cell = getPlayground().getCell(cellData);

        if (cell.getStatus() == CellStatus.OCCUPIED) {
            cell.setHit();

            if (cell.getStatus() == CellStatus.KILLED) {
                return ShotResultCode.KILL;
            }
            return ShotResultCode.HIT;
        }
        cell.setStatus(CellStatus.MISSED);
        return ShotResultCode.MISS;
    }

    public boolean isLoser() {
        return getPlayground().getKilledShips() == Playground.getShipAmount();
    }

    public abstract String toStringWhose();

    class Helper {

        void setShip(Ship ship) throws IOException, WrongInputException {
            for (int i = 0; i < ship.getShipType().getLength(); i++) {
                CellData data = inputReader.readShotData();

                PlaygroundCell currentCell = getPlayground().getCell(data);
                currentCell.setStatus(CellStatus.OCCUPIED);
                currentCell.setShip(ship);
                ship.setCell(data);
            }
        }
    }
}
