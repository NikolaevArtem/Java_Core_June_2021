package homework_2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class RandomCharsTable {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String str = reader.readLine();
        String array[] = str.split(" ");
        int length = Integer.parseInt(array[0]);
        int width = Integer.parseInt(array[1]);
        String strategy = array[2];
        while (!strategy.equals("odd") || !strategy.equals("even")) {
            if (strategy.equals("odd") || strategy.equals("even")) {
                break;
            }
            System.out.println("You should print : even or odd");
            strategy = reader.readLine();
        }
        char[][] arr = new char[length][width];
        String res = "";
        for (int i = 0; i < length; i++) {
            for (int j = 0; j < width; j++) {
                int check = (int) (Math.random() * ((90 - 65) + 1)) + 65;
                char result = (char) check;
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
        System.out.println(Arrays.deepToString(arr));
        if (strategy.equals("even")) {
            System.out.println("Even number : " + res.substring(0, res.length() - 1));
        } else System.out.println("Odd number : " + res.substring(0, res.length() - 1));
    }
}
