package lesson_6.class_object;

import java.util.StringJoiner;

public class Cat extends Animal{

  private String s;
  private int i;

  public Cat(String s) {
    this.s = s;
  }

  //  Equals/hashCode
//  Equals:
//  - показывает, равны ли логически 2 обьекта
//	- по умолчанию:проверка на одно и то же место в памяти
//	- переопределение позволяет работать с Map(ключ)/Set предсказуемо
//  Контракт equals:
//  - Рефлексивность: if (x != null), x.equals(x) == true
//  - Симметричность: x.equals(y) == y.equals(x)
//  - Транзитивность: x.equals(y) == true, y.equals(z) == true, then x.equals(z) == true
//  - Согласованность: x.equals(y) == true каждый раз при неизменных обьектах
//  - Сравнение с null: x.equals(null) == false
  //  HashCode:
//  - генерирует положительный int для использования в хеш-таблицах
//	- null имеет hashCode 0
//  - необходимо переопределять hashCode везде, где был переопределен equals
//	- коллизия: когда у разных объектов одинаковые hashCode

//  Контракт HashCode:
//  - повторный вызов над одним обьектом, за один запуск приложения, должен дать тот же hashCode,
//  если поля обьекта не менялись
//	- если equals == true, то должны быть == по hashCode
//	- может вызывать одинаковый hashCode на equals == false (коллизии)
//
//  Контракт equals/hashcode:
//  - hashcode is less accurate that equals.
//  - equals == false, может дать hashcode == true


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }

    if (!super.equals(o)) {
      return false;
    }

    Cat cat = (Cat) o;

    if (i != cat.i) {
      return false;
    }
    return s != null ? s.equals(cat.s) : cat.s == null;
  }

  @Override
  public int hashCode() {
    int result = super.hashCode();
    result = 31 * result + (s != null ? s.hashCode() : 0);
    result = 31 * result + i;
    return result;
  }

  @Override
  public String toString() {
    return new StringJoiner(", ", Cat.class.getSimpleName() + "[", "]")
        .add("name='" + name + "'")
        .add("s='" + s + "'")
        .add("i=" + i)
        .toString();
  }

}
