package lesson_4.operators;

public class Main_ShortenedBooleanOperators {

  public static void main(String[] args) {
    if (bFalse() && bTrue());
    System.out.println();
    if (bFalse() & bTrue());
    System.out.println();

//    String s = null;
//    if (s != null & s.equals("smth")) {
//      System.out.println("Hooray!");
//    }
  }

  private static boolean bTrue() {
    System.out.print("true ");
    return true;
  }

  private static boolean bFalse() {
    System.out.print("false ");
    return false;
  }
}
