package homework_6.map_problems_generator;

import java.util.Objects;

public class MapProblemsMutableGenerator {

    private String Name;
    private String nickName;
    private int age;

    public void setName(String name) {
        Name = name;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public MapProblemsMutableGenerator(String name, String nickName, int age) {
        Name = name;
        this.nickName = nickName;
        this.age = age;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MapProblemsMutableGenerator that = (MapProblemsMutableGenerator) o;
        return age == that.age && Objects.equals(Name, that.Name) && Objects.equals(nickName, that.nickName);
    }

    @Override
    public int hashCode() {
        //hashCode doesn't keep general contract

        //Whenever it is invoked on the same object more than once during an execution of a Java application,
        //the hashCode method must consistently return the same integer.
        // In other words for the same reference if MapProblemsMutableGenerator.equals() = true, hashCode() differs.

        return Objects.hash(Name, nickName, age);
    }
}
