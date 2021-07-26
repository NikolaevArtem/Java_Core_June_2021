package Homework_2.PyramidPrinter;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class PyramidPrinter {

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

    private static InputData consoleReading() throws IOException{
        System.out.print("Enter the pyramid height as a single number: ");
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            String  input = reader.readLine();
            return new InputData(input);
        }
    }

    private String processing(InputData input) {
        try {
            int blocks = Integer.parseInt(input.console);
            if (blocks < 0) {
                throw new NumberFormatException();
            }
            return pyramid(blocks);
        } catch (NumberFormatException e) {
            return "Only 1 non-negative integer is allowed as passed parameter";
        }
    }

    private String pyramid (int blocks) {
        StringBuilder build = new StringBuilder();
        for (int i = 0; i < blocks; i++) {
            for (int j = 0; j <= i; j++) {
                build.append('x');
            }
            build.append('\n');
        }
        return build.toString();
    }
    private static void output (String result){
        System.out.print(result);
    }
}
