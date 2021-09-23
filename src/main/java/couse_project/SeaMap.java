package couse_project;

public class SeaMap implements Cloneable {
    private final int[][] field = new int[10][10];

    public SeaMap() {
        randomShipsFill();
    }

    public SeaMap clone() throws CloneNotSupportedException {
        return (SeaMap) super.clone();
    }

    public int[][] getField() {
        return field;
    }

    public int[] size() {
        return new int[]{10, 10};
    }

    public int getCell(int row, int col) {
        return field[row][col];
    }

    public boolean cellIsEmpty(int x, int y) {
        return field[y][x] == 0;
    }

    public boolean isHealthyShip(int x, int y) {
        return field[y][x] == 1;
    }

    public boolean isWreckedShip(int x, int y) {
        return field[y][x] == 2;
    }

    public boolean isFreeEnterCell(int x, int y) {
        return field[y][x] == 0 || field[y][x] == 1;
    }

    public void randomShipsFill() {
        java.util.Random random = new java.util.Random();
        int[] shipsSizes = new int[]{4, 3, 3, 2, 2, 2, 1, 1, 1, 1};

        for (int size : shipsSizes) {
            int x = random.nextInt(10);
            int y = random.nextInt(10);
            int rotate = random.nextInt(2);
            Ship ship = new Ship(size, x, y, rotate == 1);
            while (!canSetShip(ship)) {
                x = random.nextInt(10);
                y = random.nextInt(10);
                rotate = random.nextInt(2);
                ship = new Ship(size, x, y, rotate == 1);
            }

            for (int i = 0; i < size; i++) {
                if (ship.isRotate()) {
                    field[y + i][x] = 1;
                } else {
                    field[y][x + i] = 1;
                }
            }
        }
    }

    private boolean canSetShip(Ship ship) {
        if (ship.getX() < 0 || ship.getY() < 0 || field.length <= ship.getX() || field.length <= ship.getY()) {
            return false;
        }
        if (ship.isRotate() && field.length <= ship.getY() + ship.getSize()) {
            return false;
        }
        if (!ship.isRotate() && field.length <= ship.getX() + ship.getSize()) {
            return false;
        }

        int minX = Math.max(0, ship.getX() - 1);
        int minY = Math.max(0, ship.getY() - 1);
        int maxX = Math.min(field.length - 1, ship.getX() + 1 + (ship.isRotate() ? 0 : ship.getSize()));
        int maxY = Math.min(field.length - 1, ship.getY() + 1 + (ship.isRotate() ? ship.getSize() : 0));

        for (int x = minX; x <= maxX; x++) {
            for (int y = minY; y <= maxY; y++) {
                if (!cellIsEmpty(x, y)) {
                    return false;
                }
            }
        }
        return true;
    }

    public boolean registerShot(int x, int y) {
        if (cellIsEmpty(x, y)) {
            field[y][x] = 4;
            return false;
        } else if (isHealthyShip(x, y)) {
            field[y][x] = 2;
            if (!shipIsAlive(x, y)) {
                markDestroyedShip(x, y);
            }
            return true;
        }
        return false;
    }

    private boolean shipIsAlive(int x, int y) {
        int[] env = new int[]{-1, -1, -1, -1};
        if (x != 0) {
            env[0] = x - 1;
        }
        if (x != 9) {
            env[1] = x + 1;
        }
        if (y != 0) {
            env[2] = y - 1;
        }
        if (y != 9) {
            env[3] = y + 1;
        }

        if (isVerticalShip(x, y)) {
            for (int i = 2; i < env.length; i++) {
                if (env[i] != -1) {
                    if (field[env[i]][x] == 1) {
                        return true;
                    } else if (field[env[i]][x] == 2) {
                        int positionY = y;

                        while (positionY > 0 && (field[positionY][x] != 0 && field[positionY][x] != 4)) {
                            if (field[positionY][x] == 1) {
                                return true;
                            }
                            positionY -= 1;
                        }

                        while (positionY < 9 && (field[positionY][x] != 0 && field[positionY][x] != 4)) {
                            if (field[positionY][x] == 1) {
                                return true;
                            }
                            positionY += 1;
                        }

                        if (field[positionY][x] == 1) {
                            return true;
                        }
                    }
                }
            }
        } else {
            for (int i = 0; i < env.length / 2; i++) {
                if (env[i] != -1) {
                    if (field[y][env[i]] == 1) {
                        return true;
                    } else if (field[y][env[i]] == 2) {
                        int positionX = x;

                        while (positionX > 0 && (field[y][positionX] != 0 && field[y][positionX] != 4)) {
                            if (field[y][positionX] == 1) {
                                return true;
                            }
                            positionX -= 1;
                        }

                        while (positionX < 9 && (field[y][positionX] != 0 && field[y][positionX] != 4)) {
                            if (field[y][positionX] == 1) {
                                return true;
                            }
                            positionX += 1;
                        }

                        if (field[y][positionX] == 1) {
                            return true;
                        }
                    }
                }
            }
        }
        return false;
    }

