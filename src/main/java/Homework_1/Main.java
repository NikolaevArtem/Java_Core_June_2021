package Homework_1;

public class Main {
  protected static final String RED_COLOR = "\033[31m";
  protected static final String GREEN_COLOR = "\033[32m";
  protected static final String RESET_COLOR = "\033[0m";

  public static void main(String[] args) {

    int k = args.length;
    if (k == 0) {
      System.out.println(GREEN_COLOR + "Application has been called " + RED_COLOR + "without " + GREEN_COLOR + "the arguments!" + RESET_COLOR);
    } else {
      for (int i = 0; i < k; i++) {
        if (args[i].equals("error")) {
          //https://stackoverflow.com/questions/565252/how-to-set-a-strings-color
          System.out.println(RED_COLOR + "Alarm!" + RESET_COLOR);
          //exit from the loop
          break;
        }
        else {
          String s = "letter";
          if (args[i].length() > 1) {s = s + "s";}
          System.out.println(args[i] + ": " + args[i].length() + " " + s);
        }
      }
    }
  }
}