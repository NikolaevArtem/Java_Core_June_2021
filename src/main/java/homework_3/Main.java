package homework_3;

import java.util.LinkedList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        ImmutableClass obj = new ImmutableClass(2, 3.0);
        obj.getAllDataList().forEach(System.out::println);
        List<Number> changes = new LinkedList<>();
        changes.add(1);
        changes.add(12.);
        changes.add(13);
        ImmutableClass obj2 = obj.getAllDataListChangeable(changes);
        obj2.getAllDataList().forEach(System.out::println);
    }

}
