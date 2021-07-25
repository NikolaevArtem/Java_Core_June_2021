package utils;

public class Constants {
    public static final String ERROR_MESSAGE_TRAFFIC_LIGHT = "Only 1 non-negative integer is allowed as passed parameter";
    public static final String INFO_MESSAGE_TRAFFIC_LIGHT = "Hi! This is your guide to cross the road blindly!\n" +
            "You are in the default mode. To enter extra mode you should restart the program with argument 1.\n" +
            "Please enter time in seconds. From 0 to 86399: ";
    public static final String INFO_MESSAGE_TO_EXTRA_MODE_TRAFFIC_LIGHT = "Hi! This is your guide to cross the road blindly!\n" +
            "You are in the extra mode. To enter the default mode you should restart the program with no arguments.\n" +
            "Please enter time in format hh:mm:ss: ";
    public static final String ERROR_MESSAGE_EXCEED_LIMIT_TRAFFIC_LIGHT = "The day is over";
    public static final String RED_MESSAGE_TRAFFIC_LIGHT = "RED";
    public static final String GREEN_MESSAGE_TRAFFIC_LIGHT = "GREEN";
    public static final String YELLOW_MESSAGE_TRAFFIC_LIGHT = "YELLOW";

    public static final String INFO_MESSAGE_PYRAMID_PRINTER = "Please enter a positive integer for rows";
    public static final String ERROR_MESSAGE_PYRAMID_PRINTER = "Only 1 non-negative integer is allowed as passed parameter";

    public static final String ERROR_MESSAGE_RANDOM_CHARS_TABLE = "Passed parameters should match the format [positive integer] [positive integer] [even|odd]";
    public static final String INFO_MESSAGE_RANDOM_CHARS_TABLE = "Enter parameters for columns, rows and strategy that match the format: [positive integer] [positive integer] [even|odd]\n";
    public static final int MAX_CHAR = 90;
    public static final int MIN_CHAR = 65;
}