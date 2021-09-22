package course_project.service;

import course_project.custom_exceptions.CoordinatesNumber;
import course_project.custom_exceptions.InvalidShip;
import course_project.custom_exceptions.PlaceNotFree;
import course_project.model.Battlefield;
import course_project.model.Designation;
import course_project.model.Player;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class BattleFieldService {

    private final Battlefield battlefield;

    public BattleFieldService(Battlefield battlefield) {
        this.battlefield = battlefield;
    }

    public void print(Battlefield battlefield) {
        Designation[][] grid = battlefield.getGrid();
        for (int i = 1; i < grid.length; i++) {
            if (i == 1) {
                System.out.print(" \t");
                for (int j = 1; j < 11; j++) {
                    System.out.print((char) ('A' + (j - 1)) + "\t");
                }
                System.out.println();
            }
            System.out.print(i + "\t");
            for (int j = 1; j < grid[i].length; j++) {
                System.out.print((j == grid[i].length - 1) ? (grid[i][j] + "\n") : grid[i][j] + "\t");
            }
        }
    }

    public void arrangement(Player player, Scanner readIt) {

        System.out.println(player.getName() + ", your field is below\n");
        print(player.getField());

        while (true) {
            try {
                System.out.println(player.getName() + ", enter coordinates of four-decker (format: A1;A2;A3;A4)");
                putShip(player, readIt.nextLine(), Designation.FOUR_DECKER);
                print(player.getField());
                break;
            } catch (IOException | CoordinatesNumber | PlaceNotFree | InvalidShip exc) {
                System.out.println(exc.getMessage());
            }
        }

        for (int i = 0; i < 2; i++) {
            while (true) {
                try {
                    System.out.println("Enter coordinates of three-decker (format: A1;A2;A3)");
                    putShip(player, readIt.nextLine(), Designation.THREE_DECKER);
                    print(player.getField());
                    break;
                } catch (IOException | CoordinatesNumber | PlaceNotFree | InvalidShip e) {
                    System.out.println(e.getMessage());
                }
            }
        }

        for (int i = 0; i < 3; i++) {
            while (true) {
                try {
                    System.out.println("Enter coordinates of two-decker (format: A1;A2)");
                    putShip(player, readIt.nextLine(), Designation.TWO_DECKER);
                    print(player.getField());
                    break;
                } catch (IOException | CoordinatesNumber | PlaceNotFree | InvalidShip e) {
                    System.out.println(e.getMessage());
                }
            }
        }

        for (int i = 0; i < 4; i++) {
            while (true) {
                try {
                    System.out.println("Enter coordinates of one-decker (format: A1)");
                    putShip(player, readIt.nextLine(), Designation.ONE_DECKER);
                    print(player.getField());
                    break;
                } catch (IOException | CoordinatesNumber | PlaceNotFree | InvalidShip e) {
                    System.out.println(e.getMessage());
                }
            }
        }
        System.out.println("Fields with all ships: ");
        print(player.getField());
        System.out.println("Enter any to skip your field");
        readIt.nextLine();
        System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n");
    }

    public boolean isDead(Battlefield battlefield, int x, int y) {
        for (int i = 1; i <= 3; i++) {
            if (x - i >= 0 && battlefield.getGrid()[x - i][y] == Designation.SHIP) {
                return false;
            } else if (x - i >= 0 && battlefield.getGrid()[x - i][y] != Designation.HIT) {
                break;
            }
        }

        for (int i = 1; i <= 3; i++) {
            if (x + i <= 9 && battlefield.getGrid()[x + i][y] == Designation.SHIP) {
                return false;
            } else if (x + i <= 9 && battlefield.getGrid()[x + i][y] != Designation.HIT) {
                break;
            }
        }

        for (int i = 1; i <= 3; i++) {
            if (y - i >= 0 && battlefield.getGrid()[x][y - i] == Designation.SHIP) {
                return false;
            } else if (y - i >= 0 && battlefield.getGrid()[x][y - i] != Designation.HIT) {
                break;
            }
        }

        for (int i = 1; i <= 3; i++) {
            if (y + i <= 9 && battlefield.getGrid()[x][y + i] == Designation.SHIP) {
                return false;
            } else if (y + i <= 9 && battlefield.getGrid()[x][y + i] != Designation.HIT) {
                break;
            }
        }
        return true;
    }

    public void surroundDeadShip(Battlefield battlefield, int x, int y) {
        List<int[]> deadShipCoords = new ArrayList<>();
        deadShipCoords.add(new int[]{x, y});

        for (int i = 1; i <= 3; i++) {
            if (x - i >= 0 && battlefield.getGrid()[x - i][y] == Designation.HIT) {
                deadShipCoords.add(new int[]{x - i, y});
            } else {
                break;
            }
        }

        for (int i = 1; i <= 3; i++) {
            if (x + i <= 9 && battlefield.getGrid()[x + i][y] == Designation.HIT) {
                deadShipCoords.add(new int[]{x + i, y});
            } else {
                break;
            }
        }

        for (int i = 1; i <= 3; i++) {
            if (y - i >= 0 && battlefield.getGrid()[x][y - i] == Designation.HIT) {
                deadShipCoords.add(new int[]{x, y - i});
            } else {
                break;
            }
        }

        for (int i = 1; i <= 3; i++) {
            if (y + i <= 9 && battlefield.getGrid()[x][y + i] == Designation.HIT) {
                deadShipCoords.add(new int[]{x, y + i});
            } else {
                break;
            }
        }

        for (int[] coord : deadShipCoords) {
            int a = coord[0];
            int b = coord[1];

            if (a - 1 >= 0 && battlefield.getGrid()[a - 1][b] != Designation.HIT) {
                battlefield.getGrid()[a - 1][b] = Designation.MISS;
            }
            if (a - 1 >= 0 && b + 1 <= 9 && battlefield.getGrid()[a - 1][b + 1] != Designation.SHIP) {
                battlefield.getGrid()[a - 1][b + 1] = Designation.MISS;
            }
            if (b + 1 <= 9 && battlefield.getGrid()[a][b + 1] != Designation.HIT) {
                battlefield.getGrid()[a][b + 1] = Designation.MISS;
            }
            if (a + 1 <= 9 && b + 1 <= 9 && battlefield.getGrid()[a + 1][b + 1] != Designation.HIT) {
                battlefield.getGrid()[a + 1][b + 1] = Designation.MISS;
            }
            if (a + 1 <= 9 && battlefield.getGrid()[a + 1][b] != Designation.HIT) {
                battlefield.getGrid()[a + 1][b] = Designation.MISS;
            }
            if (a + 1 <= 9 && b - 1 >= 0 && battlefield.getGrid()[a + 1][b - 1] != Designation.HIT) {
                battlefield.getGrid()[a + 1][b - 1] = Designation.MISS;
            }
            if (b - 1 >= 0 && battlefield.getGrid()[a][b - 1] != Designation.HIT) {
                battlefield.getGrid()[a][b - 1] = Designation.MISS;
            }
            if (a - 1 >= 0 && b - 1 >= 0 && battlefield.getGrid()[a - 1][b - 1] != Designation.HIT) {
                battlefield.getGrid()[a - 1][b - 1] = Designation.MISS;
            }
        }
    }

    private void putShip(Player player, String strCoords, Designation ship) throws CoordinatesNumber, IOException, InvalidShip, PlaceNotFree {

        String[] shipCoordsArray = strCoords.split(";");

        if (shipCoordsArray.length != ship.getLength()) {
            throw new CoordinatesNumber();
        }

        int[][] digitalCoords = new int[shipCoordsArray.length][2];

        for (int i = 0; i < shipCoordsArray.length; i++) {
            if (Character.isDigit(shipCoordsArray[i].charAt(0)) || !Character.isDigit(shipCoordsArray[i].charAt(1))) {
                System.out.println("Invalid input format! X should be letter A-J and Y - numbers 0 - 9");
                throw new IOException();
            }

            digitalCoords[i][0] = Character.getNumericValue(shipCoordsArray[i].charAt(1));
            digitalCoords[i][1] = shipCoordsArray[i].charAt(0) - 64;
        }

        if (!isValid(digitalCoords)) {
            throw new InvalidShip();
        }
        if (!isFree(digitalCoords, player.getField().getGrid())) {
            throw new PlaceNotFree();
        }

        for (int[] digitalCoord : digitalCoords) {

            player.getField().getGrid()[digitalCoord[0]][digitalCoord[1]] = Designation.SHIP;
        }

        for (int[] digitalCoord : digitalCoords) {
            int x = digitalCoord[0];
            int y = digitalCoord[1];

            if (x - 1 >= 0 && player.getField().getGrid()[x - 1][y] != Designation.SHIP) {
                player.getField().getGrid()[x - 1][y] = Designation.GAP;
            }
            if (x - 1 >= 0 && y + 1 <= 9 && player.getField().getGrid()[x - 1][y + 1] != Designation.SHIP) {
                player.getField().getGrid()[x - 1][y + 1] = Designation.GAP;
            }
            if (y + 1 <= 9 && player.getField().getGrid()[x][y + 1] != Designation.SHIP) {
                player.getField().getGrid()[x][y + 1] = Designation.GAP;
            }
            if (x + 1 <= 9 && y + 1 <= 9 && player.getField().getGrid()[x + 1][y + 1] != Designation.SHIP) {
                player.getField().getGrid()[x + 1][y + 1] = Designation.GAP;
            }
            if (x + 1 <= 9 && player.getField().getGrid()[x + 1][y] != Designation.SHIP) {
                player.getField().getGrid()[x + 1][y] = Designation.GAP;
            }
            if (x + 1 <= 9 && y - 1 >= 0 && player.getField().getGrid()[x + 1][y - 1] != Designation.SHIP) {
                player.getField().getGrid()[x + 1][y - 1] = Designation.GAP;
            }
            if (y - 1 >= 0 && player.getField().getGrid()[x][y - 1] != Designation.SHIP) {
                player.getField().getGrid()[x][y - 1] = Designation.GAP;
            }
            if (x - 1 >= 0 && y - 1 >= 0 && player.getField().getGrid()[x - 1][y - 1] != Designation.SHIP) {
                player.getField().getGrid()[x - 1][y - 1] = Designation.GAP;
            }
        }
    }

    private boolean isValid(int[][] coords) {
        if (coords.length == 1) {
            return true;
        }

        int x = coords[0][0];
        int y = coords[0][1];
        boolean isCorrect = true;

        for (int i = 1; i < coords.length; i++) {
            if (coords[i][0] == x) {

                for (int j = 0; j < coords.length; j++) {
                    if (i == j) {
                        continue;
                    }

                    if (coords[i][1] == coords[j][1] || coords[i][1] == y) {
                        isCorrect = false;
                        break;
                    }
                }

                int[] isAdjacent = new int[coords.length];

                for (int j = 0; j < coords.length; j++) {
                    isAdjacent[j] = coords[j][1];
                }
                Arrays.sort(isAdjacent);

                for (int t = 0; t < isAdjacent.length - 1; t++) {
                    isCorrect = isAdjacent[t + 1] == (isAdjacent[t] + 1) && isCorrect;
                }

            } else if (coords[i][1] == y) {
                for (int j = 0; j < coords.length; j++) {
                    if (i == j) {
                        continue;
                    }

                    if (coords[i][0] == coords[j][0] || coords[i][0] == x) {
                        isCorrect = false;
                        break;
                    }
                }

                int[] isAdjacent = new int[coords.length];
                for (int j = 0; j < coords.length; j++) {
                    isAdjacent[j] = coords[j][0];
                }
                Arrays.sort(isAdjacent);

                for (int t = 0; t < isAdjacent.length - 1; t++) {
                    isCorrect = isAdjacent[t + 1] == (isAdjacent[t] + 1) && isCorrect;
                }

            } else {
                isCorrect = false;
            }
        }
        return isCorrect;
    }

    private boolean isFree(int[][] coords, Designation[][] field) {
        for (int[] coord : coords) {
            if (!(field[coord[0]][coord[1]] == Designation.EMPTY)) {
                return false;
            }
        }
        return true;
    }

}
