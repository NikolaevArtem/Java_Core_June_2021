package homework_1;

public class Main {
  public static void main(String[] args) {
    for (String s : args) {
      if ("error".equals(s)) {
        System.out.println("\u001B[31mAlarm!\u001B[0m\n");
        System.exit(0);
      } else {
        String letters = s.length() == 1 ? " letter" : " letters";
        System.out.println(s + ": " + s.length() + letters);
      }
    }
  }
}

