package homework_2.traffic_light;

class ColorSelector {
    protected static final String ANSI_RESET = "\u001B[0m";
    protected static final String ANSI_RED = "\u001B[31m";
    protected static final String ANSI_GREEN = "\u001B[32m";
    protected static final String ANSI_YELLOW = "\u001B[33m";
    protected static final String MESSAGE = "The traffic light is";

    protected static String pickColor(String color) {
        if (color.equals("green")) {
            return MESSAGE + ANSI_GREEN + " Green" + ANSI_RESET + " now";
        } else if (color.equals("yellow")) {
            return MESSAGE + ANSI_YELLOW + " Yellow" + ANSI_RESET + " now";
        } else
            return MESSAGE + ANSI_RED + " Red" + ANSI_RESET + " now";
    }
}
