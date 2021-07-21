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
        System.out.println("worker tasks list size: " + worker.getTasks().size());
        System.out.println("testList size: " + testList.size());
        age.setDay(5);
        System.out.println(age.getDay());
        System.out.println(worker.getAge().getDay());
        System.out.println(worker.getName());
        worker = worker.updateWorker("Jackson", "Sales", 897, testList, age);
        System.out.println(worker);
        worker = worker.updateWorker(null, "Account", 0, null, null);
        System.out.println(worker);
    }
}
