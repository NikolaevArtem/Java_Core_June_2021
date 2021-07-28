package lesson_8.comparable_comparator;

import java.util.StringJoiner;
import lesson_8.enums.CatSize;

public class Cat implements Comparable {

  private String name;
  private Integer age;
  private CatSize size;

  public Cat(String name, Integer age, CatSize size) {
    this.name = name;
    this.age = age;
    this.size = size;
  }

  @Override
  public int compareTo(Object o) {
    Cat anotherCat = (Cat) o;
    return name.compareTo(anotherCat.name);
  }

  @Override
  public String toString() {
    return new StringJoiner(", ", Cat.class.getSimpleName() + "[", "]")
        .add("name='" + name + "'")
        .add("age=" + age)
        .add("size='" + size + "'")
        .toString();
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public Integer getAge() {
    return age;
  }

  public void setAge(Integer age) {
    this.age = age;
  }

  public CatSize getSize() {
    return size;
  }

  public void setSize(CatSize size) {
    this.size = size;
  }
}
