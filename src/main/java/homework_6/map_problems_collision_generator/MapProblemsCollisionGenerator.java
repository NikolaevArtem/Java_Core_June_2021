package homework_6.map_problems_collision_generator;

public class MapProblemsCollisionGenerator {

    public GenerateCollisions getGenerateCollisions(String value) {
        return new GenerateCollisions(value);
    }

    public MutableClass getMutableClass(String value) {
        MutableClass mutableClass = new MutableClass();
        mutableClass.setVal(value);
        return mutableClass;
    }


}
