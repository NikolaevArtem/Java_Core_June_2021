package Homework_2.PyramidPrinter;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class PyramidPrinter {

    public void run () {
        String inputData = consoleReading();
        String result = processing(inputData);
        output(result);
    }


    private String consoleReading() {
        System.out.print("Enter the pyramid height as a single integer: ");
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            String  input = reader.readLine();
            return input;
        }
        catch (IOException e) {
            return "This should never happen...";
        }
    }

    private String processing(String input) {
        try {
            int blocks = Integer.parseInt(input);
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
        try{
            for (int i = 0; i < blocks; i++) {
                for (int j = 0; j <= i; j++) {
                    build.append('x');
                }
                build.append('\n');
            }
            return build.toString();
        }
        catch (OutOfMemoryError e) {
           return "Heap space is out of memory, please input a smaller integer";
        }
    }

    private void output (String result){
        System.out.print(result);
    }
}
