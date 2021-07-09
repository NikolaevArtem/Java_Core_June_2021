package homework_1;

public class Main {
  public static final String ANSI_RESET = "\u001B[0m";
  public static final String ANSI_RED = "\u001B[31m";

  public static void main(String[] args) {

    for (String i: args) {
      if(i.equals("error")){
        System.out.println(ANSI_RED + "Alarm!" + ANSI_RESET);
        break;
      }
      System.out.println(i + ": " + i.length());
    }
  }

}
