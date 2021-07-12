package lesson_4.if_cycles;

public class Main_switch {

  public static void main(String[] args) {
    String s = "Goodbye";
    switch (s) {
      case "Goodbye":
        System.out.println("Goodbye");
        break;
      case "Hello":
        System.out.println("Hello");
        break;
      default:
        System.out.println("Close program");
        break;
    }
  }

}
