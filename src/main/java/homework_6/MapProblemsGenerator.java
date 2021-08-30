package homework_6;

public class MapProblemsGenerator {

    public static class MapCollisionKey {

        private final String name;
        private int equalsCalls;    // If there is a collision, we have to call equals to resolve it

        public MapCollisionKey(String name) {
            this.name = name;
        }

        public int getEqualsCalls() {
            return equalsCalls;
        }

        @Override
        public boolean equals(Object obj) {
            equalsCalls++;
            if (this == obj) {
                return true;
            }
            if ((obj == null) || (obj.getClass() != this.getClass())) {
                return false;
            }
            MapCollisionKey col = (MapCollisionKey) obj;

            return name.equals(col.name);
        }

        @Override
        public int hashCode() {
            return 7;
        }
    }

    public static class MutableKey {

        private final StringBuilder name;

        public MutableKey(String name) {
            this.name = new StringBuilder(name);
        }

        public StringBuilder getName() {
            return name;
        }

        @Override
        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if ((obj == null) || (obj.getClass() != this.getClass())) {
                return false;
            }
            MutableKey mKey = (MutableKey) obj;

            return name.toString().equals(mKey.name.toString());
        }

        @Override
        public int hashCode() {
            return name.toString().hashCode();
        }
    }

}
