package course_project.objects.fields;

import course_project.enums.CellStatus;
import course_project.enums.Response;
import course_project.objects.Cell;
import course_project.objects.Move;
import course_project.objects.fields.Field;

import java.util.Arrays;

public class ComputerField extends Field {

    public ComputerField() {
        for (Cell[] row : table) {
            Arrays.fill(row, new Cell(CellStatus.FREE, false));
        }
    }

    public Response getResponse(Move move) {
        if (table[move.getX()][move.getY()].getStatus() == CellStatus.FREE) {
            table[move.getX()][move.getY()] = new Cell(CellStatus.VISITED, false);
            return Response.MISSED;
        }
        if (table[move.getX()][move.getY()].getStatus() == CellStatus.VISITED) {
            return Response.VISITED;
        }
        if (table[move.getX()][move.getY()].getStatus() == CellStatus.HAS_SHIP) {
            table[move.getX()][move.getY()] = new Cell(CellStatus.VISITED, true);
            int x = move.getX();
            int y = move.getY();
            if (hasShipAround(x, y)) {
                return Response.HIT;
            }
            int prevX = -1;
            int prevY = -1;
            while (true) {
                if (x != 0 && x - 1 != prevX && table[x - 1][y].getStatus() == CellStatus.VISITED && table[x - 1][y].hadShip()) {
                    prevX = x;
                    x--;
                    continue;
                }
                if (x + 1 < 10 && x + 1 != prevX && table[x - 1][y].getStatus() == CellStatus.VISITED && table[x + 1][y].hadShip()) {
                    prevX = x;
                    x++;
                    continue;
                }
                if (y != 0 && y - 1 != prevY && table[x][y - 1].getStatus() == CellStatus.VISITED && table[x][y - 1].hadShip()) {
                    prevY = y;
                    y--;
                    continue;
                }
                if (y + 1 < 10 && y + 1 != prevY && table[x][y + 1].getStatus() == CellStatus.VISITED && table[x][y + 1].hadShip()) {
                    prevY = y;
                    y++;
                    continue;
                }
                if (hasShipAround(x, y)) {
                    return Response.HIT;
                }
                break;
            }
        }
        return Response.KILLED;
    }

    private boolean hasShipAround(int x, int y) {
        return (x != 0 && table[x - 1][y].getStatus() == CellStatus.HAS_SHIP)
                || (x + 1 < table.length && table[x + 1][y].getStatus() == CellStatus.HAS_SHIP)
                || (y != 0 && table[x][y - 1].getStatus() == CellStatus.HAS_SHIP)
                || (y + 1 < table[0].length && table[x][y + 1].getStatus() == CellStatus.HAS_SHIP);
    }

}
