package Homework_2.RandomCharsTable;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Random;

public class RandomCharsTable {

    public void run () throws IOException {
        InputData inputData = consoleReading();
        String result = processing(inputData);
        output(result);
    }
    private static class InputData{
        final String console;

        private InputData(String console) {
            this.console = console;
        }
    }

    private static InputData consoleReading() throws IOException {
        System.out.print("Enter the sizes of a table and a strategy: ");
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            String  input = reader.readLine();
            return new InputData(input);
        }
    }

    private String processing(InputData input) {
        try {
            String[] input_parts = input.console.split(" ");
            int length = Integer.parseInt(input_parts[0]);
            int width = Integer.parseInt(input_parts[1]);
            String strategy = input_parts[2];
            if (length < 0 || width < 0) {
                throw new NumberFormatException();
            }
            if (!strategy.equalsIgnoreCase("even") && !strategy.equalsIgnoreCase("odd")) {
                throw new NumberFormatException();
            }
            return elementsOf(length, width, strategy);
        }
        catch (NumberFormatException e) {
            return "Passed parameters should match the format [positive integer] [positive integer] [even|odd]";
        }
    }

    private String elementsOf(int length, int width, String strategy) {
        StringBuilder table = new StringBuilder();
        StringBuilder evens = new StringBuilder();
        StringBuilder odds = new StringBuilder();
        for (int i = 0; i < length; i++){
            table.append('|');
            for(int j = 0; j < width; j++) {
                Random ran = new Random();
                int number = 65 + ran.nextInt(26);
                table.append((char) number)
                        .append('|');
                if (number % 2 == 0){
                    evens = evens.length() == 0 ? evens.append((char) number) : evens.append(", " + (char) number);
                }
                else {
                    odds = odds.length() == 0 ? odds.append((char) number) : odds.append(", " + (char) number);
                }
            }
            table.append("\n");
        }
        table = strategy.equalsIgnoreCase("even") ? table.append(evens) : table.append(odds);
        return table.toString();
    }

    private static void output (String result){
        System.out.print(result);
    }
}

