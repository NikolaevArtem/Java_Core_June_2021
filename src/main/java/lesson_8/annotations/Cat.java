package lesson_8.annotations;

import java.lang.reflect.Method;
import lombok.SneakyThrows;

@MyAnnotation(name = "Murzik")
public class Cat {

  @SneakyThrows
  @MyMethodAnnotation("Plushka")
  public void printName() {

    final Method method = this.getClass().getMethod("printName");
    System.out.println(method.getDeclaredAnnotation(MyMethodAnnotation.class).value());

  }

}
