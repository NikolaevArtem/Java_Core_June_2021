package homework_7.model.cat_model;

import homework_7.model.Sex;

public class Cat {

    protected String firstName;
    protected int age;
    protected Sex sex;
    protected String worker;

    public Cat(String firstName, int age, Sex sex) {
        this.firstName = firstName;
        this.age = age;
        this.sex = sex;
        this.worker = "unemployed";
    }

    public Cat(String firstName, int age, Sex sex, String worker) {
        this.firstName = firstName;
        this.age = age;
        this.sex = sex;
        this.worker = worker;
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

    public String getWorker() {
        return worker;
    }

    public void setWorker(String worker) {
        this.worker = worker;
    }

    @Override
    public String toString() {
        return "Cat{" +
                "firstName='" + firstName + '\'' +
                ", age=" + age +
                ", sex=" + sex +
                ", worker='" + worker + '\'' +
                '}';
    }
}
