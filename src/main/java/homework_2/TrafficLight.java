package homework_2;

import java.util.Scanner;

/**
 * считывает один раз количество секунд с начала дня с командной строки во время работы, переводит в инт,
 * выводит в командную строку цвет светофора (GREEN зеленым цветом, YELLOW желтым, RED красным).
 *
 * Цикл светофора - 60 секунд. С 0 <= light < 35 зеленый, 35 <= light < 40 желтый, 40 <= light < 55 красный,
 * 55 <= light < 60 желтый.
 *
 * Ограничения ввода: минимальное 0, максимальное 24*60*60 - 1 = 86399
 *
 * AC:
 *
 * input - 0, output - GREEN
 *
 * input - 5, output - GREEN
 *
 * input - 35, output - YELLOW
 *
 * input - 54, output - RED
 *
 * input - 86401, output - The day is over
 *
 * Любая ошибка с некорректным вводом: output - Only 1 non-negative integer is allowed as passed parameter
 */

public class TrafficLight {
    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_GREEN = "\u001B[32m";
    public static final String ANSI_YELLOW = "\u001B[33m";

    private static boolean validInput = false;
    private static Scanner scan = new Scanner(System.in);
    private static int inputInt = -1;

    public static void defineColor(){
        getSecondsFromInput();
        int cycleSec = defineCyclePeriod();

        if(0 <= cycleSec && cycleSec < 35){
            System.out.println(ANSI_GREEN + "GREEN" + ANSI_RESET);
        } else if(35 <= cycleSec && cycleSec < 40){
            System.out.println(ANSI_YELLOW + "YELLOW" + ANSI_RESET);
        } else if(40 <= cycleSec && cycleSec < 55){
            System.out.println(ANSI_RED + "RED" + ANSI_RESET);
        } else if(55 <= cycleSec && cycleSec < 60) {
            System.out.println(ANSI_YELLOW + "YELLOW" + ANSI_RESET);
        }
    }

    private static void getSecondsFromInput() {
        String errorMsg = "Only 1 non-negative integer is allowed as passed parameter";
        while (validInput == false) {
            if (scan.hasNextInt()) {
                inputInt = scan.nextInt();
                if(inputInt < 0) {
                    System.out.println(errorMsg);
                } else if (inputInt > 86400){
                    System.out.println("The day is over");
                } else if (inputInt == 86400){
                    inputInt = 0;
                    validInput = true;
                } else {
                    validInput = true;
                }
            } else
                System.out.println(errorMsg);
            scan.nextLine();
        }
    }

    private static int defineCyclePeriod(){
        return inputInt%60;
    }
}
