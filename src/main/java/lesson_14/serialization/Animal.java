package lesson_14.serialization;

import java.io.Serializable;

public class Animal implements Serializable {

  protected Animal() {
    System.out.println("Animal constructor here!");
  }

}
