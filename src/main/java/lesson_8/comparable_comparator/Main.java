package lesson_8.comparable_comparator;

import java.util.Arrays;
import java.util.Comparator;
import lesson_8.enums.CatSize;

public class Main {

  public static void main(String[] args) {

    Cat[] cats = {
        new Cat("Murzik", 5, CatSize.XL),
        new Cat("Plushka", 7, CatSize.S),
        new Cat("Belka", 3, CatSize.M),
        new Cat("Strelka", 3, CatSize.M)
    };

    Comparator<Cat> byAgeAndByName = Comparator.comparing(Cat::getAge).thenComparing(Cat::getName);
    Comparator<Cat> bySize = Comparator.comparing(Cat::getSize);

    System.out.println("Before sort" + Arrays.toString(cats));
    Arrays.sort(cats, bySize);
    System.out.println("After sort" + Arrays.toString(cats));
  }

}
