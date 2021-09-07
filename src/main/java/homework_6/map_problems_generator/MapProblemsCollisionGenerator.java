package homework_6.map_problems_generator;

import java.util.Objects;

public class MapProblemsCollisionGenerator {
    private int problemNumber;
    private String problemName;

    public MapProblemsCollisionGenerator(int problemNumber, String problemName) {
        this.problemNumber = problemNumber;
        this.problemName = problemName;
    }

    public int getProblemNumber() {
        return problemNumber;
    }

    public void setProblemNumber(int problemNumber) {
        this.problemNumber = problemNumber;
    }

    public String getProblemName() {
        return problemName;
    }

    public void setProblemName(String problemName) {
        this.problemName = problemName;
    }

    @Override
    public boolean equals(Object o) {
        return true;
    }

    @Override
    public int hashCode() {
        return problemNumber;
    }
}
