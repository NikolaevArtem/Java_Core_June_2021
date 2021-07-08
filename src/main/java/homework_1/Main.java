package homework_1;
import java.util.Scanner;

public class Main {
  static final String RED = "\u001b[31m";
  static final String RESET = "\u001b[0m";

  public static void main(String[] args) {
    try {
      dialog();
    } catch (AlarmException e) {
      System.out.println(e.getMessage());
    }
  }

  public static void dialog() throws AlarmException {
    System.out.println("Enter arguments:");
    Scanner console = new Scanner(System.in);

    while (console.hasNext()) {
      String word = console.next();

      if (!word.equals("error")) {
        int n = word.length();
        System.out.println(word + ": " + n + " letters");
      } else {
        throw new AlarmException(RED + "Alarm!"+ RESET);
      }
    }
  };

  public static class AlarmException extends Exception {
    public AlarmException(String message) {
      super(message);
    }
  }

}
