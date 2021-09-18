package course_project.util;

import course_project.components.PlayingField;

public class PlayingFieldPrinter {

    public void printField(PlayingField field) {
        printHeader();
        printShipsAndShots(field);
    }

    private void printHeader() {
        System.out.print("\t");
        for (int i = 0; i < 10; i++) {
            char ch = (char) (i + 65);
            System.out.print(ch + " ");
        }
        System.out.println();
    }

    private void printShipsAndShots(PlayingField field) {
        int rowNumber = 1;
        int[][] fleet = field.getFleet();
        boolean[][] cellsShot = field.getCellsShot();

        for (int i = 0; i < fleet.length; i++) {
            System.out.print(rowNumber++ + "\t");
            for (int j = 0; j < fleet[0].length; j++) {
                if (fleet[i][j] == 0) {
                    if (cellsShot[i][j]) {
                        System.out.print("* ");
                    } else {
                        System.out.print("- ");
                    }
                } else {
                    if (cellsShot[i][j]) {
                        System.out.print("X ");
                    } else {
                        System.out.print(fleet[i][j] + " ");
                    }
                }
            }
            System.out.println();
        }
        System.out.println();
    }

    public void printShotCells(PlayingField field) {
        printHeader();
        printShots(field);
    }

    private void printShots(PlayingField field) {
        int rowNumber = 1;
        int[][] fleet = field.getFleet();
        boolean[][] cellsShot = field.getCellsShot();

        for (int i = 0; i < cellsShot.length; i++) {
            System.out.print(rowNumber++ + "\t");
            for (int j = 0; j < cellsShot[0].length; j++) {
                if (cellsShot[i][j]) {
                    if (fleet[i][j] == 0) {
                        System.out.print("* ");
                    } else {
                        System.out.print("X ");
                    }
                } else {
                    System.out.print("- ");
                }
            }
            System.out.println();
        }
        System.out.println();
    }

}
