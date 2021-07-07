package homework_1;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;

public class Main {
  public static void main(String[] args) {
    System.out.println("Current codepage: " + Charset.defaultCharset());
    if (Charset.defaultCharset() != StandardCharsets.UTF_8) {
      System.out.println("For correct display cyrillic args need to run with \"-Dfile.encoding=\"UTF-8\"\"");
    }
    try {
      if (args.length == 0) {
        System.out.println("No arguments provided!");
      } else printOutput(args);
    } catch (IOException e) {
      System.err.println("Error!");
      e.printStackTrace();
    }
  }

  private static void printOutput(String[] inputArgs) throws IOException {
    for (String arg : inputArgs) {
      if (arg.matches("error")) {
        throw new IOException("Alarm!");
      }

      StringBuilder charBuffer = new StringBuilder();
      charBuffer.append("Argument: ");
//      charBuffer.append(arg.length());
//      charBuffer.append(" letters");

      String[] lettersInArg = arg.split("");
      int outputLength = Math.min(lettersInArg.length, 8); //cut off symbols more then 8 elements
      for (int i = 0; i < outputLength; i++) {
        charBuffer.append(lettersInArg[i]);
      }
      System.out.println(charBuffer);
    }
  }
}