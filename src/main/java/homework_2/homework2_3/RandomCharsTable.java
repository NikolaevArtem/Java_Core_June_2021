package homework_2.homework2_3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class RandomCharsTable {


    static final Random random = new Random();

    public static void main(String[] args) {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            System.out.print("Enter the length, width and strategy(\"even\" or \"odd\")\n-> ");
            String[] arr = reader.readLine().split(" ");

            int length = Integer.parseInt(arr[0]);
            int width = Integer.parseInt(arr[1]);
            String strategy = arr[2];

            if (length < 1 || width < 1) {
                throw new IllegalArgumentException("Entered value <= 0");
            }
            char[][] randomLetters = getTableWithRandomLetters(length, width);

            printTable(randomLetters);

            printLetters(randomLetters, strategy);

        } catch (IOException e) {
            e.printStackTrace();
        } catch (NumberFormatException e) {
            System.err.println("Entered invalid arguments!");
        }
        catch (IllegalArgumentException e) {
            System.err.println(e.getMessage());
        }
    }


    static char[][] getTableWithRandomLetters(int length, int width) {
        char[][] randomLetters = new char[length][width];
        for (int i = 0; i < length; i++) {
            for (int j = 0; j < width; j++) {
                randomLetters[i][j] = getRandomLetter();
            }
        }
        return randomLetters;
    }

    static char getRandomLetter() {
        return (char)(random.nextInt(90 - 65 + 1) + 65);
    }

    static List<Character> getEvenLetters(char[][] letters) {
        List<Character> evenLetters = new ArrayList<>();
        for (char[] row : letters) {
            for (char column : row) {
                if ((int) column % 2 == 0) {
                    evenLetters.add(column);
                }
            }
        }
        return evenLetters;
    }


    static List<Character> getOddLetters(char[][] letters) {
        List<Character> oddLetters = new ArrayList<>();
        for (char[] row : letters) {
            for (char column : row) {
                if (column % 2 != 0) {
                    oddLetters.add(column);
                }
            }
        }
        return oddLetters;
    }

    static void printLetters(char[][] letters, String strategy){
        if (strategy.equalsIgnoreCase("even")) {
            System.out.println("Even letters - "
                    + getEvenLetters(letters).toString().replaceAll("[\\[\\]]", ""));
        } else if (strategy.equalsIgnoreCase("odd")) {
            System.out.println("Odd letters - "
                    + getOddLetters(letters).toString().replaceAll("[\\[\\]]", ""));
        } else {
            throw new IllegalArgumentException("Entered invalid mode for \"strategy\"!");
        }
    }

    static void printTable(char[][] letters) {
        for (char[] row : letters) {
            System.out.print("| ");
            for (char column : row) {
                System.out.print(column + " | ");
            }
            System.out.println();
        }
    }

}
