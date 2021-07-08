package homework_1;

public class Main {

  public static void main(String[] args) {
    //Домашняя работа от 05.07.2021
    if (args == null || args.length < 1) {
      return;
    }

    for (String arg : args) {
      if (arg.equals("error")) {
        System.out.println(ConsoleColors.RED_BOLD + "Alarm!" + ConsoleColors.RESET);
        break;
      } else {
        System.out.println(arg + ": " + arg.length() + " letters");
      }
    }
  }
}