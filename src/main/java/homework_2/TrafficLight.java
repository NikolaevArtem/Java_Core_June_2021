package homework_2;

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

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String str;

        while (true) {
            System.out.println("Введите целое число от 0 до 86399");
            str = reader.readLine();

            try {
                int time = Integer.parseInt(str);
                if (time < 0){
                    System.out.println("Разрешено вводить только положительные числа");
                }
                else if (time > 86399) {
                    System.out.println("Вы ввели слишком большое число. День закончился");
                }
                else {
                    int light = time % 60;

                    if (light < 35) {
                        System.out.println(" Зеленый");
                    } else if (light < 40) {
                        System.out.println("Желтый");
                    } else if (light < 55) {
                        System.out.println("Красный");
                    } else {
                        System.out.println("Желтый");
                    }
                    break;
                }
            } catch (NumberFormatException e) {
                System.out.println("Разрешено вводить только числа");
            }
        }
    }
}
