package course_project.objects;

import course_project.enums.CellStatus;
import course_project.enums.Response;
import course_project.objects.Move;
import course_project.objects.fields.ComputerField;
import course_project.objects.fields.Field;
import course_project.objects.fields.UserField;
import course_project.services.ShipLocationGenerator;

import java.util.List;

public class GameData {

    private final ComputerField computerField;
    private final UserField userField;
    private int computerShips = 10;
    private int userShips = 10;

    public GameData() {
        computerField = new ComputerField();
        userField = new UserField();
        new ShipLocationGenerator().generateShips(computerField);
    }

    public Field getComputerField() {
        return computerField;
    }

    public Field getUserField() {
        return userField;
    }

    public int getComputerShips() {
        return computerShips;
    }

    public int getUserShips() {
        return userShips;
    }

    public Response getResponseFromComputer(Move move) {
        Response response = computerField.getResponse(move);
        if (response == Response.KILLED) {
            computerShips--;
        }
        return response;
    }

    public void saveComputerMoveResult(Response response, Move move, List<Move> lastHit) {
        if (response == Response.KILLED) {
            userField.setVisitedAroundShip(lastHit);
            userShips--;
        }
        userField.setCellStatus(move.getX(), move.getY(), CellStatus.VISITED);
    }

    public boolean isUserFleetEmpty() {
        return userShips == 0;
    }

    public boolean isComputerFleetEmpty() {
        return computerShips == 0;
    }

}
