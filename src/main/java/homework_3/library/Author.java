package homework_3.library;

import lombok.Data;
import lombok.NonNull;

@Data
public class Author {

    private String Name;
    private String Country;
    private String Century;

    public Author(String name) {
        if (name == null || "".equals(name.trim())) {
            throw new IllegalArgumentException();
        }
        Name = name;
    }

    public Author(String name, String country, String century) {
        if (name == null || "".equals(name.trim())) {
            throw new IllegalArgumentException();
        }
        Name = name;
        Country = country;
        Century = century;
    }

    @Override
    public String toString() {
        return Name;
    }
}
