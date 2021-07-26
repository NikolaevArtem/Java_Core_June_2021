package lesson_7.nested_classes;

public class Cat_LocalCat {

  public static void main(String[] args) {
    class Dog {
      void sayHiLikeADog() {
        System.out.printf("Dog says hi!");
      }
    }

    final Dog dog = new Dog();
    dog.sayHiLikeADog();
  }

}
