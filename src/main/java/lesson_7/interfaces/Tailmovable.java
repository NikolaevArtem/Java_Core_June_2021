package lesson_7.interfaces;

public interface Tailmovable {

  void moveTail();

  public static interface Tailhavable extends Tailmovable {

    void showYourTail();

  }

}
