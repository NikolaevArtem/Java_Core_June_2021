package lesson_11.generics;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import lesson_11.generics.model.*;

public class Main {


  public static void main(String[] args) {
//    final DataHolder<String> stringDataHolder = new DataHolder<>();
//    stringDataHolder.setData("Hi!");
//    final String data = stringDataHolder.getData();
//
//    stringDataHolder.print("Hello");
//    stringDataHolder.process(5);

    final DataHolder<? extends Number> producer = new DataHolder<>();
    producer.setData(null);
    final Number data = producer.getData();

    final DataHolder<? super Number> consumer = new DataHolder<>();
    consumer.setData(5l);
    final Object data1 = consumer.getData();

//    Producer Extends, Consumer Super
// https://www.youtube.com/watch?v=_0c9Fd9FacU

    List<? extends Number> numbers = new ArrayList<Number>();
    List<? extends Number> numbers1 = new ArrayList<Integer>();
    List<? extends Number> numbers2 = new ArrayList<Long>();

//    numbers2.add(5L);

    List<? super Number> numbers3 = new ArrayList<Number>();
    List<? super Number> numbers4 = new ArrayList<Object>();
    numbers3.add(5);
//    numbers.add(new Object());

    // legacy code moved to generics
    Comparator comparator = new Comparator<Number>() {
      @Override
      public int compare(Number o1, Number o2) {
        return 0;
      }
    };

    final Integer max = Collections.max(new ArrayList<Integer>(), comparator);

    final ArrayList<? super Cat> catProducer = new ArrayList<>();
    catProducer.add(new Cat(5));
    final Object object = catProducer.get(0);
    Cat cat = (Cat) object;
    System.out.println(cat.getAge());

  }

}
