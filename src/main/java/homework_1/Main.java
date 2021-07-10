package homework_1;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;

public class Main {
    public static void main(String[] args) {
        if (Charset.defaultCharset() != StandardCharsets.UTF_8) {
            System.out.println("For correct display cyrillic args need to run with \"-Dfile.encoding=\"UTF-8\"\"");
        }
        try {
            if (args.length == 0) {
                System.out.println("No arguments provided!");
            } else for (String arg : args) {
                if (arg.matches("error")) {
                    throw new IOException("Alarm!");
                }
                System.out.printf("%s : %s letter(s)\n", arg, arg.length());
            }
        } catch (IOException e) {
            System.err.println("Error!");
            e.printStackTrace();
        }
    }
}