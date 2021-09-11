package homework_7.kitten_to_cat_function;

import lombok.Data;

@Data
public class Kitten {
    private String name;
    private Cat.Sex sex;
    private String colour;
    private int ageInMonths;
    private String motherName;
    private String fatherName;
    private int kittenInLitter;

    public Kitten(String name, Cat.Sex sex, String colour, int ageInMonths, String motherName, String fatherName, int kittenInLitter) {
        this.name = name;
        this.sex = sex;
        this.colour = colour;
        this.ageInMonths = ageInMonths;
        this.motherName = motherName;
        this.fatherName = fatherName;
        this.kittenInLitter = kittenInLitter;
    }
}
