package course_project.engine;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Locale;

public class Input {

    public static String getRightCoordinate() throws IOException {
        System.out.println("Enter coordinate if format: \"a1\"");
        String s;
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        while (true) {
            s = reader.readLine();
            if (Input.checkCoordinate(s)) {
                System.out.println("Coordinate: " + s);
                return s;
            } else {
                System.out.println("Wrong Input! use letters from a to j and numbers from 1 to 10, like \"d4\"");
            }
        }
    }

    public static String getRightMode() throws IOException {
        System.out.println("Choose mode: use letter \"v\" to place it vertically or \"h\" to place it horizontally");
        String s;
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        while (true) {
            s = reader.readLine();
            if (Input.checkMode(s)) {
                System.out.println("Mode: " + s);
                return s;
            } else {
                System.out.println("Wrong mode! use letter \"v\" to place it vertically or \"h\" to place it horizontally.");
            }
        }
    }

    public static boolean checkCoordinate(String s) {
        if (s.length() > 3 || s.length() < 2) {
            return false;
        }

        if (!s.toLowerCase(Locale.ROOT).substring(0, 1).matches("[a-j]")) {
            return false;
        }

        if (!s.toLowerCase(Locale.ROOT).substring(1, 2).matches("[1-9]")) {
            return false;
        }

        if (s.length() == 3 && !s.toLowerCase(Locale.ROOT).substring(2).matches("0")) {
            return false;
        }
        return true;
    }

    public static boolean checkMode(String s) {
        if (s.toLowerCase(Locale.ROOT).matches("[vh]")) {
            return true;
        }
        return false;
    }

}
