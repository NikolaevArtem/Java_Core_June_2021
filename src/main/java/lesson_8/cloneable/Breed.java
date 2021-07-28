package lesson_8.cloneable;

import java.util.StringJoiner;

public class Breed implements Cloneable {

  private String breedName;

  public Breed(String breedName) {
    this.breedName = breedName;
  }

  @Override
  protected Breed clone() {
    return new Breed(breedName);
  }

  public String getBreedName() {
    return breedName;
  }

  public void setBreedName(String breedName) {
    this.breedName = breedName;
  }

  @Override
  public String toString() {
    return new StringJoiner(", ", Breed.class.getSimpleName() + "[", "]")
        .add("breedName='" + breedName + "'")
        .toString();
  }
}
