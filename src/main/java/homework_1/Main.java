package homework_1;

public class Main {
  static final String RED = "\u001b[31m";
  static final String RESET = "\u001b[0m";

  public static void main(String[] args) {
      for (int i = 0; i < args.length; i++) {
      if (args[i].equals("error")) {
        System.out.println(RED + "Alarm!"+ RESET);
        break;
      } else {
        System.out.println(args[i] + ": " + args[i].length() + " letters");
      }
    }
  }
}
