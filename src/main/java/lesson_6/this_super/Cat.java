package lesson_6.this_super;

public class Cat extends Animal {

  protected String s = "Cat field!";

  public Cat(String s) {
    this.s = s;
    super.s = s;
  }

  public Cat() {

  }

  public void printField() {
    System.out.println(this.s);
  }

//  public static void print() {
//    System.out.println(super.s);
//  }

}
