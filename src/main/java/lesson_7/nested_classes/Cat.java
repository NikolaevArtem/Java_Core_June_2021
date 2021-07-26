package lesson_7.nested_classes;

public class Cat {

  private int times = 5;

  public class InnerCat {
    private int innerTimes = 6;

    public void sayMeow() {
      System.out.println(times);

      System.out.println("InnerClass - meow!");
    }
  }

  public static class StaticInnerClass {

    public static int innerStaticTimes = 0;

    public static void sayMeowStatically() {
//      System.out.println(times); field needs to be static

      System.out.println("StaticInnerClass - meow!");
    }

    public void sayMeowDynamically() {
      System.out.println("StaticInnerClass - meow dynamically!");
    }

  }

}
