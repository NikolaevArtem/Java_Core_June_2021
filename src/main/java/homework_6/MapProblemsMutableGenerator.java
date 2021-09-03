package homework_6;

import java.util.Objects;

public class MapProblemsMutableGenerator {

private String name;

    @Override
    public boolean equals(Object o) {
        if(this == o) return true;
        if(o == null || getClass() != o.getClass()) return false;
        MapProblemsMutableGenerator that = (MapProblemsMutableGenerator) o;
        return Objects.equals(name, that.name);
    }

    public MapProblemsMutableGenerator(String name) {
        this.name = name;
    }



    @Override
    public int hashCode() {
        return 123;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
