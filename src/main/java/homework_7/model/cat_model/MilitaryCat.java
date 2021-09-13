package homework_7.model.cat_model;

import homework_7.model.Sex;

public class MilitaryCat extends Cat {

    public MilitaryCat(String firstName, int age, Sex sex, String worker) {
        super(firstName, age, sex, "Military");
    }

    public MilitaryCat(String name, int age, Sex sex) {
        super(name, age, sex, "Military");
    }

}
