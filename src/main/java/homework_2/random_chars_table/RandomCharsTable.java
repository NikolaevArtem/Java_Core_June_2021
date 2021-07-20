package homework_2.random_chars_table;

import homework_1.Start;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class RandomCharsTable implements Start {

    private static void printResult(int length, int width, char arr[][], String strategy, String res) {
        for (int i = 0; i < length; i++) {
            for (int j = 0; j < width; j++) {
                System.out.print("|" + arr[i][j]);
            }
            System.out.print("|");
            System.out.println();
        }
        if (strategy.equals("even")) {
            System.out.println("Even number : " + res.substring(0, res.length() - 1));
        } else System.out.println("Odd number : " + res.substring(0, res.length() - 1));
    }

    public void start() throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        try {
            String str = reader.readLine();
            String array[] = str.split(" ");
            int length = Integer.parseInt(array[0]);
            int width = Integer.parseInt(array[1]);
            String strategy = array[2];
            if (strategy.equals("odd") || strategy.equals("even")) {
                char[][] arr = new char[length][width];
                String res = "";
                for (int i = 0; i < length; i++) {
                    for (int j = 0; j < width; j++) {
                        double x = (Math.random() * ((90 - 65) + 1)) + 65;
                        int check = (int) x;
                        char result = (char) x;
                        arr[i][j] = result;
                        if (strategy.equals("even")) {
                            if (check % 2 == 0) {
                                res += " " + (char) check + " ,";
                            }
                        } else {
                            if (check % 2 != 0) {
                                res += " " + (char) check + " ,";
                            }
                        }
                    }
                }
                printResult(length, width, arr, strategy, res);
            } else {
                System.out.println("After two number you should print even or odd");
                return;
            }
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("You need to print two number and one String");
            return;
        } finally {
            reader.close();
        }
    }
}
