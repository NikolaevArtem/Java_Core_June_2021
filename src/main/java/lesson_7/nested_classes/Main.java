package lesson_7.nested_classes;

import lesson_7.nested_classes.Cat.InnerCat;
import lesson_7.nested_classes.Cat.StaticInnerClass;

public class Main {

  public static void main(String[] args) {

    final InnerCat innerCat = new Cat().new InnerCat();
    innerCat.sayMeow();

    StaticInnerClass.sayMeowStatically();

    final StaticInnerClass staticInnerClass = new StaticInnerClass();
    staticInnerClass.sayMeowDynamically();

    Tailmovable tailmovable = new Tailmovable() {
      @Override
      public void moveTail() {
        System.out.println("Move tail anonymously");
      }
    };

    tailmovable.moveTail();

  }

}
