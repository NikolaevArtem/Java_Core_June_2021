package lesson_4.if_cycles;

public class Main_while {

  public static void main(String[] args) {
    doWhile();
  }

  private static void simpleWhile_forever() {
    while (true) {
      System.out.println("I'm McClaud!");
    }
  }

  private static void simpleWhile_break() {
    int i = 0;
    while (true) {
      System.out.println("I'm not McClaud :(");
      if (i == 5) {
        break;
      }
      i++;
    }
  }

  private static void simpleWhile_continue() {
    int i = 0;
    while (i <= 10) {
      i++;

      if (i == 3 || i == 7) {
        continue;
      }

      System.out.println("i = " + i + ", let's continue");
    }
  }


  private static void doWhile() {
    // Проверка происходит после выполнения блока
    int i = 0;
    do {
      i++;
      System.out.println("i = " + i);
    } while (i < 0);
  }

}
