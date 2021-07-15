package homework_2.pyramid_printer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class PyramidPrinter {
    private static final char SPEC_CHAR = 'x';

    public static void main(String[] args) throws IOException {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            int n = Integer.parseInt(br.readLine());
            for (int i = 0; i < n; i++) {
                printNTimes(i + 1, SPEC_CHAR);
                System.out.println();
            }
        } catch (NumberFormatException e) {
            System.out.println("Integers supported only");
        }
    }

    private static void printNTimes(int n, char c) {
        for (int i = 0; i < n; i++) {
            System.out.print(c);
        }
    }
}
