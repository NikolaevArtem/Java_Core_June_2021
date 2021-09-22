package homework_7.kitten_to_cat_function;

public class Kitten {
    private final String nameOfEnemy;
    private final String name;
    private final int age;

    public Kitten(String name, int age, String enemyName) {
        this.name = name;
        this.age = age;
        this.nameOfEnemy = enemyName;
    }

    public String getNameOfEnemy() {
        return nameOfEnemy;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    @Override
    public String toString() {
        return "Kitten's name: " + this.getName() +
                ", Kitten's age: " + this.getAge() +
                ", Kitten's enemy name: " + this.getNameOfEnemy() ;
    }
}
