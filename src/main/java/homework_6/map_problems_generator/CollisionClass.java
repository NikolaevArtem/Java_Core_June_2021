package homework_6.map_problems_generator;

import lombok.Data;
import java.util.Calendar;

@Data
public class CollisionClass {
    private Calendar dateOfBirth;

    CollisionClass(Calendar dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    @Override
    public int hashCode() {
        return 1;
    }

    @Override
    public boolean equals(Object obj) {
        return dateOfBirth.equals(((CollisionClass) obj).getDateOfBirth());
    }

    @Override
    public String toString() {
        return dateOfBirth.getTime().toString();
    }
}

