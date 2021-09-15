package course_project.sea_battle.model;

import java.util.*;

public class Field {

    private int[][] field;
    private ShipsGame ships;
    List<String> autoShotsMap;

    public Field(int sizeA, int sizeB) {
        field = new int[sizeA][sizeB];
        for (int i = 0; i < sizeA; i++) {
            for (int j = 0; j < sizeB; j++) {
                field[i][j] = 0;
            }
        }
        ships = new ShipsGame();
        autoShotsMap = new ArrayList<>();
    }

    public boolean addShip(Ship ship) {
        int pointA = ship.getStartPositionA();
        int pointB = ship.getStartPositionB();
        int size = ship.getSize();
        boolean orient = ship.getOrientation();

        if(!correct(pointA, pointB, size, orient)) return false;

        List<Integer[]> list = new ArrayList<>();
        for (int i = 0; i < ship.getSize(); i++) {
            if (ship.getOrientation()) {
                if (!chekCanPutShip(pointA + i, pointB)) return false;
                list.add(new Integer[]{pointA + i, pointB});
            } else {
                if (!chekCanPutShip(pointA, pointB + i)) return false;
                list.add(new Integer[]{pointA, pointB + i});
            }
        }
        for (Integer[] list1 : list) {
            int posA = list1[0];
            int posB = list1[1];
            field[posA][posB] = 5;
        }
        return ships.addShip(ship);
    }

    private boolean correct(int startPointA, int startPointB, int sizeField, boolean orientation) {
        if (startPointA < 0 || startPointB < 0 || startPointA > 9 || startPointB > 9 || sizeField < 1 || sizeField >= 5)
            return false;
        if (orientation && field.length < startPointA + sizeField)
            return false;
        if (!orientation && field.length < startPointB + sizeField)
            return false;
        return true;
    }

    public int[][] getField() {
        return field;
    }

    public boolean readyToGame() {
        return ships.ready();
    }

    public int getSize() {
        return field.length;
    }

    public String shot(String shot) {
        String[] shots = shot.split(" ");
        int pointA = Integer.parseInt(shots[0]) - 1;
        int pointB = CoordinateTranslator.coordinate(shots[1].toLowerCase(Locale.ROOT));
        return shotResult(pointA, pointB);
    }

    private void missAroundDeadShip(Ships ship) {
        int positionA = ship.getStartPositionA();
        int positionB = ship.getStartPositionB();

        if (ship.getOrientation()) {
            for (; positionA < ship.getStartPositionA() + ship.getSize(); positionA++) {
                addMissAroundPoint(positionA, positionB);
            }
        }
        else {
            for (; positionB < ship.getStartPositionB() + ship.getSize(); positionB++) {
                addMissAroundPoint(positionA, positionB);
            }
        }
    }

    private void addMissAroundPoint(int positionA, int positionB) {
        missAroundDeadShipLeft(positionA, positionB);
        missAroundDeadShipRight(positionA, positionB);
        missAroundDeadShipUp(positionA, positionB);
        missAroundDeadShipDown(positionA, positionB);
    }

    public boolean shipsDead() {
        return ships.shipsDead();
    }

    public void autoGenerateShips() {
        while (!ships.ready()) {
            boolean orientation = new Random().nextInt(2) == 0;
            int x = new Random().nextInt(10);
            int y = new Random().nextInt(10);
            int size = new Random().nextInt(4) + 1;
            if (ships.canAddThisSize(size)) {
                addShip(new Ship(orientation, x, y, size));
            }
        }
    }

    public boolean canAddThisSize(int size) {
        return ships.canAddThisSize(size);
    }

    public String autoShot() {
        int pointA = new Random().nextInt(10);
        int pointB = new Random().nextInt(10);

        while (autoShotsMap.contains(String.valueOf(pointA) + String.valueOf(pointB))) {
            pointA = new Random().nextInt(10);
            pointB = new Random().nextInt(10);
        }
        autoShotsMap.add(String.valueOf(pointA) + String.valueOf(pointB));
        return shotResult(pointA, pointB);
    }

    private void missAroundDeadShipDown(int posA, int posB) {
        if (posB - 1 >= 0 && field[posA][posB - 1] == 0) {
            setPointInField(posA, posB - 1, 3);
        }
        if (posB - 1 >= 0 && posA - 1 >= 0 && field[posA - 1][posB - 1] == 0) {
            setPointInField(posA - 1, posB - 1, 3);
        }
        if (posB - 1 >= 0 && posA + 1 < 10 && field[posA + 1][posB - 1] == 0) {
            setPointInField(posA + 1, posB - 1, 3);
        }

    }

