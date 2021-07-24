package homework_2.Traffic_Light;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Traffic_light {

    public void run() {

        int seconds;
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))){
            seconds = Integer.parseInt(reader.readLine());

            if(seconds>86399) {
                System.out.println("ошибка, недопустимое значение");
                return;
            }
            if(seconds<0) {
                System.out.println("ошибка, только позитивные");
                return;
            }
        } catch (NumberFormatException | IOException e) {
            System.out.println("ошибка, только числа");
            return;
        }

        int result;

        if(seconds>60)
            result = seconds%60;
        else result = seconds;

        if (result<35){
            System.out.println("зеленый");
        } else if(result<40){
            System.out.println("желтый");
        } else if(result<55){
            System.out.println("красный");
        } else {
            System.out.println("желтый");
        }
    }
}
