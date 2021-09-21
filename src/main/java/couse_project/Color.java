package couse_project;

public class Color {

    static String blue = "\033[1;34m";
    static String red = "\033[1;31m";
    static String yellow = "\033[1;33m";
    static String white = "\033[1;37m";
    static String reset = "\033[0m";

    public static String setColor(String text, String color) {
        return color + text + reset;
    }
}
