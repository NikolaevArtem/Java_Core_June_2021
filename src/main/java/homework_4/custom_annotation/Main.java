package homework_4.custom_annotation;

import java.lang.reflect.InvocationTargetException;

public class Main {

    public static void main(String[] args) throws IllegalAccessException, InvocationTargetException {
        Cat cat = new Cat();
        DefaulValueImpl.insetDefaultValue(cat);
    }
}

class Cat {
    @DefaultValue("1")
    private int integer;
    @DefaultValue("1.0")
    private Double aDouble;
    @DefaultValue("awdawd")
    private String string;


    public Cat(Integer integer, Double aDouble, String string) {
        this.integer = integer;
        this.aDouble = aDouble;
        this.string = string;
    }

    public Cat() {
    }

    @DefaultValue("15")
    public int method(int i) {
        System.out.println(i);
        return i;
    }

    @DefaultValue("awdawd")
    private String method2(String i) {
        System.out.println(i);
        return i;
    }

    @DefaultValue("15.0")
    protected Double method(Double i) {
        System.out.println(i);
        return i;
    }

    public Integer getInteger() {
        return integer;
    }

    public Double getaDouble() {
        return aDouble;
    }

    public String getString() {
        return string;
    }
}