package course_project.services;

import course_project.enums.CellStatus;
import course_project.objects.fields.Field;
import course_project.objects.Move;

import java.util.Comparator;
import java.util.List;

import static java.lang.Math.random;

public class MoveGenerator {

    public static Move generate(Field userField) {
        int x = (int) (random() * 10);
        int y = (int) (random() * 10);
        while (userField.getCellStatus(x, y) != CellStatus.NOT_VISITED) {
            x = (int) (random() * 10);
            y = (int) (random() * 10);
        }
        return new Move(x, y);
    }

    public static Move generate(Field userField, List<Move> lastHit) {
        if (lastHit.size() == 0) {
            return generate(userField);
        }
        int x = lastHit.get(0).getX();
        int y = lastHit.get(0).getY();

        if (lastHit.size() == 1) {
            if (x != 0 && userField.getCellStatus(x - 1, y) == CellStatus.NOT_VISITED) {
                return new Move(x - 1, y);
            }
            if (x + 1 < 10 && userField.getCellStatus(x + 1, y) == CellStatus.NOT_VISITED) {
                return new Move(x + 1, y);
            }
            if (y != 0 && userField.getCellStatus(x, y - 1) == CellStatus.NOT_VISITED) {
                return new Move(x, y - 1);
            }
            return new Move(x, y + 1);
        }

        if (x == lastHit.get(1).getX()) {
            Comparator<Move> byY = Comparator.comparing(Move::getY);
            lastHit.sort(byY);
            y = Math.min(y, lastHit.get(lastHit.size() - 1).getY());
            if (y != 0 && userField.getCellStatus(x, y - 1) == CellStatus.NOT_VISITED) {
                return new Move(x, y - 1);
            }
            y = Math.max(y, lastHit.get(lastHit.size() - 1).getY());
            return new Move(x, y + 1);
        }
        Comparator<Move> byX = Comparator.comparing(Move::getX);
        lastHit.sort(byX);
        x = Math.min(x, lastHit.get(lastHit.size() - 1).getX());
        if (x != 0 && userField.getCellStatus(x - 1, y) == CellStatus.NOT_VISITED) {
            return new Move(x - 1, y);
        }
        x = Math.max(y, lastHit.get(lastHit.size() - 1).getX());
        return new Move(x + 1, y);
    }

}
