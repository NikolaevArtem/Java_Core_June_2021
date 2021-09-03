package homework_6;

import java.util.Objects;

public class MapProblemsMutableGenerator {

    public String name;
    public boolean flag;
    public int age;

    public MapProblemsMutableGenerator(String name, boolean flag, int age) {
        this.name = name;
        this.flag = flag;
        this.age = age;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MapProblemsMutableGenerator that = (MapProblemsMutableGenerator) o;
        return flag == that.flag && age == that.age && Objects.equals(name, that.name);
    }

    @Override
    public int hashCode() {
        return (int) (Math.random() * age - name.length());
    }
}
