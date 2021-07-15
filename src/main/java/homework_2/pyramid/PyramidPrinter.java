package homework_2.pyramid;

import homework_2.ResultPrinter;

import java.io.InputStream;
import java.io.PrintStream;
import java.util.Scanner;

public class PyramidPrinter {
    private final static InputStream INPUT_STREAM = System.in;
    private final static PrintStream OUTPUT_STREAM = System.out;
    private final static PrintStream ERR_STREAM = System.err;

    public static void main(String[] args) {
        int base = getBase();
        String result = buildResult(base);

        ResultPrinter.printResult(result, Integer.toString(base), OUTPUT_STREAM, true);
    }

    private static String buildResult(int baseOfPyramid) {
        StringBuilder strBuilder = new StringBuilder();
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < baseOfPyramid; i++) {
            strBuilder.append('x');
            result
                    .append(strBuilder)
                    .append('\n');
        }
        return result.toString();
    }

    private static int getBase() {
        int base = 0;

        try(Scanner sc = new Scanner(INPUT_STREAM).useDelimiter("\n")) {
            OUTPUT_STREAM.println("Введите основание:");
            while (sc.hasNext()) {
                if (sc.hasNextInt()) {
                    base = sc.nextInt();
                    if (base > 0) {
                        break;
                    } else {
                        OUTPUT_STREAM.printf("'%d' целое, но не натуральное число\n", base);
                    }
                } else if (sc.hasNextDouble()) {
                    OUTPUT_STREAM.printf("'%.2f...' не целое число\n", sc.nextDouble());
                } else {
                    OUTPUT_STREAM.printf("'%s' не число\n", sc.next());
                }
                OUTPUT_STREAM.println("Введите натуральное число:");
            }
        } catch (Exception ex) {
            // ошибок не должно быть, но мало ли что то упустил
            ex.printStackTrace(ERR_STREAM);
        }
        return base;
    }
}
