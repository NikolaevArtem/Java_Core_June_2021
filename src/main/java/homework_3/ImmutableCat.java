package homework_3;

import java.util.ArrayList;

/*
    Список требований к ImmutableClass:
    - Класс должен быть final.
    - Поля класса должны быть private.
    - Поля класса должны быть final.
    - Параметризированные конструкторы должны инициализировать поля ссылочного типа,
     используя глубокое копирование.
    - В методых класса не изменяем поля класса, а возвращем его измененную копию.
 */

public final class ImmutableCat {

    private final String name;
    private final int yearOfBirth;
    private final ArrayList<String> favouriteFood = new ArrayList<>();


    public ImmutableCat(String name, int yearOfBirth, ArrayList<String> favouriteFood) {
        this.name = name;
        this.yearOfBirth = yearOfBirth;
        this.favouriteFood.addAll(favouriteFood);
    }

    public ImmutableCat(String name){
        this.name = name;
        yearOfBirth = 2020;
    }

    public ImmutableCat(){
        this.name = "Cat";
        yearOfBirth = 2020;
    }

    public String getName() {
        return name;
    }

    public ImmutableCat setName(String name) {
        return new ImmutableCat(name, this.yearOfBirth, this.favouriteFood);
    }

    public int getYearOfBirth() {
        return yearOfBirth;
    }

    public ImmutableCat setYearOfBirth(int yearOfBirth) {
        return new ImmutableCat(this.name, yearOfBirth, this.favouriteFood);
    }

    public ArrayList<String> getFavouriteFood() {
        return new ArrayList<>(favouriteFood);
    }

    public ImmutableCat setFavouriteFood(ArrayList<String> favouriteFood) {
        return new ImmutableCat(this.name, this.yearOfBirth, favouriteFood);
    }

    public ImmutableCat addFavouriteFoodItem(String favouriteFoodItem) {
        ArrayList<String> copyFF = new ArrayList<>(favouriteFood);
        copyFF.add(favouriteFoodItem);
        return new ImmutableCat(this.name, this.yearOfBirth, copyFF);
    }

}
