package homework_2.traffic_light;

public class Main {

    public static void main(String[] args) {

        TrafficLight traffic_light = new TrafficLight();
        traffic_light.run();
    }
}
//Цикл светофора - 60 секунд. С 0 <= light < 35 зеленый, 35 <= light < 40 желтый, 40 <= light < 55 красный, 55 <= light < 60 желтый.