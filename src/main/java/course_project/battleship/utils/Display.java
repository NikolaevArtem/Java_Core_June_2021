package course_project.battleship.utils;


import course_project.battleship.model.Field;

import java.io.IOException;

public final class Display {

    private static final String COLUMNS = "  1 2 3 4 5 6 7 8 9 10";

    private Display(){}

    public static void drawField(Field field) {
        System.out.println(COLUMNS);
        for (int i = 0; i < field.getField().length; i++) {
            System.out.print((char) (i + 65) + " ");
            for (int j = 0; j < field.getField()[1].length; j++) {
                if (field.getField()[j][i].getState() == Position.State.SHIP) {
                    System.out.print("+ ");
                } else if (field.getField()[j][i].getState() == Position.State.HIT) {
                    System.out.print("X ");
                } else if (field.getField()[j][i].getState() == Position.State.MISS) {
                    System.out.print("@ ");
                } else if (field.getField()[j][i].getState() == Position.State.POINT) {
                    System.out.print("* ");
                } else {
                    System.out.print("- ");
                }
            }
            System.out.println();
        }
    }

    public static void clearConsole() {
        String os = System.getProperty("os.name").toLowerCase();
        try {
            if (os.contains("win")) {
                new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
            } else if (os.contains("nix") || os.contains("nux")) {
                new ProcessBuilder("terminal", "/c", "clear").inheritIO().start().waitFor();
            }
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }
}
