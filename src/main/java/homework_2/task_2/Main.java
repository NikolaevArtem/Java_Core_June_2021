package homework_2.task_2;

import java.util.Scanner;

/**
 * todo Document type Main
 */

import static homework_2.task_1.TrafficLight.ANSI_RED;
import static homework_2.task_1.TrafficLight.ANSI_RESET;


public class Main {
    public static void main(String[] args) {
        System.out.println("Enter the number");
        Scanner scanner = new Scanner(System.in);

        if (scanner.hasNextInt()) {
            int n = scanner.nextInt();
            if (n > 0) {
                PyramidPrinter.printPyramid(n);
            } else {
                System.out.println(ANSI_RED + "Not positive number" + ANSI_RESET);
            }
        } else {
            System.out.println(ANSI_RED + "Not valid number" + ANSI_RESET);
        }
    }
}
