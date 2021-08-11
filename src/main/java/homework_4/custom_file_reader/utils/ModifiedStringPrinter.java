package homework_4.custom_file_reader.utils;


public class ModifiedStringPrinter {

    private ModifiedStringPrinter() { }

    // printing string without '.' and ',' symbols
    public static void printModifiedString(String str) {
        System.out.println(str.replaceAll("[,.]", ""));
    }

}
