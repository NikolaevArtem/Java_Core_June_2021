package Homework_2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.time.LocalTime;

public class TrafficLight {
    public static void main(String[] args) throws Exception {
        bufferedReaderReadConsole();
    }
    private static void bufferedReaderReadConsole() throws IOException {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            while (true)    {
                int time = Integer.parseInt(reader.readLine());
                int timeSec = time % 60;
                if (time < 0){
                    System.out.println("Не живите вчерашним днём!");
                }
                else if (time > 86399){
                    System.out.println("В будущее нельзя заглянуть так просто...");
                }
                else {
                    if (timeSec >= 0 && timeSec < 35) {
                        System.out.println("Цвет светофора - зелёный, " + "местное время: " + LocalTime.ofSecondOfDay(time));
                    } else if ((timeSec >= 35 && timeSec < 40) || (timeSec >= 55 && timeSec < 60)) {
                        System.out.println("Цвет светофора - жёлтый, " + "местное время: " + LocalTime.ofSecondOfDay(time));
                    } else if (timeSec >= 40 && timeSec < 54) {
                        System.out.println("Цвет светофора - красный, " + "местное время: " + LocalTime.ofSecondOfDay(time));
                    }
                }
            }
        }
        catch (NumberFormatException e) {
            System.out.println("Введите число!");
        }
    }
}

