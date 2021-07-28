package lesson_8.enums;

public enum CatSize {

  XS(500),
  S(1000),
  M(1500),
  L(2500),
  XL(5000),
  XXL(10000);

  private int weight;

  CatSize(int weight) {
    this.weight = weight;
  }

  public int getWeight() {
    return weight;
  }

}
