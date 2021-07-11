package homework_1;

public class Main {
  public static final String ANSI_RED = "\u001B[31m";
  public static final String ANSI_RESET = "\u001B[0m";

  public static void main(String[] args) {

    for(String a: args) {
      if (a.equals("error")) {
        System.out.println(ANSI_RED + "Alarm!" + ANSI_RESET);
        break;
      }
      System.out.println(a + ": " + a.length());
    }

  }
}