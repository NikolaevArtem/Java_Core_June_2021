package homework.task2;

import homework.ConsoleColors;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;

public class RandomCharsTable {

    public static void main(String[] args) throws IOException {
        RandomCharsTable table = new RandomCharsTable();

        char[][] toPrint = table.getTable();

        System.out.println("There is an unsorted table:");

        for (char[] ch : toPrint
        ) {
            System.out.println(ch);
        }

        String method = table.getMethod();

        String sorted = table.getSorted(toPrint, method);

        System.out.println(sorted);

    }


    public char[][] getTable() throws IOException {
        int len;
        int wid;
        System.out.println("Enter table's length and width, please, 2 integers are expected.");

        BufferedReader reader = getReader();
        len = Integer.parseInt(reader.readLine());
        wid = Integer.parseInt(reader.readLine());

        char[][] res = new char[len][wid];

        for (int i = 0; i < len; i++) {
            for (int j = 0; j < wid; j++) {
                res[i][j] = (char) ((Math.random() * (91 - 65) + 65));
            }
        }

        return res;
    }

    public String getMethod() throws IOException {
        String method = "";

        System.out.println("Enter even or odd, please.");

        BufferedReader reader = getReader();
        String methodRAW = reader.readLine();

        if (methodRAW.equals("even") || methodRAW.equals("odd")) {
            method = methodRAW;
        } else {
            System.out.println(ConsoleColors.RED + "Wrong input, enter even or odd, please!" + ConsoleColors.RESET);
            getMethod();
        }

        reader.close();

        return method;
    }

    public String getSorted(char[][] table, String method) {
        StringBuilder result = new StringBuilder();

        switch (method) {
            case ("odd"):
                result.append("Odd letters - ");
                for (char[] ch : table
                )
                    for (char c : ch
                    ) {

                        if ((c % 2) != 0) {
                            result.append(c);
                            result.append(',');
                        }
                    }
                break;
            case ("even"):
                result.append("Even letters - ");
                for (char[] ch : table
                )
                    for (char c : ch
                    ) {
                        if ((c % 2) == 0) {

                            result.append(c);
                            result.append(',');
                        }
                    }
                break;
        }
        String res = result.toString();
        return res.substring(0, res.length() - 1);


    }

    public static BufferedReader getReader() {
        return new BufferedReader(new InputStreamReader(System.in));
    }

}
