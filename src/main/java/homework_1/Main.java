package homework_1;

public class Main {
  public static final String RESET = "\033[0m";  // Text Reset
  public static final String RED_BOLD = "\033[1;31m";    // RED

  public static void main(String[] args) {
    //HW1 from 05.07.2021 (after review 09.07.2021)
    for (String arg : args) {
      if (arg.equals("error")) {
        System.out.println(Main.RED_BOLD + "Alarm!" + Main.RESET);
        break;
      } else {
        System.out.println(arg + ": " + arg.length() + " letters");
      }
    }
  }
}