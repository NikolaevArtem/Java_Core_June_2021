package lesson_7.override;

public class AnimalZoo {

  // When overriding, we can:
  // change access modifiers (expand)
  // change return value (narrow)
  // change thrown exception (narrow)

  protected Animal getWhatIsInside() {
    return new Animal();
  }

}
