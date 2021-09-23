package course_project.objects.fields;

import course_project.enums.CellStatus;
import course_project.objects.Cell;
import course_project.objects.Move;
import course_project.objects.fields.Field;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class UserField extends Field {

    public UserField() {
        for (Cell[] row : table) {
            Arrays.fill(row, new Cell(CellStatus.NOT_VISITED, false));
        }
    }

    public void setVisitedAroundShip(List<Move> list) {
        boolean isSameX = false;
        if (list.size() == 1 || list.get(0).getX() == list.get(1).getX()) {
            isSameX = true;
        }
        if (isSameX) {
            Comparator<Move> byY = Comparator.comparing(Move::getY);
            list.sort(byY);
            int x = list.get(0).getX();
            int y1 = list.get(0).getY();
            int y2 = list.get(list.size() - 1).getY();
            for (int y = y1 - 1; y <= y2 + 1; y++) {
                if (!(0 <= y && y < 10)) {
                    continue;
                }
                setCellStatus(x, y, CellStatus.VISITED);
                if (x - 1 >= 0) {
                    setCellStatus(x - 1, y, CellStatus.VISITED);
                }
                if (x + 1 < 10) {
                    setCellStatus(x + 1, y, CellStatus.VISITED);
                }
            }
        } else {
            Comparator<Move> byX = Comparator.comparing(Move::getX);
            list.sort(byX);
            int y = list.get(0).getY();
            int x1 = list.get(0).getX();
            int x2 = list.get(list.size() - 1).getX();
            for (int x = x1 - 1; x <= x2 + 1; x++) {
                if (!(0 <= x && x < 10)) {
                    continue;
                }
                setCellStatus(x, y, CellStatus.VISITED);
                if (y - 1 >= 0) {
                    setCellStatus(x, y - 1, CellStatus.VISITED);
                }
                if (y + 1 < 10) {
                    setCellStatus(x, y + 1, CellStatus.VISITED);
                }
            }
        }
    }

}
