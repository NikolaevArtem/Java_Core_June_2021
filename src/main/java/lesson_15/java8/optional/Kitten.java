package lesson_15.java8.optional;

import java.util.StringJoiner;

public class Kitten {

  private String name;

  public Kitten(String name) {
    this.name = name;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  @Override
  public String toString() {
    return new StringJoiner(", ", Kitten.class.getSimpleName() + "[", "]")
        .add("name='" + name + "'")
        .toString();
  }
}
