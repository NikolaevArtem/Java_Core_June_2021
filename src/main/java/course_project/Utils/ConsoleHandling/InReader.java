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
        String[] strings = verifyInput(readInput());
        int x = -1;
        int y = -1;
        if (strings[0].length() >= 2) {
            int [] coord = parseToCoord(strings[0]);
            x = coord[0];
            y = coord[1];
        }
        else {
            printer.printInputError();
            readInput();
        }

        return new Coordinates(x,y);
    }

    public List<Coordinates> getCoordinatesByDestination(Coordinates start, int size){
        List<Coordinates> result = new ArrayList<>();
        for (int i = 1; i <= size; i++){
            String input =  readInput();
            String[] strings = verifyInput(input);
            int x = -1;
            int y = -1;
            if (strings[0].length() >= 2) {
                int [] coord = parseToCoord(strings[0]);
                x = coord[0];
                y = coord[1];
            } else {
                printer.printInputError();
                readInput();
            }
            result.add(new Coordinates(x, y));
        }
        return result;
    }

    private int[] parseToCoord(String string) {
        int[] result = new int[2];
        int first = string.toUpperCase(Locale.ROOT).charAt(0) - 65;
        int second = Integer.parseInt(string.substring(1)) -1;
        result[0] = first;
        result[1] = second;

        return result;
    }


    private String readInput(){
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

    private String[] verifyInput(String str){
        if (str == null && !str.matches("[a-jA-J]([1-9]|10) (up|down|left|right)")){
            printer.printInputError();
            readInput();
        }
        return str.split(" ");
    }


    public boolean getMode() {
        String mode = readInput();
        return mode.isEmpty();
    }
}
