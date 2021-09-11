package homework_7.kitten_to_cat_function;

import lombok.Data;

@Data
public class Cat {

    public enum Sex {
        MALE,
        FEMALE
    }

    private String name;
    private Sex sex;
    private int ageInYears;
    private String colour;

    public Cat(String name, Sex sex, int ageInYears, String colour) {
        this.name = name;
        this.sex = sex;
        this.ageInYears = ageInYears;
        this.colour = colour;
    }
}
