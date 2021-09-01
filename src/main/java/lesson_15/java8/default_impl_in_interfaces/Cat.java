package lesson_15.java8.default_impl_in_interfaces;

public class Cat implements Printable {

  @Override
  public void print() {
    Printable.super.print();
  }
}
