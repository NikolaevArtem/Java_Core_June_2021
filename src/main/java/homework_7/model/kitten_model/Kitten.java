package homework_7.model.kitten_model;

import homework_7.model.Sex;

public class Kitten {

    protected String firstName;
    protected int age;
    protected Sex sex;

    public Kitten(String name, int age, Sex sex) {
        if (age > 18) throw new IllegalArgumentException("too old for kitten");
        this.firstName = name;
        this.age = age;
        this.sex = sex;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Sex getSex() {
        return sex;
    }

    public void setSex(Sex sex) {
        this.sex = sex;
    }

    @Override
    public String toString() {
        return "Kitten{" +
                "firstName='" + firstName + '\'' +
                ", age=" + age +
                ", sex=" + sex +
                '}';
    }
}
