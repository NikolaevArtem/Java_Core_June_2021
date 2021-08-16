package lesson_9.recursion;

public class Fibonacci {

  // элементы числовой последовательности,
  // в которой первые два числа равны 0 и 1, а каждое последующее число равно сумме двух предыдущих чисел

  public static void main(String[] args) {
    printFibonacci(47);
  }

  private static void printFibonacci(int input) {
    long startCount = System.currentTimeMillis();
    int fibonacci = getFibonacci(input);
    long finishCount = System.currentTimeMillis();

    System.out.println("The " + input + " Fibonacci number is: " + fibonacci +
        ". It took " + (finishCount - startCount) + " millisecond to count it.");
    System.out.println("------------------------------------------------");
  }

  private static int getFibonacci(int n) {
    if (n == 0) {
      return 0;
    } else if (n == 1) {
      return 1;
    } else {
      return getFibonacci(n - 1) + getFibonacci(n - 2);
    }
  }

}
