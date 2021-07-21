package lesson_6.class_object;

public class Animal {

  protected String name = "myname";

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }

    Animal animal = (Animal) o;

    return name != null ? name.equals(animal.name) : animal.name == null;
  }

  @Override
  public int hashCode() {
    return name != null ? name.hashCode() : 0;
  }
}
