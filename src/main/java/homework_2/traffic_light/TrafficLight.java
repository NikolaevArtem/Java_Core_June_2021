package homework_2.traffic_light;

import java.util.Scanner;

public class TrafficLight {

    public void run(){
        Scanner in = new Scanner(System.in);
        Color printTraffic = new Color();
        System.out.println("Введите количество секунд");
        try {
            int time = in.nextInt();
            int sec = time % 60;
            if (time < 0 || time >= 86400)
                printTraffic.error();
            else if(sec >= 0 && sec < 35)
                printTraffic.green();
            else if((sec >= 35 && sec < 40) || (sec >= 55 && sec < 60))
                printTraffic.yellow();
            else if(sec >= 40 && sec < 50)
                printTraffic.red();
        } catch (NumberFormatException e){
            System.out.println("Only 1 non-negative integer integer is allowed as passed parameter");
        }

    }
}
