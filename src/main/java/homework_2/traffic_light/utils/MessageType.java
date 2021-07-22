package homework_2.traffic_light.utils;

public enum MessageType {
    ERROR_MESSAGE_NEGATIVE_NUMBERS("You should enter only positive numbers or 0."),
    ERROR_MESSAGE_INCORRECT_FORMAT("You entered time in wrong format."),
    ERROR_MESSAGE_EXCEED_LIMIT("Please do not exceed the time limits. There are only 86399 seconds or 23:59:59 in a day!"),
    ERROR_MESSAGE("Something went wrong. Please restart the program!"),
    INFO_MESSAGE("Hi! This is your guide to cross the road blindly!\n"),
    INFO_MESSAGE_TO_MODE_0("You are in the default mode. To enter extra mode you should restart the program with argument 1.\n" +
            "Please enter time in seconds. From 0 to 86399."),
    INFO_MESSAGE_TO_MODE_1("You are in the extra mode.\nPlease enter time in format hh:mm:ss. From 00:00:00 to 23:59:59."),
    LIGHT_RED_MESSAGE("RED" + "\nDo not cross the road!"),
    LIGHT_GREEN_MESSAGE("GREEN" + "\nYou can cross the road!"),
    LIGHT_YELLOW_MESSAGE("YELLOW" + "\nDo not cross the road, wait a little!");

    private final String message;

    MessageType(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}