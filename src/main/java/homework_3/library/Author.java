package homework_3.library;

import lombok.Data;

@Data
public class Author {
    private String name;
    private String country;
    private String century;

    public Author(String name) {
        if (name == null || "".equals(name.trim())) {
            throw new IllegalArgumentException();
        }
        this.name = name;
    }

    public Author(String name, String country, String century) {
        if (name == null || "".equals(name.trim())) {
            throw new IllegalArgumentException();
        }
        this.name = name;
        this.country = country;
        this.century = century;
    }

    @Override
    public String toString() {
        return name;
    }
}
