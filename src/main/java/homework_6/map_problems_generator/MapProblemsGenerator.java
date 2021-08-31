package homework_6.map_problems_generator;

import java.util.Random;

public class MapProblemsGenerator {

    private int id;
    private String name;

    public MapProblemsGenerator(int id, String name) {
        this.id = id;
        this.name = name;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MapProblemsGenerator that = (MapProblemsGenerator) o;
        return id == that.id && name.equals(that.name);
    }

    @Override
    public int hashCode() {
        Random rnd = new Random();
        return rnd.nextInt(2021);
    }
}
