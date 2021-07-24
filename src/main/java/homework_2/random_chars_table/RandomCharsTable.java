package homework_2.random_chars_table;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class RandomCharsTable {

    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_RED = "\u001B[31m";

    public void run() {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            System.out.print("Enter the length, width and strategy(\"even\" or \"odd\")\n-> ");
            String[] arr = reader.readLine().split(" ");

            int length = Integer.parseInt(arr[0]);
            int width = Integer.parseInt(arr[1]);
            String strategy = arr[2];

            char[][] table = new RandomCharsTableCreator().create(length, width);

            PrintChars printChars = new PrintChars();

            printChars.print(table);
            printChars.print(table, strategy);

        } catch (IOException e) {
            e.printStackTrace();
        } catch (IllegalArgumentException e) {
            System.out.println(ANSI_RED + "Passed parameters should match the format " +
                    "[positive integer] [positive integer] [even|odd]" + ANSI_RESET);
        }
    }

}
