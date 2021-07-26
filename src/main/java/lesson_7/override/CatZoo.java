package lesson_7.override;

public class CatZoo extends AnimalZoo {

  @Override
  public Cat getWhatIsInside() {
    return new Cat();
  }

}
