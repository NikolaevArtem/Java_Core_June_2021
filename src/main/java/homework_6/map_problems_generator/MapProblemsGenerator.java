package homework_6.map_problems_generator;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.Objects;

public class MapProblemsGenerator {

    @AllArgsConstructor
    @Getter
    @Setter
    public static class MapProblemsCollisionGenerator {
        private int id;
        private String name;

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            MapProblemsCollisionGenerator that = (MapProblemsCollisionGenerator) o;
            return id == that.id && Objects.equals(name, that.name);
        }

        @Override
        public int hashCode() {
            return 1;
        }
    }

    @Data
    @AllArgsConstructor
    public static class MapProblemsMutableGenerator {
        private int id;
        private String name;
    }
}
