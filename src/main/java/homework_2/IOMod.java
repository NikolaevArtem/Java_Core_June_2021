package homework_2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class IOMod {

    public static final String ERROR = "Only 1 non-negative integer is allowed as passed parameter";
    public static final String FORMAT_ERROR = "Passed parameters should match the format [positive integer] [positive integer] [even|odd]";

    public static int bufferedReaderIntReader() {
        int i = -1;
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            i = Integer.parseInt(reader.readLine());
        } catch (NumberFormatException | IOException e) {
            System.out.println(ERROR);
        }
        return i;
    }

    public static String bufferedReaderStringReader() {
        String s = "";
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            s = reader.readLine();
        } catch (IOException e) {
            System.out.println(FORMAT_ERROR);
        }
        return s;
    }

}
