package lesson_2.access_modifiers.models_v1;

public class Human {

  public void publicMove() {
    System.out.println("Human publicMove");
  }

  void packageMove() {
    System.out.println("Human packageMove");
  }

  protected void protectedMove() {
    System.out.println("Human protectedMove");
  }

  private void privateMove() {
    System.out.println("Human privateMove");
  }

  public static void main(String[] args) {
    final Human human = new Human();
    human.publicMove();
    human.packageMove();
    human.protectedMove();
    human.privateMove();
  }

}
