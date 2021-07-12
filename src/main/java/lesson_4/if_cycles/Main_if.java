package lesson_4.if_cycles;

public class Main_if {

  public static void main(String[] args) {
    int i = 5;

    // if (i = 5)  not equality, but assignment
    if (5 != 5) System.out.println("Wrong way");
    if (i != 5) {
      System.out.println("Correct way");
    }

    boolean b1 = false;
    boolean b2 = false;
    boolean b3 = false;

    // True в условии останавливает дальнейшее выполнение
    // Присваивание в условии тоже возможно
    if (b1) {
      System.out.println("First condition is true");
    } else if (b2) {
      System.out.println("Second condition is true");
    } else if (b3) {
      System.out.println("Third condition is true");
    } else {
      System.out.println("All previous are false");
    }


  }

}
