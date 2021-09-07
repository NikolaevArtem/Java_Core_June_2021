package homework_6.map_problems_generator;

import java.util.Objects;

public class MapProblemsMutableGenerator {
    private int problemNumber;
    private String problemName;

    public MapProblemsMutableGenerator(int problemNumber, String problemName) {
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
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MapProblemsMutableGenerator that = (MapProblemsMutableGenerator) o;
        return problemNumber == that.problemNumber && Objects.equals(problemName, that.problemName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(problemNumber, problemName);
    }
}
