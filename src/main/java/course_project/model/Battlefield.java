package course_project.model;

import java.util.Arrays;

public class Battlefield {
    private Designation[][] grid;

    public Battlefield() {
        grid = new Designation[11][11];
        for (Designation[] cell : grid) {
            Arrays.fill(cell, Designation.EMPTY);
        }
    }

    public Designation[][] getGrid() {
        return grid;
    }

}