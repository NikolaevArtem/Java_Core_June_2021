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

    public ImmutableCat setNewName(String name){
        return new ImmutableCat(name);
    }

    public ImmutableCat setNewData(String name, int yearOfBirth, ArrayList<String> favouriteFood){
        return new ImmutableCat(name, yearOfBirth, favouriteFood);
    }
}
