package lesson_9.ex_handling;

import lombok.SneakyThrows;

public class ExceptionThrower {

  public void throwUnchecked() {
    throw new RuntimeException();
  }

  @SneakyThrows
  public void throwChecked() {
    throw new Exception();
  }

}
