package homework_7;

public class Kitten extends Cat{
    private String nameMother;

    public Kitten(String name, int age, String nameMam) {
        super(name, age);
        nameMother = nameMam;
    }

    public String getNameMother() {
        return nameMother;
    }

    public void setNameMother(String nameMother) {
        this.nameMother = nameMother;
    }

    @Override
    public String toString() {
        return "Kitten{" +
                "nameMother='" + nameMother + '\'' +
                "} " + super.toString();
    }
}
