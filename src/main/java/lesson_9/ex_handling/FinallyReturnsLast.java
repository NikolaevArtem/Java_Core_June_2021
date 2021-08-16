package lesson_9.ex_handling;

public class FinallyReturnsLast {

  public static void main(String[] args) {
    System.out.println(run());
  }

  private static int run() {
    try {
      return 6;
    } finally {
      return 9;
    }
  }

}
