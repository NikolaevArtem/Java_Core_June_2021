package homework_6.map_problems_generator;

import lombok.*;
import java.util.Objects;

public class MapProblemsGenerator {

    @Data
    @AllArgsConstructor
    public static class MapProblemsCollisionGenerator {
        private int number;
        private String name;

        @Override
        public boolean equals(Object object) {
            if (this == object) return true;
            if (object == null || getClass() != object.getClass()) return false;
            MapProblemsCollisionGenerator mpcg = (MapProblemsCollisionGenerator) object;
            return number == mpcg.number && Objects.equals(name, mpcg.name);
        }

        @Override
        public int hashCode() {
            return 1;
        }
    }

    @Data
    @AllArgsConstructor
    public static class MapProblemsMutableGenerator {
        private int number;
        private String name;
    }
}