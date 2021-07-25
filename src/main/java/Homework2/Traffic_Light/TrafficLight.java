package Homework2.Traffic_Light;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class TrafficLight {
    final int END_OF_THE_DAY = 86399;

    TrafficLight getTrafficLight (int input){
        TrafficLight trafficLight = new TrafficLight();

        if (input < 0) {
            System.out.println("Error. You can't enter negative numbers");

        } else if (input > END_OF_THE_DAY) {
            System.out.println("Error. The day has come to an end");

        }
        int lightInterval = input % 60;

        if (lightInterval >= 0 && lightInterval < 35) {
            System.out.println("Green");
        } else if (lightInterval >= 35 && lightInterval < 40) {
            System.out.println("Yellow");
        } else if (lightInterval >= 40 && lightInterval < 55) {
            System.out.println("Red");
        } else if (lightInterval >= 55 && lightInterval < 60) {
            System.out.println("Yellow");
        }
        return trafficLight;
    }







    }
