package lesson_7.interfaces;

public interface Meowable extends Sayable {

  public final static String DEFAULT_MEOW = "Meow";

  public abstract void sayMeow();

  public static void sayClassName() {
    System.out.println("Meowable");
  }

}
