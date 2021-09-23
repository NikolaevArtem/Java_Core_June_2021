package homework_6.map_problems_generator;

import lombok.Data;

import java.util.Calendar;
import java.util.Random;

@Data
public class MutableClass {
    private Calendar dateOfBirth;

    MutableClass(Calendar dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    @Override
    public int hashCode() {
        return dateOfBirth == null ? 0 : dateOfBirth.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        return dateOfBirth.equals(((MutableClass) obj).getDateOfBirth());
    }

    @Override
    public String toString() {
        return dateOfBirth.getTime().toString();
    }
}

