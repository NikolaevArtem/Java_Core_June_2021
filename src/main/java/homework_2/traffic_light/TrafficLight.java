package homework_2.traffic_light;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class TrafficLight {
//    считывает количество секунд с начала дня с командной строки во время работы, переводит в инт,
//    выводит в командную строку цвет светофора (любым вариантом/сообщением,
//    главное чтобы было различие зеленый-желтый-красный).
//    Цикл светофора - 60 секунд.
//    С 0 <= light < 35 зеленый, 35 <= light < 40 желтый, 40 <= light < 55 красный, 55 <= light < 60 желтый.
//
//    Ограничения ввода: минимальное 0, максимальное 24*60*60 - 1 = 86399

    public static final String RESET = "\u001B[0m";
    public static final String RED = "\u001B[31m";
    public static final String GREEN = "\u001B[32m";
    public static final String YELLOW = "\u001B[33m";

    public void run() {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String str;

        System.out.println("Enter the number from 0 to 86399");

        try {
            str = reader.readLine();
            int time = Integer.parseInt(str);
            if (time < 0) {
                System.out.println("Only 1 non-negative integer is allowed as passed parameter ");
            } else if (time > 86399) {
                System.out.println("The day is over");
            } else {
                int light = time % 60;

                if (light < 35) {
                    System.out.println(GREEN + "GREEN" + RESET);
                } else if (light < 40) {
                    System.out.println(YELLOW + "YELLOW" + RESET);
                } else if (light < 55) {
                    System.out.println(RED + "RED" + RESET);
                } else {
                    System.out.println(YELLOW + "YELLOW" + RESET);
                }
            }
        } catch (NumberFormatException | IOException e) {
            System.out.println("Only 1 non-negative integer is allowed as passed parameter");
        }
    }
}
