package homework_2.traffic_light;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class InputValidator {

    private void errorMsg(){
        System.out.println("Only 1 non-negative integer is allowed as passed parameter.");
    }

    public void input(TrafficLight trafficLight) {
        try (BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in))) {
            String str = bufferedReader.readLine();
            if (isStringNumeric(str)) {
                int seconds = Integer.parseInt(str);
                if (seconds < 0) {
                    throw new IllegalArgumentException();
                } else if (seconds > 86399) {
                    System.out.println("The day is over");
                } else {
                    int tmp = seconds % 60;
                    trafficLight.showLight(tmp);
                }
            } else {
                throw new IllegalArgumentException();
            }
        }
        catch (IOException e) {
            System.out.println("Something went wrong");
        }
        catch (IllegalArgumentException e){
            errorMsg();
        }
    }

    private boolean isStringNumeric(String str) {
        try {
            Integer.parseInt(str);
        } catch (NumberFormatException | NullPointerException e) {
            return false;
        }
        return true;
    }
}
