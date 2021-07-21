package lesson_6.inheritance;

import lesson_6.inheritance.model.Man;
import lesson_6.inheritance.model.Programmer;

public class Main {

  public static void main(String[] args) {

    Man man = new Man();
    Programmer programmer = new Programmer();
    Man manButProgrammer = new Programmer();

    Man manMan = programmer; //ok
    if (manButProgrammer instanceof Programmer) {
      Programmer programmerProgrammer = (Programmer) manButProgrammer; // ok
    }
//    Programmer programmer1 = (Programmer) man; // ClassCastException

    System.out.println("Man has " + man.getPet().getClass().getSimpleName());
    System.out.println("Programmer has " + programmer.getPet().getClass().getSimpleName());
    System.out.println("ManButProgrammer has " + manButProgrammer.getPet().getClass().getSimpleName());

    man.feedCat();
    programmer.feedCat();
    manButProgrammer.feedCat();

  }

}
