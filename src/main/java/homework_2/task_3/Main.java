package homework_2.task_3;

import java.util.Scanner;

import static homework_2.task_1.TrafficLight.ANSI_RED;
import static homework_2.task_1.TrafficLight.ANSI_RESET;

/**
 * todo Document type Main
 */
public class Main {
    public static void main(String[] args) {
        Scanner systemScanner = new Scanner(System.in);
        Scanner stringScanner;
        RandomCharsTable randomCharsTable;

        System.out.println("Enter width, height and parity");
        while (systemScanner.hasNext()) {
            String s = systemScanner.nextLine();
            if (s.matches("^(([1-9][0-9]*\\s){2})(odd|even)")) {
                stringScanner = new Scanner(s);
                randomCharsTable = new RandomCharsTable(stringScanner.nextInt(), stringScanner.nextInt(), stringScanner.next());
                randomCharsTable.getResult();
            } else {
                System.out.println(ANSI_RED + "\nYou entered not valid height, width or parity" + ANSI_RESET);
            }
            System.out.println("\nEnter width, height and parity");
        }
        systemScanner.close();
    }
}
