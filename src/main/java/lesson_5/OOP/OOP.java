package lesson_5.OOP;

class OOP { // without public - > becomes "friendly" - same to default

  // https://javarush.ru/groups/posts/principy-oop#%D0%90%D0%B1%D1%81%D1%82%D1%80%D0%B0%D0%BA%D1%86%D0%B8%D1%8F-%D0%9E%D0%9E%D0%9F

  public String publicString;
  protected String protectedString;
  String defaultString;
  private String privateString;

  public void publicMethod() {
    System.out.println("I'm for API!");
  }

  protected void protectedMethod() {
    System.out.println("I'm for inheritance!");
  }

  void defaultMethod() {
    System.out.println("I'm for encapsulation!");
  }

  private void privateMethod() {
    System.out.println("I'm for a single-class internal kitchen!");
  }

  // Абстракция
    // Example - abstract class/interface
  // Инкапсуляция
    // Example - access modifiers
  // Наследование
    // Example - наследование классов
  // Полиморфизм
    // Example - overriding, call(abstractPhone);

}
