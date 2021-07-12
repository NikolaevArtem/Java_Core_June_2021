package lesson_4.if_cycles;

public class Main_instanceOf {

  // instanceof
  public static void main(String[] args) {
    Integer in = Integer.parseInt("5");
    final String s = String.valueOf('$');
    System.out.println(s);

    final Integer i = new Integer(5);
    if (i instanceof Integer) { // also works for inheritance
      System.out.println("o1 instanceof Integer - true!");
    }

    if (i instanceof Number) { // also works for inheritance
      System.out.println("o1 instanceof Number - true!");
    }

    if (i instanceof Object) { // also works for inheritance
      System.out.println("o1 instanceof Object - true!");
    }
  }

}
