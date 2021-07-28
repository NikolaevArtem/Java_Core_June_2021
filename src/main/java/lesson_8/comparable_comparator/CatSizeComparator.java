package lesson_8.comparable_comparator;

import java.util.Comparator;

public class CatSizeComparator implements Comparator<Cat> {

  private int catWeight;
  private int anotherCatWeight;

  @Override
  public int compare(Cat o1, Cat o2) {
//    final String o1Size = o1.getSize();
//    if (o1Size.equals("s")) {
//      catWeight = 0;
//    } else if (o1Size.equals("m")) {
//      catWeight = 1;
//    } else {
//      catWeight = 2;
//    }
//
//    final String o2Size = o2.getSize();
//    if (o2Size.equals("s")) {
//      anotherCatWeight = 0;
//    } else if (o2Size.equals("m")) {
//      anotherCatWeight = 1;
//    } else {
//      anotherCatWeight = 2;
//    }
//
//    return catWeight - anotherCatWeight;
    return 0;
  }


}
