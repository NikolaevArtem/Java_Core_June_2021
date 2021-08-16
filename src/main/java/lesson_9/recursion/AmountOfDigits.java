package lesson_9.recursion;

public class AmountOfDigits {
  // https://javarush.ru/groups/posts/1895-rekursija-v-java

  public static void main(String[] args) {
//    System.out.println(getDigits(0));
//    System.out.println(getDigits(5));
//    System.out.println(getDigits(123));
//    System.out.println(getDigits(323523));
    System.out.println(getDigits(353463462));
//    System.out.println(getDigits(343));
  }

  private static int getDigits(int i) {
    if (i < 10) {
      return 1;
    } else {
      int passedI = i / 10;
      final int result = getDigits(passedI);
      return 1 + result;
    }
  }

}
