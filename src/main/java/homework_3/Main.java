package homework_3;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<String> testList = new ArrayList<>();
        testList.add("task1");
        Age age = new Age(13, 5, 1980);
        ImmutableWorker worker = new ImmutableWorker("Jones", "Marketing", 874, testList, age);
        testList.add("task2");
        System.out.println("testList size: " + testList.size());
        System.out.println(worker);
        System.out.println(worker.hashCode());
        ImmutableWorker worker1 = worker.updateWorker("Jackson", "Sales", 897, testList, age);
        System.out.println(worker1);
        System.out.println(worker1.hashCode());
        ImmutableWorker worker2 = worker.updateWorker(null, "Account", 0, null, null);
        System.out.println(worker2);
        System.out.println(worker2.hashCode());
        System.out.println(worker == worker1);
        System.out.println(worker1 == worker2);
    }
}
