package Homework_2.TrafficLight;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class TrafficLight {

    public void run () throws IOException {
        InputData inputData = consoleReading();
        String result = processing(inputData);
        output(result);
    }

    private static class InputData{
        final String console;

        private InputData(String console) {
            this.console = console;
        }
    }

    private static InputData consoleReading() throws IOException {
        System.out.print("Please enter the amount of seconds as integer within 0 - 86399 range: ");
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            String  input = reader.readLine();
            return new InputData(input);
        }
    }

    private String processing(InputData input) {
        try {
            int time = Integer.parseInt(input.console);
            if (time < 0){
                throw new NumberFormatException();
            }
            else if (time > 86399){
                throw new NumberFormatException();
            }
            return color(time);
        }
        catch (NumberFormatException e) {
            return "Only 1 non-negative integer is allowed as passed parameter";
        }
    }

    private String color(int time) {
        StringBuilder light = new StringBuilder();
        int timeSec = time % 60;
        if (timeSec >= 0 && timeSec < 35) {
            light.append("GREEN");
        } else if ((timeSec >= 35 && timeSec < 40) || (timeSec >= 55 && timeSec < 60)) {
            light.append("YELLOW");
        } else if (timeSec >= 40 && timeSec < 54) {
            light.append("RED");
        }
        return light.toString();
    }

    private static void output (String result){
        System.out.print(result);
    }
}

