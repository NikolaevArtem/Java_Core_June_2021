package lesson_8.comparable_comparator;

import java.util.Comparator;

public class CatAgeComparator implements Comparator<Cat> {

  @Override
  public int compare(Cat o1, Cat o2) {
    return o1.getAge().compareTo(o2.getAge());
  }

}
