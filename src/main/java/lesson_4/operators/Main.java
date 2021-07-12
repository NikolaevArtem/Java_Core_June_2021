package lesson_4.operators;

public class Main {

  public static void main(String[] args) {
    // https://javarush.ru/groups/posts/logicheskie-operacii-v-java
    // usualOperators();
    // operatorsWithAssignment();
    // incrementAndDecrement();
    // booleanOperators();
    ternaryOperator();
  }

  private static void usualOperators() {
    int i = 10;
    // + - * / %
    System.out.println("10 - 3 = " + (i - 3));
//    System.out.println("10 + 3 = " + i + 3);
    System.out.println("10 + 3 = " + (i + 3));
    System.out.println("10 * 3 = " + (i * 3));
    System.out.println("10 / 3 = " + (i / 3)); // деление нацело
    System.out.println("10 % 3 = " + (i % 3)); // остаток от деления
  }

  private static void operatorsWithAssignment() {
    int i = 10;
    // += -= *= /= %=
    System.out.println("10 += 3 = " + (i += 3) + ", i = " + i);
    System.out.println("13 -= 3 = " + (i -= 3) + ", i = " + i);
    System.out.println("10 *= 3 = " + (i *= 3) + ", i = " + i);
    System.out.println("30 /= 3 = " + (i /= 3) + ", i = " + i);
    System.out.println("10 %= 3 = " + (i %= 3) + ", i = " + i);
  }

  private static void incrementAndDecrement() {
    int i = 10;
    // ++i --i i++ i--
//    int i3 = 10;
//    i3++;
//    System.out.println(i3);

    System.out.println("Operation i++ = " + i++ + 3 + ", i after operation = " + i);
    System.out.println("Operation i-- = " + i-- + ", i after operation = " + i);
    System.out.println("Operation ++i = " + ++i + 3 + ", i after operation = " + i);
    System.out.println("Operation --i = " + --i + ", i after operation = " + i);
//    int i5 = 10;
//    i5 = i5++;
//    System.out.println(i5);
  }

  private static void booleanOperators() {
    int i1 = 5;
    int i2 = 5;
    int c = 7;
//    System.out.println(i1 = i2);
//    System.out.println(i1);
    System.out.println(i1 == i2); // true
    System.out.println(i1 != i2); // false
    System.out.println(c > i1); // true

    System.out.println(!(i1 == i2)); // false
    System.out.println(i1 == i2 && i1 == c); // false
    System.out.println(i1 == i2 || i1 == c); // true
    System.out.println(true ^ false); // true
    System.out.println(true ^ true); // false

    boolean b = true;
    b &= false;
    System.out.println(b); // false
  }

  private static void ternaryOperator() {
    // ternary operator
    String statement = 5 == 5 && 6 != 6 ? 6 == 6 ? "Math" : "Not math" : "Math is broken";
    System.out.println("How's math? " + statement);
  }

}
