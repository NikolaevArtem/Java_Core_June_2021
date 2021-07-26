package lesson_7.nested_classes;

public class Cat_AnonymousCat {

  public static void main(String[] args) {

    Animal animal = new Animal() {

      public int i = 5;

      @Override
      public void sayHi() {
        System.out.println("Say hi like an anonymous class");
      }

      @Override
      public void sayGoodbye() {
        System.out.println("Say goodbye like an anonymous class");
      }
    };

    animal.sayHi();
    animal.sayGoodbye();

  }

}
