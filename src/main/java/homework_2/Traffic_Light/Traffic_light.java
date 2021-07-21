package homework_2.Traffic_Light;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
 * Traffic_light
 *
 * v1
 *
 * Prihodko Dmitriy
 */

public class Traffic_light {
    public static void main(String[] args) {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int seconds = 0;
        try {
            seconds = Integer.parseInt(reader.readLine());

            if(seconds>86399)
                throw new IndexOutOfBoundsException();
            if(seconds<0)
                throw new ArithmeticException();
        } catch (NumberFormatException e) {
            System.out.println("ошибка, только числа");
            return;
        } catch (IndexOutOfBoundsException e) {
            System.out.println("ошибка, недопустимое значение");
            return;
        } catch (ArithmeticException e) {
            System.out.println("ошибка, только позитивные");
            return;
        } catch (IOException e) {
            e.printStackTrace();
        }

        if(seconds>60)
            seconds %= 60;

        if (seconds<35){
            System.out.println("зеленый");
        } else if(seconds<40){
            System.out.println("желтый");
        } else if(seconds<55){
            System.out.println("красный");
        } else {
            System.out.println("желтый");
        }
    }
}
