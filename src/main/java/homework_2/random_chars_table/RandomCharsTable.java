package homework_2.random_chars_table;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.ThreadLocalRandom;

public class RandomCharsTable {

    private int length;
    private int width;
    private String mode;
    private char c;
    private List<Character> chars;

    public void run() {
        try (Scanner scanner = new Scanner(System.in)) {
            length = scanner.nextInt();
            width = scanner.nextInt();
            mode = scanner.next();
            chars = new ArrayList<>();

            if (length == 0 || width == 0 || (!mode.equals("odd") && !mode.equals("even"))) {
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

        } catch (NumberFormatException e) {
            System.out.println("Passed parameters should match the format " +
                    "[positive integer] [positive integer] [even|odd]");
        }
    }

    private void generateChar(String mode) {
        c = (char) ThreadLocalRandom.current().nextInt(65, 90);

        if ((mode.equals("odd") && c % 2 != 0) || (mode.equals("even") && c % 2 == 0)) {
            chars.add(c);
        }
    }
}