    private void markDestroyedShip(int x, int y) {
        if (isVerticalShip(x, y)) {
            int positionY = y;
            while (positionY > 0 && (field[positionY][x] != 0 && field[positionY][x] != 4)) {
                positionY -= 1;
            }
            if (field[positionY][x] != 1 && field[positionY][x] != 2) {
                positionY += 1;
            }

            while (positionY < 9 && (field[positionY][x] != 0 && field[positionY][x] != 4)) {
                field[positionY][x] = 3;

                if (positionY > 0) {
                    if (field[positionY - 1][x] == 0) {
                        field[positionY - 1][x] = 4;
                    }
                    if (x + 1 <= 9) {
                        if (field[positionY - 1][x + 1] == 0) {
                            field[positionY - 1][x + 1] = 4;
                        }
                    }
                    if (x - 1 >= 0) {
                        if (field[positionY - 1][x - 1] == 0) {
                            field[positionY - 1][x - 1] = 4;
                        }
                    }
                }

                if (x > 0) {
                    if (field[positionY][x - 1] == 0) {
                        field[positionY][x - 1] = 4;
                    }
                }

                if (x < 9) {
                    if (field[positionY][x + 1] == 0) {
                        field[positionY][x + 1] = 4;
                    }
                }

                if (field[positionY + 1][x] == 0) {
                    field[positionY + 1][x] = 4;
                }

                if (x + 1 <= 9) {
                    if (field[positionY + 1][x + 1] == 0) {
                        field[positionY + 1][x + 1] = 4;
                    }
                }

                if (x - 1 >= 0) {
                    if (field[positionY + 1][x - 1] == 0) {
                        field[positionY + 1][x - 1] = 4;
                    }
                }

                positionY += 1;
            }
        } else {
            int positionX = x;
            while (positionX > 0 && (field[y][positionX] != 0 && field[y][positionX] != 4)) {
                positionX -= 1;
            }
            if (field[y][positionX] != 1 && field[y][positionX] != 2) {
                positionX += 1;
            }

            while (positionX < 9 && (field[y][positionX] != 0 && field[y][positionX] != 4)) {
                field[y][positionX] = 3;

                if (positionX > 0) {
                    if (field[y][positionX - 1] == 0) {
                        field[y][positionX - 1] = 4;
                    }
                    if (y + 1 <= 9) {
                        if (field[y + 1][positionX - 1] == 0) {
                            field[y + 1][positionX - 1] = 4;
                        }
                    }
                    if (y - 1 >= 0) {
                        if (field[y - 1][positionX - 1] == 0) {
                            field[y - 1][positionX - 1] = 4;
                        }
                    }
                }

                if (y > 0) {
                    if (field[y - 1][positionX] == 0) {
                        field[y - 1][positionX] = 4;
                    }
                }

                if (y < 9) {
                    if (field[y + 1][positionX] == 0) {
                        field[y + 1][positionX] = 4;
                    }
                }

                if (field[y][positionX + 1] == 0) {
                    field[y][positionX + 1] = 4;
                }
                if (y + 1 <= 9) {
                    if (field[y + 1][positionX + 1] == 0) {
                        field[y + 1][positionX + 1] = 4;
                    }
                }
                if (y - 1 >= 0) {
                    if (field[y - 1][positionX + 1] == 0) {
                        field[y - 1][positionX + 1] = 4;
                    }
                }

                positionX += 1;
            }
        }
    }

    private boolean isVerticalShip(int x, int y) {
        int[] env = new int[]{-1, -1, -1, -1};
        if (x != 0) {
            env[0] = x - 1;
        }
        if (x != 9) {
            env[1] = x + 1;
        }
        if (y != 0) {
            env[2] = y - 1;
        }
        if (y != 9) {
            env[3] = y + 1;
        }

        for (int i = 0; i < env.length / 2; i++) {
            if (env[i] != -1) {
                if (field[y][env[i]] == 1 || field[y][env[i]] == 2) {
                    return false;
                }
            }
        }
        return true;
    }

}
