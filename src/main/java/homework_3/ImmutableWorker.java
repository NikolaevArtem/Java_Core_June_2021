package homework_3;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * In general immutable class means that once an object is created, we cannot change its content, so:
 * Immutable class should be final.
 * Its fields should be private final.
 * There should be getters but no setters.
 * For link objects there should be a deep copy in the constructor.
 * Constructor always creates a new object.
 */

public final class ImmutableWorker {
    private final String name;
    private final String department;
    private final int id;
    private final List<String> tasks;
    private final Age age;

    public ImmutableWorker(String name, String department, int id, List<String> tasks, Age age) {
        this.name = name;
        this.department = department;
        this.id = id;
        this.tasks = new ArrayList<>(tasks);
        this.age = new Age(age.getDay(), age.getMonth(), age.getYear());
    }

    public ImmutableWorker(String name, String department, int id, Age age) {
        this.name = name;
        this.department = department;
        this.id = id;
        this.tasks = new ArrayList<>();
        this.age = new Age(age.getDay(), age.getMonth(), age.getYear());
    }

    public ImmutableWorker(String name, int id, Age age) {
        this.name = name;
        this.department = "No department";
        this.id = id;
        this.tasks = new ArrayList<>();
        this.age = new Age(age.getDay(), age.getMonth(), age.getYear());
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

    public ImmutableWorker updateWorker(String name, String department, int id, List<String> tasks, Age age) {
        if (name == null) {
            name = this.getName();
        }
        if (department == null) {
            department = this.getDepartment();
        }
        if (id == 0) {
            id = this.getId();
        }
        if (tasks == null) {
            tasks = this.getTasks();
        }
        if (age == null) {
            age = this.getAge();
        }
        return new ImmutableWorker(name, department, id, tasks, age);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ImmutableWorker that = (ImmutableWorker) o;
        return getId() == that.getId() &&
                getName().equals(that.getName()) &&
                Objects.equals(getDepartment(), that.getDepartment()) &&
                Objects.equals(getTasks(), that.getTasks()) &&
                Objects.equals(getAge(), that.getAge());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getName(), getDepartment(), getId(), getTasks(), getAge());
    }

    @Override
    public String toString() {
        return "ImmutableWorker{" +
                "name='" + name + '\'' +
                ", department='" + department + '\'' +
                ", id=" + id +
                ", tasks_size=" + tasks.size() +
                ", age=" + age.getDay() + "." + age.getMonth() + "." + age.getYear() +
                '}';
    }
}
