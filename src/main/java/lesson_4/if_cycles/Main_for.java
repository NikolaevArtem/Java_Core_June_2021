package lesson_4.if_cycles;

public class Main_for {

  public static void main(String[] args) {
    breakOuterCycle();
  }

  private static void simpleFor() {
    for (int i = 0; i < 10; i++) {
      System.out.println("Счетчик - " + i);
    }

//    int i = 0; // 1 раз
//    while(i < 10) {
//      System.out.println("Счетчик - " + i);
//      i++;
//    }

  }

  private static void forEach() {
    int[] ints = {1, 5, 0, 7, 9};
    for (int i : ints) {
      System.out.println("Итерируемся по элементу массива - " + i);
    }
  }

  private static void breakOuterCycle() {
    Outer:
    for(int i = 0; i < 10; i++) {
      System.out.println("cycle1");
      for (int j = 0; j < 10; j++) {
        System.out.println("cycle2");
        break Outer;
      }
    }
  }

}
