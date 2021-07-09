package homework_1;

public class Main {
  public static void main(String[] args) {
    for (String s : args) {
      if ("error".equals(s)) {
        System.out.println("\u001B[31m" + "Alarm!" + "\u001B[0m\n");
        break;
      } else {
        String letters = s.length() == 1 ? " letter" : " letters";
        System.out.println(s + ": " + s.length() + letters);
      }
    }
  }
}

