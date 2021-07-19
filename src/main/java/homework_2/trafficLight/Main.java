package homework_2.trafficLight;

import java.util.Scanner;

public class Main {
    private static Integer second;

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNextLine()) {
            if("".equals(in.nextLine()))
                break;
            String result = parserInt(in.nextLine());
            System.out.println(result);
        }
    }

    private static String parserInt(String str) {
        second = null;
        try {
            second = Integer.parseInt(str);
            if (second < 0)
                return "Error! Only positive!";
            else if (second >= 86400)
                return "Error! Day is over!";
            else {
                second = second % 60;
                if (second < 35)
                    return "green";
                else if (second >= 40 && second < 55)
                    return "red";
                else // second >= 35 && second < 40 || second >= 55 && second < 60
                    return "yellow";
            }
        } catch (NumberFormatException e) {
            return "Error! Only numbers!";
        }
    }
}