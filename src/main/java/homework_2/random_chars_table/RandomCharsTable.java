package homework_2.random_chars_table;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

public class RandomCharsTable {

    private int length;
    private int width;
    private String mode;
    private char c;
    private List<Character> chars;

    public void run() {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            List<String> list = Arrays.asList(reader.readLine().split(" "));

            length = Integer.parseInt(list.get(0));
            width = Integer.parseInt(list.get(1));
            mode = list.get(2);
            chars = new ArrayList<>();

            if (list.size() > 3 || length <= 0 || width <= 0 || (!mode.equals("odd") && !mode.equals("even"))) {
                throw new NumberFormatException();
            }

            for (int i = 0; i < length; i++) {
                for (int j = 0; j < width; j++) {
                    generateChar(mode);
                    System.out.print("| " + c + " ");
                }
                System.out.println("|");
            }

            if (mode.equals("even")) {
                System.out.print("Even letters - ");
            }
            if (mode.equals("odd")) {
                System.out.print("Odd letters - ");
            }

            for (int i = 0; i < chars.size(); i++) {
                System.out.print(chars.get(i));
                if (i + 1 != chars.size()) {
                    System.out.print(", ");
                }
            }

        } catch (InputMismatchException | NumberFormatException e) {
            System.out.println("Passed parameters should match the format " +
                    "[positive integer] [positive integer] [even|odd]");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void generateChar(String mode) {
        c = (char) ThreadLocalRandom.current().nextInt('A', 'Z');

        if ((mode.equals("odd") && c % 2 != 0) || (mode.equals("even") && c % 2 == 0)) {
            chars.add(c);
        }
    }
}