package homework_7.kitten_to_cat_function;

public class Kitten extends Cat {
    private String parentName;

    public Kitten(String name, int age, String parentName) {
        super(name, age);
        this.parentName = parentName;
    }

    public String getParentName() {
        return parentName;
    }

    public void setParentName(String parentName) {
        this.parentName = parentName;
    }

    @Override
    public String toString() {
        return "Kitten{" +
                "parentName='" + parentName + '\'' +
                '}' + super.toString();
    }
}
