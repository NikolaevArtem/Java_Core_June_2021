package homework_1;

public class Main {

  public static void main(String[] args) {

    for (String a : args) {
      if (a.equals("error")) {
        System.out.println("\u001B[31m" + "Error" + "\u001B[0m");
        break;
      }

      System.out.println(a + ":" + a.length() + " letters");
    }
  }
}
