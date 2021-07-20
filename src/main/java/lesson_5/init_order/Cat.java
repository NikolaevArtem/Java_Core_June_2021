package lesson_5.init_order;

public class Cat extends Animal {

  private String dynamicField;

  static {
    System.out.println("2. Static cat block");
  }

  {
    System.out.println("5. Dynamic cat block");
  }

  public Cat(String dynamicField) {
    super();
    System.out.println("6. 1st Cat constructor");
    this.dynamicField = dynamicField;
  }

  public Cat() {
    this("DynamicField is initialized in constructor");
    System.out.println("7. 2nd Cat constructor");
  }

  public String getDynamicField() {
    return dynamicField;
  }

  public static void staticMethod() {
    System.out.println("Static method is called");
  }

}
