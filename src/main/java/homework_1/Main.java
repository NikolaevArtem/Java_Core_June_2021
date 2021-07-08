package homework_1;

public class Main {

  public static void main(String[] args) {

    for (String arg : args) {
      if (arg.equals("error")) {
        System.out.println("\u001B[41m" + "Alarm!" + "\u001B[0m");
        break;
      }
      if (arg.length() != 8) {
        continue;
      }
      System.out.println(arg + ": " + arg.length());
    }
  }

}
