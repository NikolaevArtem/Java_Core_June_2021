package homework_2.traffic_light;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class TrafficLight {

    public static final String RESET = "\u001B[0m";
    public static final String RED = "\u001B[31m" + "RED" + RESET;
    public static final String GREEN = "\u001B[32m" + "GREEN" + RESET;
    public static final String YELLOW = "\u001B[33m" + "YELLOW" + RESET;
    public static final String ERROR = "Only 1 non-negative integer is allowed as passed parameter";

    public void run() {
        System.out.println("Please, input a number of seconds:");
        int seconds = bufferedReaderReadConsole();

        try {
            validateInput(seconds);
        } catch (IllegalArgumentException e) {
            return;
        }

        System.out.println(showLight(seconds));
    }

    private int bufferedReaderReadConsole() {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            int secondsIn = Integer.parseInt(reader.readLine());
            return secondsIn;
        } catch (IOException e) {
            e.printStackTrace();
        }
        // Что лучше возвращать в return?
        return -1;
    }

    // Как тестировать?
    private void validateInput(int i) {
        if (i < 0) {
            System.out.println(ERROR);
            throw new IllegalArgumentException();
        } else if (i > 86399) {
            System.out.println("The day is over");
            throw new IllegalArgumentException();
        }
    }

    // Можно ли здесь сделать метод статическим (для более короткого вызова метода в тестах),
    // или это неправильно?
    public static String showLight(int i) {

        int secondsMod = i % 60;
        return secondsMod < 35 ? GREEN
                : secondsMod < 40 ? YELLOW
                : secondsMod < 55 ? RED
                : YELLOW;
    }
}
