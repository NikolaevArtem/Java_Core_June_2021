package lesson_14.serialization;

import java.io.Serializable;
import java.util.StringJoiner;

public class Kitten implements Serializable {

  private String name;
  private int age;

  public Kitten(String name, int age) {
    this.name = name;
    this.age = age;
  }

  @Override
  public String toString() {
    return new StringJoiner(", ", Kitten.class.getSimpleName() + "[", "]")
        .add("name='" + name + "'")
        .add("age=" + age)
        .toString();
  }
}
