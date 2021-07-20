package lesson_5.constructors;

public class Cat extends Animal {

  public String s;

  public Cat(String s) {
    System.out.println("2. I'm cat, and I'm constructor with argument");
    this.s = s;
  }

  public Cat() {
    this("hello!");
    System.out.println("3. I'm cat, I'm here!");
  }


}
