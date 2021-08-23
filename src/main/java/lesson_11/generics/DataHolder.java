package lesson_11.generics;

public class DataHolder <T extends Number> {

  private T data;

  public T getData() {
    return data;
  }

  public void setData(T data) {
    this.data = data;
  }

}
