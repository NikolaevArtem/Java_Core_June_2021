package homework_2.task_1;

import java.util.Scanner;

import static homework_2.task_1.TrafficLight.ANSI_RED;
import static homework_2.task_1.TrafficLight.ANSI_RESET;

public class Main {
    public static void main(String[] args) {
        TrafficLight trafficLight = new TrafficLight();
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter the number (-1 for exit)");
        while (scanner.hasNext()) {
            if (scanner.hasNextInt()) {
                trafficLight.setNumberOfSeconds(scanner.nextInt());
                if (trafficLight.getNumberOfSeconds() == -1) {
                    break;
                }
                if (trafficLight.checkEnter()) {
                    trafficLight.getTrafficLight();
                }
            } else {
                String s = scanner.next();
                //TODO hh:mm:ss input format

                System.out.println(ANSI_RED + "Please, enter the valid number" + ANSI_RESET);
            }
            System.out.println("Enter the number (-1 for exit)");
        }
        scanner.close();
    }
}
