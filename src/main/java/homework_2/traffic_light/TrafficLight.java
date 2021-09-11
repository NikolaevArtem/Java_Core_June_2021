package homework_2.traffic_light;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class TrafficLight {
    public enum Colour {
        RED,
        YELLOW,
        GREEN
    }
    public static Map<Colour, String> coloursForPrinting = new HashMap();
    private Colour trafficLightColour;

    static {
        coloursForPrinting.put(Colour.RED,    "\u001B[31m");
        coloursForPrinting.put(Colour.YELLOW, "\u001B[33m");
        coloursForPrinting.put(Colour.GREEN,  "\u001B[32m");
    }

    public void run() {
        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine();

        scanner.close();
        try {
            int seconds = Integer.parseInt(str);
            try {
                this.setTrafficLightColour(seconds);
                printColour();
            }
            catch (WrongSecondsException e) {
                System.out.println(e.getMessage());
            }
        } catch (NumberFormatException ex) {
            System.out.println("Error! Only numbers!");
        }
    }

    public void setTrafficLightColour(int seconds) throws WrongSecondsException {
        if (seconds < 0)
            throw new WrongSecondsException("Only non-negative integer is allowed as passed parameter!");
        else if (seconds >= 86400)
            throw new WrongSecondsException("Error! Day is over!");
        else {
            int secondsRemainder = seconds % 60;
            if (secondsRemainder < 35)
                this.setTrafficLightColour(Colour.GREEN);
            else if (secondsRemainder >= 40 && secondsRemainder < 55)
                this.setTrafficLightColour(Colour.RED);
            else //   (secondsRemainder >= 35 && secondsRemainder < 40)
                // || (secondsRemainder >= 55 && secondsRemainder < 60)
                this.setTrafficLightColour(Colour.YELLOW);
        }
    }

    class WrongSecondsException extends Exception {

        WrongSecondsException(String msg) {
            super(msg);
        }
    }

    public void setTrafficLightColour(Colour colour) {
        this.trafficLightColour = colour;
    }

    public void printColour() {
        final String ANSI_RESET = "\u001B[0m";
        Colour currentColour = this.getTrafficLightColour();

        System.out.println(coloursForPrinting.get(currentColour) + currentColour + ANSI_RESET);
    }

    public Colour getTrafficLightColour() {
        return this.trafficLightColour;
    }
}