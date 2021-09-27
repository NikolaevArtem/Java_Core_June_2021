package course_project.Utils.ConsoleHandling;

import course_project.components.Coordinates;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class InReader {
    Printer printer = new Printer();
    private final BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    public Coordinates readCoordinates() {
        Coordinates result;
        String input = readInput();

        if (StringIsFine(input)) {
            int x;
            int y;
            int[] coord = parseToCoord(input);
            x = coord[0];
            y = coord[1];
            result = new Coordinates(x, y);
            return result;
        } else {
            printer.printInputError();
        }
        return readCoordinates();
    }

    public List<Coordinates> getCoordinatesByDestination(Coordinates start, int size, String destination) {
        List<Coordinates> result = new ArrayList<>();
        int startX = start.getX();
        int startY = start.getY();
        //destinations are inverted, only case names
        for (int i = 0; i < size; i++) {
            switch (destination) {
                case "left":
                    result.add(new Coordinates(startX - i, startY));
                    break;
                case "right":
                    result.add(new Coordinates(startX + i, startY));
                    break;
                case "up":
                    result.add(new Coordinates(startX, startY - i));
                    break;
                case "down":
                    result.add(new Coordinates(startX, startY + i));
                    break;
            }
        }

        return result;
    }

    private int[] parseToCoord(String string) {
        int[] result = new int[2];
        int first = string.toUpperCase(Locale.ROOT).charAt(0) - 65;
        int second = Integer.parseInt(string.substring(1)) - 1;
        result[0] = first;
        result[1] = second;

        return result;
    }


    private String readInput() {
        String input = "";
        {
            try {
                input = reader.readLine();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return input;
    }

    private boolean StringIsFine(String str) {
        return str.matches("[a-jA-J]([1-9]|10)") && (str.length() == 2 || str.length() == 3);
    }

    public String getDestination() {
        String result = readInput().toLowerCase(Locale.ROOT).trim();
        if (!result.matches("up") && !result.matches("down") && !result.matches("right") && !result.matches("left")) {
            System.out.println("Wrong destination input, try again!");
            result = getDestination();
        }
        return result;
    }

    public boolean getMode() {
        String mode = readInput();
        return mode == null || mode.isEmpty();
    }
}
