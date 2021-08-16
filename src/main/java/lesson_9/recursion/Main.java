package lesson_9.recursion;

public class Main {

  public static int counter = 0;

  public static void main(String[] args) {
    recursionCall();
  }

  private static void recursionCall() {
    counter++;
    System.out.println("Hi! " + counter);
    recursionCall(); // stackOverflow
  }

}
