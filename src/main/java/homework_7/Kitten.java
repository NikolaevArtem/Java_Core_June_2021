package homework_7;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = false)
public class Kitten extends Cat {
    private int ageInMonths;
    private String motherName;
    private String fatherName;
    private int kittenInLitter;

    public Kitten(String name, Sex sex, String colour, int ageInMonths, String motherName, String fatherName, int kittenInLitter) {
        super(name, sex, 0, colour);
        this.ageInMonths = ageInMonths;
        this.motherName = motherName;
        this.fatherName = fatherName;
        this.kittenInLitter = kittenInLitter;
    }
}
