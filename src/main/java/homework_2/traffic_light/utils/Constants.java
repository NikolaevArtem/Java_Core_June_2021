package homework_2.traffic_light.utils;

public class Constants {
    public static final String ERROR_MESSAGE = "Only 1 non-negative integer is allowed as passed parameter";
    public static final String INFO_MESSAGE = "Hi! This is your guide to cross the road blindly!\n" +
            "You are in the default mode. To enter extra mode you should restart the program with argument 1.\n" +
            "Please enter time in seconds. From 0 to 86399: ";
    public static final String INFO_MESSAGE_TO_EXTRA_MODE = "Hi! This is your guide to cross the road blindly!\n" +
            "You are in the extra mode. To enter the default mode you should restart the program with no arguments.\n" +
            "Please enter time in format hh:mm:ss: ";
    public static final String ERROR_MESSAGE_EXCEED_LIMIT = "The day is over";
    public static final String LIGHT_RED_MESSAGE = "RED";
    public static final String LIGHT_GREEN_MESSAGE = "GREEN";
    public static final String LIGHT_YELLOW_MESSAGE = "YELLOW";
    public static final int SECONDS_IN_DAY = 86399;
    public static final int SECONDS_IN_HOUR = 3600;
    public static final int SECONDS_IN_MINUTE = 60;
}