package lesson_15_16.java8.streams;

import java.util.StringJoiner;

public class People {

  enum Sex {
    MAN,
    WOMAN
  }

  private String name;
  private int age;
  private Sex sex;

  public People(String name, int age, Sex sex) {
    this.name = name;
    this.age = age;
    this.sex = sex;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public int getAge() {
    return age;
  }

  public void setAge(int age) {
    this.age = age;
  }

  public Sex getSex() {
    return sex;
  }

  public void setSex(Sex sex) {
    this.sex = sex;
  }

  @Override
  public String toString() {
    return new StringJoiner(", ", People.class.getSimpleName() + "[", "]")
        .add("name='" + name + "'")
        .add("age=" + age)
        .add("sex=" + sex)
        .toString();
  }
}
