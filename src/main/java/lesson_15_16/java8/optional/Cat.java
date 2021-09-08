package lesson_15_16.java8.optional;

import java.util.StringJoiner;

public class Cat {

  private Kitten kitten;

  public Cat(Kitten kitten) {
    this.kitten = kitten;
  }

  public Kitten getKitten() {
    return kitten;
  }

  public void setKitten(Kitten kitten) {
    this.kitten = kitten;
  }

  @Override
  public String toString() {
    return new StringJoiner(", ", Cat.class.getSimpleName() + "[", "]")
        .add("kitten=" + kitten)
        .toString();
  }
}
