package homework_6.map_problems;

import java.awt.*;

public abstract class MapProblemsGenerator {

    protected String clazzName;
    protected int clazzAge;
    protected Color clazzColor;

    public MapProblemsGenerator(String clazzName, int clazzAge, Color clazzColor) {
        this.clazzName = clazzName;
        this.clazzAge = clazzAge;
        this.clazzColor = clazzColor;
    }

    public String getClazzName() {
        return clazzName;
    }

    public void setClazzName(String clazzName) {
        this.clazzName = clazzName;
    }

    public int getClazzAge() {
        return clazzAge;
    }

    public void setClazzAge(int clazzAge) {
        this.clazzAge = clazzAge;
    }

    public Color getClazzColor() {
        return clazzColor;
    }

    public void setClazzColor(Color clazzColor) {
        this.clazzColor = clazzColor;
    }

}
