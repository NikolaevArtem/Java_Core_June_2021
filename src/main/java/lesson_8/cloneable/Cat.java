package lesson_8.cloneable;

import java.util.StringJoiner;

public class Cat implements Cloneable {

  private String name;
  private Breed breed;

  public Cat(String name, Breed breed) {
    this.name = name;
    this.breed = breed;
  }

  @Override
  protected Cat clone() {
    return new Cat(name, breed.clone());
  }

  @Override
  public String toString() {
    return new StringJoiner(", ", Cat.class.getSimpleName() + "[", "]")
        .add("name='" + name + "'")
        .add("breed=" + breed)
        .toString();
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public Breed getBreed() {
    return breed;
  }

  public void setBreed(Breed breed) {
    this.breed = breed;
  }
}
