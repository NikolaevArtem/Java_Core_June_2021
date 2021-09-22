package course_project.sea_battle.service.inputs;

import course_project.sea_battle.boards.MyBoard;
import course_project.sea_battle.model.Point;

import java.util.*;

public class InputShipReader extends InputReader {
    private int x;
    private int y;
    private Random random = new Random();

    private String position;
    private List<Point> coordinates;

    private static final String INPUTERROR = "Input should be like this: [A7 h] or [B2 h]. Try again!";
    private static final String OUTOFBOARD = "Impossible to place ship here because it is out of board!";
    private static final String SHIPSCROSS = "Impossible to place ship here because ship crosses with another one!";

    public InputShipReader(Scanner scanner) {
        this.scanner = scanner;
    }

    public void getAndValidateInput(int shipSize, MyBoard board, int gameMode) {
        while (true) {
            if (gameMode == 1) {
                String input = readLine();
                if (!isValidInput(input)) continue;
            } else if (gameMode == 2) {
                getAutomaticCoordinates();
            }

            Point topLeftPoint = new Point(x, y);
            if (!isShipWithinBoard(shipSize, gameMode)) continue;
            coordinates = findCoordinates(shipSize, topLeftPoint);
            if (shipsDoNotCross(board, shipSize, gameMode)) break;
        }
    }

    public void getAutomaticCoordinates() {
        x = random.nextInt(10);
        y = random.nextInt(10);
        position = random.nextInt(2) == 0 ? "v" : "h";
    }

    public boolean isValidInput(String input) {
        if (input.matches("[a-jA-J]([1-9]|10) (v|h|V|H)")) {
            String[] coords = input.split(" ");
            y = Character.getNumericValue(coords[0].charAt(0)) - 10;
            x = Integer.parseInt(coords[0].substring(1)) - 1;
            position = coords[1].toLowerCase();
            return true;
        } else {
            System.out.println(INPUTERROR);
            return false;
        }
    }

    public boolean isShipWithinBoard(int shipSize, int gameMode) {
        Point rightBottomPoint = position.equalsIgnoreCase("v")
                ? new Point(x + shipSize, y)
                : new Point(x, y + shipSize);
        if (rightBottomPoint.getX() > 10 || rightBottomPoint.getY() > 10) {
            if (gameMode == 1) System.out.println(OUTOFBOARD);
            return false;
        }
        return true;
    }

    public List<Point> findCoordinates(int shipSize, Point topLeftPoint) {
        coordinates = new ArrayList<>();

        int x1 = topLeftPoint.getX();
        int y1 = topLeftPoint.getY();

        for (int i = 0; i < shipSize; i++) {
            coordinates.add(new Point(x1, y1));
            if (position.equals("v")) {
                x1++;
            } else if (position.equals("h")) {
                y1++;
            }
        }
        return coordinates;
    }

    public boolean shipsDoNotCross(MyBoard board, int shipSize, int gameMode) {
        HashSet<Point> allCoordinates = new HashSet<>();
        for (int i = 0; i < shipSize; i++) {
            allCoordinates.add(new Point(x, y));
            if (x > 0) {
                allCoordinates.add(new Point(x - 1, y));
            }
            if (y > 0) {
                allCoordinates.add(new Point(x, y - 1));
            }
            if (x < 9) {
                allCoordinates.add(new Point(x + 1, y));
            }
            if (y < 9) {
                allCoordinates.add(new Point(x, y + 1));
            }
            if (x > 0 && y > 0) {
                allCoordinates.add(new Point(x - 1, y - 1));
            }
            if (x < 9 && y < 9) {
                allCoordinates.add(new Point(x + 1, y + 1));
            }
            if (x > 0 && y < 9) {
                allCoordinates.add(new Point(x - 1, y + 1));
            }
            if (x < 9 && y > 0) {
                allCoordinates.add(new Point(x + 1, y - 1));
            }
            if (position.equals("v")) {
                x++;
            } else {
                y++;
            }
        }
        long count = allCoordinates.stream()
                .mapToInt(e -> board.getBoard()[e.getX()][e.getY()])
                .distinct()
                .count();
        if (count > 1) {
            if (gameMode == 1) System.out.println(SHIPSCROSS);
            return false;
        }
        return true;
    }

    public List<Point> getValidCoordinates() {
        return coordinates;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }

}
