package homework_3;

import java.util.ArrayList;
import java.util.List;

/**
 * Immutable class:
 * 1. No setters
 * 2. Fields are private and final
 * 3. Never return any mutable field:
 * * return a copy
 * * return an immutable version of field
 * 4. Class must be final
 * 5. A parameterized constructor should init all the fields
 */
public final class ImmutableClass {
    private final int number;
    private final ArrayList<Integer> numbers;

    public ImmutableClass(int number) {
        this.number = number;
        this.numbers = new ArrayList<>(0);
    }

    public ImmutableClass(ArrayList<Integer> numbers) {
        this.number = 0;
        this.numbers = new ArrayList<>(numbers);
    }

    public ImmutableClass(int number, ArrayList<Integer> numbers) {
        this.number = number;
        this.numbers = new ArrayList<>(numbers);
    }

    public int getNumber() {
        return number;
    }

    public List<Integer> getNumbers() {
        return new ArrayList<>(numbers);
    }

    public ImmutableClass getWithModifiedNumber(int number) {
        return new ImmutableClass(number);
    }
}
