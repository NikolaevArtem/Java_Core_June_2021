package course_project.sea_battle.model;

import java.util.ArrayList;
import java.util.List;

public class Field {

    private int[][] field;
    private ShipsGame ships;

    public Field(int a, int b) {
        field = new int[a][b];
        for (int i = 0; i < a; i++) {
            for (int j = 0; j < b; j++) {
                field[i][j] = 0;
            }
        }
        ships = new ShipsGame();
    }

    public boolean addShip(Ship ship) {
        if(ship==null) return false;
        int a = ship.getStartPositionA();
        int b = ship.getStartPositionB();
        int size = ship.getSize();
        if(!correct(a, b, size, field.length, ship.getOrientation())) return false;

        List<Integer[]> list = new ArrayList<>();
        for (int i = 0; i < ship.getSize(); i++) {
            if (ship.getOrientation()) {
                if (!chekEdge(a + i, b)) return false;
                  list.add(new Integer[]{a+i, b});
            } else {
                if (!chekEdge(a, b + i)) return false;
                list.add(new Integer[]{a, b+i});
            }
        }
        for (Integer[] list1: list) {
                field[list1[0]][list1[1]] = 5;
        }
        ships.addShip(ship);
        return true;

    }

    private boolean correct(int a, int b, int size, int length, boolean orientation) {
        if (a < 0 || b < 0 || a > 9 || b > 9 || size < 1 || size >= 5)
            return false;
        if (orientation && length < a + size)
            return false;
        if (!orientation && length < b + size)
            return false;
        return true;
    }

    public int[][] getField() {
        return field;
    }

    public boolean readyToGame() {
        return ships.ready();
    }

    private boolean chekEdge(int a, int b) {
        if (a - 1 >= 0 && b - 1 >= 0 && a + 1 < 10 && b + 1 < 10) {
            for (int i = -1; i < 2; i++) {
                for (int j = -1; j < 2; j++) {
                    if (field[a + i][b + j] != 0) return false;
                }
            }
        } else if (a - 1 < 0 && b - 1 >= 0 && b + 1 < 10) {
            for (int i = 0; i < 2; i++) {
                for (int j = -1; j < 2; j++) {
                    if (field[a + i][b + j] != 0) return false;
                }
            }
        } else if (a - 1 >= 0 && b - 1 < 0 && a + 1 < 10) {
            for (int i = -1; i < 2; i++) {
                for (int j = 0; j < 2; j++) {
                    if (field[a + i][b + j] != 0) return false;
                }
            }
        } else if (b - 1 >= 0 && a + 1 >= 10 && b + 1 < 10) {
            for (int i = -1; i < 1; i++) {
                for (int j = -1; j < 2; j++) {
                    if (field[a + i][b + j] != 0) return false;
                }
            }
        } else if (a - 1 >= 0 && b + 1 >= 10 && a + 1 < 10) {
            for (int i = -1; i < 2; i++) {
                for (int j = -1; j < 1; j++) {
                    if (field[a + i][b + j] != 0) return false;
                }
            }
        } else if (a - 1 < 0 && b - 1 < 0) {
            for (int i = 0; i < 2; i++) {
                for (int j = 0; j < 2; j++) {
                    if (field[a + i][b + j] != 0) return false;
                }
            }

        } else if (a + 1 >= 10 && b + 1 >= 10) {
            for (int i = -1; i < 1; i++) {
                for (int j = -1; j < 1; j++) {
                    if (field[a + i][b + j] != 0) return false;
                }
            }
        }
        return true;
    }

    public int getSize() {
        return field.length;
    }

    public String shot(String shot) {
        String[] shots = shot.split(" ");
        int a = Integer.parseInt(shots[0])-1;
        int b = Integer.parseInt(shots[1])-1;
        if(field[a][b] == 0 || field[a][b] == 5) {
            for (Ships ship : ships.getAllShips()) {
                if (ship.shot(a, b)) {
                    field[a][b] = 7;
                    return "1";
                }
            }
            field[a][b] = 3;
            return "2";
        } else return "3";
    }

    public boolean checkShipsSize(Ship ship) {
        return ships.getShipInSize(ship.getSize());
    }
}
