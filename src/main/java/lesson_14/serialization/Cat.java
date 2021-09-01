package lesson_14.serialization;

import java.awt.Color;
import java.io.Serializable;
import java.util.StringJoiner;

public class Cat extends Animal implements Serializable {

  public static int TAIL_LENGTH = 8; //cm
  private static final long serialVersionUID = 1646262L;

  private String name;
  private transient int age;
  private Color color;
  private Kitten kitten;

  public Cat(String name, int age, Color color, Kitten kitten) {
    System.out.println("Cat constructor here!");
    this.name = name;
    this.age = age;
    this.color = color;
    this.kitten = kitten;
  }

  public Cat() {
    System.out.println("Cat constructor here!");
  }

  @Override
  public String toString() {
    return new StringJoiner(", ", Cat.class.getSimpleName() + "[", "]")
        .add("name='" + name + "'")
        .add("age=" + age)
        .add("color=" + color)
        .add("kitten=" + kitten)
        .toString();
  }
}
