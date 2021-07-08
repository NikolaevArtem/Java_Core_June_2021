package lesson_3.variables;

public class Main {

  public static void main(String[] args) {

//    int 1; can't start with number
    int one1_1;
//    int faf#da; // can't have signs
//    int +zero;
    int _da = 1_000_000; // except these two
    int $da;

    System.out.print("Everything is good \n");
    System.out.print("if you're on the same line");

    if (5==5) {
      System.out.println("тоже литерал");
    }

    nonDecimalSystems();
  }

  public static void nonDecimalSystems() {
    int a = 0b1101010110;
    int b = 012314;
    int c = 456;
    int d = 0x141D12;
    System.out.println("Число a в двоичной системе: " + a);
    System.out.println("Число b в восьмеричной системе: " + b);
    System.out.println("Число c в десятичной системе: " + c);
    System.out.println("Число d в шестнадцатеричной системе: " + d);
  }

}
