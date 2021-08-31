package homework_6;

import java.util.Objects;
import java.util.Random;

public class MapProblemsMutableGenerator {
    private int id;
    private String name;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MapProblemsMutableGenerator that = (MapProblemsMutableGenerator) o;
        return id == that.id && Objects.equals(name, that.name);
    }

    @Override
    public int hashCode() {
        Random random = new Random();
        return random.nextInt(Integer.MAX_VALUE);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public MapProblemsMutableGenerator(int id, String name) {
        this.id = id;
        this.name = name;
    }
}