    private void missAroundDeadShipLeft(int posA, int posB) {
        if (posA - 1 >= 0 && field[posA - 1][posB] == 0) {
            setPointInField(posA - 1, posB, 3);
        }
        if (posA - 1 >= 0 && posB - 1 >= 0 && field[posA - 1][posB - 1] == 0) {
            setPointInField(posA - 1, posB - 1, 3);
        }
        if (posA - 1 >= 0 && posB + 1 < 10 && field[posA - 1][posB + 1] == 0) {
            setPointInField(posA - 1, posB + 1, 3);
        }
    }

    private void missAroundDeadShipRight(int posA, int posB) {
        if (posA + 1 < 10 && field[posA + 1][posB] == 0) {
            setPointInField(posA + 1, posB, 3);
        }
        if (posA + 1 < 10 && posB + 1 < 10 && field[posA + 1][posB + 1] == 0) {
            setPointInField(posA + 1, posB + 1, 3);
        }
    }

    private void missAroundDeadShipUp(int posA, int posB) {
        if (posB + 1 < 10 && field[posA][posB + 1] == 0) {
            setPointInField(posA, posB + 1, 3);
        }
    }

    private void setPointInField(int pointA, int pointB, int in) {
        if(pointA>=0&&pointB>=0&&pointA<10&&pointB<10) {
            field[pointA][pointB] = in;
            autoShotsMap.add(String.valueOf(pointA) + String.valueOf(pointB));
        }
    }

    private boolean checkPointField(int pointA, int pointB, int checked){
        return field[pointA][pointB] == checked;
    }
    private String shotResult(int pointA, int pointB) {
        if (checkPointField(pointA, pointB, 0) || checkPointField(pointA, pointB, 5)) {
            for (Ships ship : ships.getAllShips()) {
                if (ship.shot(pointA, pointB)) {
                    setPointInField(pointA, pointB, 7);
                    if (ship.isDead()) {
                        missAroundDeadShip(ship);
                        return "Hit! And Kill!";
                    }
                    return "Hit!";
                }
            }
            setPointInField(pointA, pointB, 3);
            return "Miss";
        } else {
            return "Miss";
        }

    }

    private boolean chekCanPutShip(int pointA, int pointB) {
        if (pointA - 1 >= 0 && pointB - 1 >= 0 && pointA + 1 < 10 && pointB + 1 < 10) {
            for (int i = -1; i < 2; i++) {
                for (int j = -1; j < 2; j++) {
                    if (field[pointA + i][pointB + j] != 0) return false;
                }
            }
        } else if (pointA - 1 < 0 && pointB - 1 >= 0 && pointB + 1 < 10) {
            for (int i = 0; i < 2; i++) {
                for (int j = -1; j < 2; j++) {
                    if (field[pointA + i][pointB + j] != 0) return false;
                }
            }
        } else if (pointA - 1 >= 0 && pointB - 1 < 0 && pointA + 1 < 10) {
            for (int i = -1; i < 2; i++) {
                for (int j = 0; j < 2; j++) {
                    if (field[pointA + i][pointB + j] != 0) return false;
                }
            }
        } else if (pointB - 1 >= 0 && pointA + 1 >= 10 && pointB + 1 < 10) {
            for (int i = -1; i < 1; i++) {
                for (int j = -1; j < 2; j++) {
                    if (field[pointA + i][pointB + j] != 0) return false;
                }
            }
        } else if (pointA - 1 >= 0 && pointB + 1 >= 10 && pointA + 1 < 10) {
            for (int i = -1; i < 2; i++) {
                for (int j = -1; j < 1; j++) {
                    if (field[pointA + i][pointB + j] != 0) return false;
                }
            }
        } else if (pointA - 1 < 0 && pointB - 1 < 0) {
            for (int i = 0; i < 2; i++) {
                for (int j = 0; j < 2; j++) {
                    if (field[pointA + i][pointB + j] != 0) return false;
                }
            }

        } else if (pointA + 1 >= 10 && pointB + 1 >= 10) {
            for (int i = -1; i < 1; i++) {
                for (int j = -1; j < 1; j++) {
                    if (field[pointA + i][pointB + j] != 0) return false;
                }
            }
        }
        return true;
    }

}
