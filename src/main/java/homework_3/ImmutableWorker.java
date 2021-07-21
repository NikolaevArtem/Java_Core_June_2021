package homework_3;

import java.util.ArrayList;
import java.util.List;


public final class ImmutableWorker {
    private final String name;
    private final String department;
    private final int id;
    private final List<String> tasks;
    private final Age age;

    public ImmutableWorker(String name, String department, int id, Age age) {
        this.name = name;
        this.department = department;
        this.id = id;
        this.tasks = new ArrayList<>();
        Age tempAge = new Age();
        tempAge.setDay(age.getDay());
        tempAge.setMonth(age.getMonth());
        tempAge.setYear(age.getYear());
        this.age = tempAge;
    }

    public ImmutableWorker(String name, String department, int id, List<String> tasks, Age age) {
        this.name = name;
        this.department = department;
        this.id = id;
        this.tasks = new ArrayList<>(tasks);
        Age tempAge = new Age();
        tempAge.setDay(age.getDay());
        tempAge.setMonth(age.getMonth());
        tempAge.setYear(age.getYear());
        this.age = tempAge;
    }

    public String getName() {
        return name;
    }

    public String getDepartment() {
        return department;
    }

    public int getId() {
        return id;
    }

    public List<String> getTasks() {
        return tasks;
    }

    public Age getAge() {
        return age;
    }
}
